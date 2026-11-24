import { API_URL } from "./config.js";
import { buscarUsuario, sair } from "./api.js";
import { RECURSOS } from "./recursos.js";

const GRUPOS = {
  "Estrutura": ["escolas", "eixos-tecnologicos", "areas-tecnologicas", "cursos", "planos-curso", "modulos", "unidades-curriculares"],
  "Perfil profissional": ["funcoes", "subfuncoes", "padroes-desempenho", "capacidades", "conhecimentos"],
  "Turmas": ["turmas", "alunos", "matriculas", "docentes-ucs"],
  "Situações de aprendizagem": ["situacoes-aprendizagem", "estrategias-ensino", "recursos-ambientes", "instrumentos-avaliacao", "criterios-avaliacao", "criterio-rubricas", "compartilhamentos", "historico-pdf"],
  "Administração": ["usuarios", "perfis"],
};
const $ = (id) => document.getElementById(id);
const porId = Object.fromEntries(RECURSOS.map((r) => [r.id, r]));
let atual = null, dados = [], editandoId = null;

async function api(caminho, opcoes = {}) {
  const r = await fetch(API_URL + caminho, { ...opcoes, headers: { "Content-Type": "application/json", Authorization: `Bearer ${localStorage.getItem("token")}` } });
  if (r.status === 401) { sair(); throw new Error("Sessão expirada."); }
  if (r.status === 403) throw new Error("Você não tem permissão para isso.");
  const texto = await r.text(); let corpo = null; try { corpo = texto ? JSON.parse(texto) : null; } catch { corpo = texto; }
  if (!r.ok) throw new Error(corpo?.message || corpo?.erro || `Erro ${r.status}`);
  return corpo;
}
const lista = (x) => Array.isArray(x) ? x : (x?.content || []);
const nomeDe = (o) => o?.nome || o?.titulo || o?.codigoTurma || o?.codigoPlano || o?.descricao || o?.topico || o?.nomeInstrumento || o?.nomeEstrategia || o?.descricaoCriterio || `#${o?.id}`;
const fmt = (v) => v == null ? "" : typeof v === "boolean" ? (v ? "Sim" : "Não") : Array.isArray(v) ? `${v.length} item(s)` : typeof v === "object" ? nomeDe(v) : String(v);

function montarMenu() {
  const nav = $("menuLista");
  nav.innerHTML = `<a href="#" data-id="">Início</a>` + Object.entries(GRUPOS).map(([g, ids]) =>
    `<h4>${g}</h4>` + ids.filter((i) => porId[i]).map((i) => `<a href="#${i}" data-id="${i}">${porId[i].titulo}</a>`).join("")).join("");
}
function marcarMenu() { document.querySelectorAll(".menu nav a").forEach((a) => a.classList.toggle("ativo", a.dataset.id === (atual?.id || ""))); }

async function inicio() {
  atual = null; marcarMenu(); $("tituloPagina").textContent = "Início"; $("btnNovo").hidden = $("busca").hidden = true; $("aviso").textContent = "";
  const principais = ["escolas", "cursos", "turmas", "alunos", "unidades-curriculares", "situacoes-aprendizagem", "usuarios"];
  $("area").innerHTML = `<div class="cards">${principais.map((i) => `<div class="card" data-id="${i}"><b id="n-${i}">…</b>${porId[i].titulo}</div>`).join("")}</div>`;
  document.querySelectorAll(".card").forEach((c) => c.onclick = () => location.hash = c.dataset.id);
  principais.forEach(async (i) => { try { $(`n-${i}`).textContent = lista(await api(porId[i].caminho)).length; } catch { $(`n-${i}`).textContent = "–"; } });
}

async function abrir(id) {
  atual = porId[id]; if (!atual) return inicio();
  marcarMenu(); $("tituloPagina").textContent = atual.titulo; $("btnNovo").hidden = $("busca").hidden = false; $("busca").value = ""; $("aviso").textContent = "";
  $("area").innerHTML = `<div class="vazio">Carregando...</div>`;
  try { dados = lista(await api(atual.caminho)); desenhar(); }
  catch (e) { dados = []; $("area").innerHTML = ""; $("aviso").textContent = e.message; }
}

