<<<<<<< HEAD

import { entrar } from "./api.js";

// ELEMENTOS HTML
const formulario = document.getElementById("formLogin");

const campoEmail = document.getElementById("email");

const campoSenha = document.getElementById("senha");

const mensagemErro = document.getElementById("mensagemErro");

const botaoEntrar = document.getElementById("btnEntrar");

const botaoMostrarSenha = document.getElementById("mostrarSenha");


// VERIFICAR SE JÁ EXISTE UMA SESSÃO
if (localStorage.getItem("token")) {

    window.location.href = "./painel.html";

}


// MOSTRAR OU OCULTAR SENHA
botaoMostrarSenha.addEventListener("click", () => {

    const senhaVisivel = campoSenha.type === "text";

    campoSenha.type = senhaVisivel ? "password" : "text";

    botaoMostrarSenha.textContent = senhaVisivel
        ? "Mostrar"
        : "Ocultar";

});


// EVENTO DE LOGIN
formulario.addEventListener("submit", async (evento) => {

    evento.preventDefault();

    mensagemErro.textContent = "";

    const email = campoEmail.value.trim();

    const senha = campoSenha.value;


    // VALIDAR E-MAIL
    if (!/^\S+@\S+\.\S+$/.test(email)) {

        mensagemErro.textContent = "Informe um e-mail válido.";

        return;

    }


    // VALIDAR SENHA
    if (!senha) {

        mensagemErro.textContent = "Informe a senha.";

        return;

    }


    botaoEntrar.disabled = true;

    botaoEntrar.textContent = "Entrando...";


    try {

        // CHAMAR O BACKEND
        await entrar(email, senha);

        // REDIRECIONAR APÓS LOGIN
        window.location.href = "./painel.html";

    } catch (erro) {

        mensagemErro.textContent = erro.message;

    } finally {

        botaoEntrar.disabled = false;

        botaoEntrar.textContent = "Entrar";

    }

});
=======

import { entrar } from "./api.js";

// ELEMENTOS HTML
const formulario = document.getElementById("formLogin");

const campoEmail = document.getElementById("email");

const campoSenha = document.getElementById("senha");

const mensagemErro = document.getElementById("mensagemErro");

const botaoEntrar = document.getElementById("btnEntrar");

const botaoMostrarSenha = document.getElementById("mostrarSenha");


// VERIFICAR SE JÁ EXISTE UMA SESSÃO
if (localStorage.getItem("token")) {

    window.location.href = "./painel.html";

}


// MOSTRAR OU OCULTAR SENHA
botaoMostrarSenha.addEventListener("click", () => {

    const senhaVisivel = campoSenha.type === "text";

    campoSenha.type = senhaVisivel ? "password" : "text";

    botaoMostrarSenha.textContent = senhaVisivel
        ? "Mostrar"
        : "Ocultar";

});


// EVENTO DE LOGIN
formulario.addEventListener("submit", async (evento) => {

    evento.preventDefault();

    mensagemErro.textContent = "";

    const email = campoEmail.value.trim();

    const senha = campoSenha.value;


    // VALIDAR E-MAIL
    if (!/^\S+@\S+\.\S+$/.test(email)) {

        mensagemErro.textContent = "Informe um e-mail válido.";

        return;

    }


    // VALIDAR SENHA
    if (!senha) {

        mensagemErro.textContent = "Informe a senha.";

        return;

    }


    botaoEntrar.disabled = true;

    botaoEntrar.textContent = "Entrando...";


    try {

        // CHAMAR O BACKEND
        await entrar(email, senha);

        // REDIRECIONAR APÓS LOGIN
        window.location.href = "./painel.html";

    } catch (erro) {

        mensagemErro.textContent = erro.message;

    } finally {

        botaoEntrar.disabled = false;

        botaoEntrar.textContent = "Entrar";

    }

});
>>>>>>> 33cb5c8b847de7fa1924c41968c70122732670ff
