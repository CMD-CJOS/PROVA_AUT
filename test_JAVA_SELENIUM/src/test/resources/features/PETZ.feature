# language: pt

Funcionalidade: Comprar produto no site Petz
@cenarioPadrao
  Cenario: Validar o valor do produto Ração Selections For Pet para Cães Filhotes Mini/Pequenos Sabor Frango 3 kg no site Petz
    Dado que um usuario entra no site "https://www.petz.com.br/"
    Quando que seleciona um produto com o nome "Ração Selections For Pet para Cães Filhotes Mini/Pequenos Sabor Frango 3 kg"
    E na pagina do produto inclui o produto no carrinho e ir ate o carrinho de compra
    Entao devera verificar se estao corretos os valores do produto "R$ 60,99"

@cenarioPadrao
  Cenario: Validar o valor do produto Anti-inflamatório MSD Posatex 17,5ml no site Petz
    Dado que um usuario entra no site "https://www.petz.com.br/"
    Quando que seleciona um produto com o nome "Anti-inflamatório MSD Posatex 17,5ml"
    E na pagina do produto inclui o produto no carrinho e ir ate o carrinho de compra
    Entao devera verificar se estao corretos os valores do produto "R$ 152,50"

@validarQuantidadeNoCarrinho
  Cenario: Validar o valor do produto Brinquedo Arranhador São Pet Olimpus para Gatos Marrom no site Petz
      Dado que um usuario entra no site "https://www.petz.com.br/"
      Quando que seleciona um produto com o nome "Brinquedo Arranhador São Pet Olimpus para Gatos Marrom"
      E na pagina do produto inclui o produto no carrinho e ir ate o carrinho de compra
      E verificar que no carrinho de compra so tenha 1 produto
      Entao devera verificar se estao corretos os valores do produto "R$ 2.499,99"

