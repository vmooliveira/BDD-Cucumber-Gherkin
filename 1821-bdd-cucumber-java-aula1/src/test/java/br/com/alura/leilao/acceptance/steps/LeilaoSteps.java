package br.com.alura.leilao.acceptance.steps;

import org.junit.jupiter.api.Assertions;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {
	
	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novoLeilaoPage;
	
	@Dado("um usuario logado")
	public void um_usuario_logado() {
		this.browser = new Browser();
		this.browser.seed();
		this.loginPage = browser.getLoginPage();
		this.leiloesPage = this.loginPage.realizaLoginComoFulano();
	}

	@Quando("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
		this.novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}
	@Quando("prenche o formulario com dados validos")
	public void prenche_o_formulario_com_dados_validos() {
		this.leiloesPage = this.novoLeilaoPage.preencheForm("iPhone 15 Pro", "5000.00", "15/03/2024");
	}
	@Entao("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
		Assertions.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
	}
	@Entao("o novo leilao aparece na tabela")
	public void o_novo_leilao_aparece_na_tabela() {
		Assertions.assertTrue(this.leiloesPage.existe("iPhone 15 Pro", "5000.00", "15/03/2024"));
		browser.clean();
	}
}