function desenhar() {
  const termo = $("busca").value.toLowerCase();
  const linhas = dados.filter((o) => !termo || JSON.stringify(o).toLowerCase().includes(termo));
  if (!linhas.length) { $("area").innerHTML = `<div class="tabela"><div class="vazio">Nenhum registro.</div></div>`; return; }
  const cols = Object.keys(linhas[0]).filter((k) => !/senha|token/i.test(k)).slice(0, 7);
  $("area").innerHTML = `<div class="tabela"><table><thead><tr>${cols.map((c) => `<th>${c}</th>`).join("")}<th></th></tr></thead><tbody>${
    linhas.map((o) => `<tr>${cols.map((c) => `<td title="${esc(fmt(o[c]))}">${esc(fmt(o[c]))}</td>`).join("")}<td>${atual.editar ? `<button data-ed="${o.id}">Editar</button>` : ""}<button class="del" data-del="${o.id}">Excluir</button></td></tr>`).join("")}</tbody></table></div>`;
  document.querySelectorAll("[data-ed]").forEach((b) => b.onclick = () => abrirForm(dados.find((o) => String(o.id) === b.dataset.ed)));
  document.querySelectorAll("[data-del]").forEach((b) => b.onclick = () => excluir(b.dataset.del));
}
const esc = (s) => String(s).replace(/[&<>"]/g, (c) => ({ "&": "&amp;", "<": "&lt;", ">": "&gt;", '"': "&quot;" }[c]));

async function excluir(id) {
  if (!confirm("Excluir este registro?")) return;
  try { await api(`${atual.caminho}/${id}`, { method: "DELETE" }); abrir(atual.id); } catch (e) { $("aviso").textContent = e.message; }
}

function valorInicial(o, c) {
  if (!o) return c.tipo === "checkbox" ? true : "";
  if (o[c.nome] !== undefined) return o[c.nome];
  const base = c.nome.replace(/Ids?$/, "");
  const v = o[base] ?? o[base + "s"];
  if (c.tipo === "multi") return (o[c.nome.replace(/Ids$/, "s")] || []).map((x) => x.id ?? x);
  return v?.id ?? v ?? "";
}

async function abrirForm(o = null) {
  editandoId = o?.id ?? null; $("erroForm").textContent = "";
  $("tituloModal").textContent = (o ? "Editar " : "Novo — ") + atual.titulo;
  const html = await Promise.all(atual.campos.map(async (c) => {
    const v = valorInicial(o, c), n = `name="${c.nome}"`;
    if (c.tipo === "checkbox") return `<label class="check"><input type="checkbox" ${n} ${v ? "checked" : ""}> ${c.rotulo}</label>`;
    let campo;
    if (c.tipo === "textarea") campo = `<textarea ${n} rows="3">${esc(v)}</textarea>`;
    else if (c.tipo === "select") campo = `<select ${n}><option value="">Selecione</option>${c.opcoes.map((x) => `<option ${x === v ? "selected" : ""}>${x}</option>`).join("")}</select>`;
    else if (c.tipo === "ref" || c.tipo === "multi") {
      let ops = []; try { ops = c.ref ? lista(await api(c.ref)) : []; } catch {}
      const sel = (id) => c.tipo === "multi" ? (v || []).map(String).includes(String(id)) : String(v) === String(id);
      campo = ops.length || !c.ref
        ? `<select ${n} ${c.tipo === "multi" ? "multiple" : ""}>${c.tipo === "ref" ? `<option value="">Selecione</option>` : ""}${ops.map((x) => `<option value="${x.id}" ${sel(x.id) ? "selected" : ""}>${esc(nomeDe(x))}</option>`).join("")}</select>`
        : `<input ${n} type="number" value="${esc(v)}" placeholder="ID">`;
    } else campo = `<input ${n} type="${c.tipo}" value="${c.tipo === "password" ? "" : esc(String(v).slice(0, c.tipo === "date" ? 10 : 99999))}" ${c.tipo === "password" && o ? 'placeholder="Deixe em branco para manter"' : ""}>`;
    return `<label>${c.rotulo}</label>${campo}`;
  }));
  $("camposForm").innerHTML = html.join("");
  $("modal").showModal();
}

$("formRegistro").addEventListener("submit", async (ev) => {
  ev.preventDefault();
  const f = ev.target, corpo = {};
  for (const c of atual.campos) {
    const el = f.elements[c.nome]; if (!el) continue;
    if (c.tipo === "checkbox") corpo[c.nome] = el.checked;
    else if (c.tipo === "multi") corpo[c.nome] = [...el.selectedOptions].map((o) => Number(o.value));
    else if (["ref", "number"].includes(c.tipo)) corpo[c.nome] = el.value === "" ? null : Number(el.value);
    else if (c.tipo === "password" && !el.value && editandoId) continue;
    else corpo[c.nome] = el.value === "" ? null : el.value;
  }
  try {
    await api(editandoId ? `${atual.caminho}/${editandoId}` : atual.caminho, { method: editandoId ? "PUT" : "POST", body: JSON.stringify(corpo) });
    $("modal").close(); abrir(atual.id);
  } catch (e) { $("erroForm").textContent = e.message; }
});
$("btnCancelar").onclick = () => $("modal").close();
$("btnNovo").onclick = () => abrirForm();
$("busca").oninput = desenhar;
$("btnSair").onclick = sair;
window.addEventListener("hashchange", () => location.hash.slice(1) ? abrir(location.hash.slice(1)) : inicio());

try {
  const u = await buscarUsuario();
  $("nomeUsuario").textContent = u.nome; $("perfilUsuario").textContent = u.perfil?.nome || u.perfil || "";
} catch { localStorage.removeItem("token"); localStorage.removeItem("usuario"); location.href = "./index.html"; }
montarMenu();
location.hash.slice(1) ? abrir(location.hash.slice(1)) : inicio();
