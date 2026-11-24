
import { API_URL } from "./config.js";

// AUTENTICAÇÃO
export async function entrar(email, senha) {

    let resposta;
    try {
    resposta = await fetch(`${API_URL}/login`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            email: email,
            senha: senha
        })

    });
    } catch {
        throw new Error("Não foi possível conectar ao servidor. Verifique se o backend está rodando.");
    }

    let dados = {};
    try { dados = await resposta.json(); } catch { /* resposta sem JSON */ }

    if (!resposta.ok) {

        throw new Error(
            dados.message || "E-mail ou senha inválidos."
        );

    }

    // Armazena o JWT
    localStorage.setItem("token", dados.token);

    // Armazena os dados do usuário
    localStorage.setItem(
        "usuario",
        JSON.stringify(dados)
    );

    return dados;
}


// BUSCAR USUÁRIO AUTENTICADO
export async function buscarUsuario() {

    const token = localStorage.getItem("token");

    if (!token) {
        throw new Error("Usuário não autenticado.");
    }

    const resposta = await fetch(`${API_URL}/usuarios/me`, {

        method: "GET",

        headers: {
            "Authorization": `Bearer ${token}`
        }

    });

    if (!resposta.ok) {

        throw new Error("Não foi possível carregar os dados do usuário.");

    }

    return await resposta.json();
}


// ENCERRAR SESSÃO
export function sair() {

    localStorage.removeItem("token");

    localStorage.removeItem("usuario");

    window.location.href = "./index.html";

}
