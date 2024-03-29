package br.com.alura.leilao.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // a notação correta seria Extends porém o junit 5 ainda não suporta Cucumber
@CucumberOptions(features = "classpath:features")
//@CucumberOptions(features = "classpath:features", tags = "@leilao and not @login") roda só os testes que possuem a tag leilao e não possuem a tag @login 
public class LeilaoCucumberRunner {

}
