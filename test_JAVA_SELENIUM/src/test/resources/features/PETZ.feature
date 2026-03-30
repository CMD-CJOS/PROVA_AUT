# language: pt

Funcionalidade: Comprar produto no site Petz
@cenarioPadrao
  Esquema do Cenario: Validar o valor do produto <produto>
    Dado que um usuario entra no site "https://www.petz.com.br/"
    Quando que seleciona um produto com o nome <produto>
    E na pagina do produto inclui o produto no carrinho e ir ate o carrinho de compra
    E verificar que no carrinho de compra so tenha 1 produto
    Entao devera verificar se estao corretos os valores do produto <valor>

    Exemplos:
      | produto                                                                       | valor         |
      | "Ração Selections For Pet para Cães Filhotes Mini/Pequenos Sabor Frango 3 kg" | "R$ 42,69"    |
      | "Anti-inflamatório MSD Posatex 17,5ml"                                        | "R$ 122,39"   |
      | "Brinquedo Arranhador São Pet Olimpus para Gatos Marrom"                      | "R$ 2.499,99" |