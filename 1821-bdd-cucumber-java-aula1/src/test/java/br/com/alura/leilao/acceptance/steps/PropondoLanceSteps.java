package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.datatable.DataTable;

public class PropondoLanceSteps {
	private Leilao leilao;
	private ArrayList<Lance> listaLances;
	
	@Before
	public void setup() {
		this.leilao = new Leilao("Tablet XPTO");
		this.listaLances = new ArrayList<Lance>();
	}
	
	@Dado("um lance valido")
	public void um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		Lance lance = new Lance(usuario, BigDecimal.TEN);
		this.listaLances.add(lance);
	}

	@Quando("propoe o lance ao leilao")
	public void propoe_o_lance() {
		this.leilao.propoe(this.listaLances.get(0));
	}
	
	@Entao("o lance e aceito")
	public void o_lance_e_aceito() {  
		Assertions.assertEquals(1, leilao.getLances().size());
		Assertions.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	/*
	 * @Dado("varios lances validos") public void varios_lances_validos() { Usuario
	 * usuario1 = new Usuario("fulano"); lance10 = new Lance(usuario1,
	 * BigDecimal.TEN); Usuario usuario2 = new Usuario("ciclano"); lance15 = new
	 * Lance(usuario2, new BigDecimal("15.0")); leilao = new
	 * Leilao("Triplex do Guarujá"); }
	 */
	
	//Uma alternativa às expressões du cucumber é as expressões regulares REGEX (exemplo abaixo)
	//@Dado("^um lance de (\\d+[.]\\d\\d?) reais do usuario (\\w+)$")
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double valor, String usuario) {
	    Lance lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
	    this.listaLances.add(lance);
	}

	@Quando("propoe os lances ao leilao")
	public void propoe_os_lances_ao_leilao() {
		//leilao.setLances(listaLances);
		this.listaLances.forEach(lance -> leilao.propoe(lance));
	}
	
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assertions.assertEquals(2, leilao.getLances().size());
		Assertions.assertEquals(this.listaLances.get(0).getValor(), this.leilao.getLances().get(0).getValor());
		Assertions.assertEquals(this.listaLances.get(1).getValor(), this.leilao.getLances().get(1).getValor());
	}
	
	@Dado("um lance invalido de {double} reais do usuario {string}")
	public void um_lance_invalido_de_reais_do_usuario(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new BigDecimal(valor));
		this.listaLances.add(lance);
	}
	
	@Dado("dois lances")
	public void dois_lances(DataTable dataTable) {
		List<Map<String, String>> valores = dataTable.asMaps();
		for(Map<String, String> mapa: valores) {
			
			String valor = mapa.get("valor");
			String usuario = mapa.get("usuario");
			
			Lance lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
			this.listaLances.add(lance);
		}
	}

	@Entao("o lance nao e aceito")
	public void o_lance_nao_e_aceito() {
	    Assertions.assertEquals(0, this.leilao.getLances().size());
	}
	
	@Entao("o segundo lance nao eh aceito")
	public void o_segundo_lance_nao_eh_aceito() {
	    Assertions.assertEquals(1, this.leilao.getLances().size());
	    Assertions.assertEquals(this.listaLances.get(0).getValor(), this.leilao.getLances().get(0).getValor());
	}

}
