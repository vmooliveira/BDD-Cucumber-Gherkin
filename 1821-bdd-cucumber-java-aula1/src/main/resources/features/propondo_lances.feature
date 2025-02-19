# language: pt

Funcionalidade: Propondo lances ao leilao

Abaixo estão os cenários de teste de aceitação dessa funcionalidade.
Qualquer texto contido nesse espaço é ignorado pelo Cucumber.

Cenario: Propondo um unico lance valido
	Dado um lance valido
	Quando propoe o lance ao leilao
	Entao o lance e aceito
	
Cenario: Propondo varios lances validos
	Dado um lance de 10.0 reais do usuario "fulano"
	E um lance de 15.0 reais do usuario "ciclano"
	Quando propoe os lances ao leilao
	Entao os lances sao aceitos
	
Esquema do Cenario:  Propondo um lance invalido
	Dado um lance invalido de <valor> reais do usuario '<usuario>'
	Quando propoe o lance ao leilao
	Entao o lance nao e aceito
	
Exemplos: 
    | valor | usuario |
    |    0  | fulano  |
    |    -1 | ciclano |
    
Cenario: Propondo uma sequencia de lances
	Dado dois lances
	| valor | usuario |
  |    10 | fulano  |
  |    15 | fulano  |
	Quando propoe os lances ao leilao
	Entao o segundo lance nao eh aceito