package br.com.alura.leilao.acceptance.steps;

import org.junit.jupiter.api.Assertions;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	
	Browser browser;
	LoginPage loginPage;

	@Dado("o usuario valido")
	public void o_usuario_valido() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
	}

	@Quando("realiza login")
	public void realiza_login() {
		loginPage.realizaLoginComo("fulano", "pass");
	}
	@Entao("e redirecionado para a pagina de leiloes")
	public void e_redirecionado_para_a_pagina_de_leiloes() {
		Assertions.assertTrue(loginPage.estaNaPaginaDeLeiloes());
		browser.clean();
	}
	
	@Dado("o usuario invalido")
	public void o_usuario_invalido() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
	}

	@Quando("tenta se logar")
	public void tenta_se_logar() {
		loginPage.realizaLoginComo("fail", "123");
	}
	@Entao("continua na página de login")
	public void continua_na_página_de_login() {
		Assertions.assertTrue(loginPage.estaNaPaginaDeLoginComErro());
		browser.clean();
	}
}
