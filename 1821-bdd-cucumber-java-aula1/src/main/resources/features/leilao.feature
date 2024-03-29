# language: pt

@leilao
Funcionalidade: Cadastrando um leilao

	O que está abaixo do contexto roda antes de cada cenario
	Contexto: 
		Dado um usuario logado
		
  Cenario: Um usuario logado pode cadastrar um leilao
    Quando acessa a pagina de novo leilao
    E prenche o formulario com dados validos
    Entao volta para a pagina de leiloes
    E o novo leilao aparece na tabela 