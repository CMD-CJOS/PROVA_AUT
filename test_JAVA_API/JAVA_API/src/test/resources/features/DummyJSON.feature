# language: pt

Funcionalidade: Criação e Validação de Produtos via API

@validarCriacaoProdutoSerum
  Cenario: Validar a criacao de um novo produto Serum
    Quando eu envio um POST para "/products/add" com os dados do produto "Serum"
    Entao o status code da resposta deve ser 201
    E o corpo da resposta deve conter o "title" como "Hyaluronic Acid Serum"

@validarCriacaoProdutoSerum
  Cenario: Validar a consulta de um produto por ID
    Dado que existe um produto cadastrado com ID 1
    Quando eu envio um GET para "/products/" com ID 1
    Entao o status code da resposta deve ser 200
    E o titulo do produto retornado deve ser "Essence Mascara Lash Princess"
    E a marca do produto deve ser "Essence"

@validarCriacaoProdutoMascaraLash
  Cenario: Validar a criacao de um novo produto Mascara Lash
    Quando eu envio um POST para "/products/add" com os dados do produto "Mascara Lash"
    Entao o status code da resposta deve ser 201
    E o corpo da resposta deve conter o "title" como "Essence Mascara Lash Princess"

@validarCriacaoProdutoMascaraLash
  Cenario: Validar a consulta de um produto por ID
    Dado que existe um produto cadastrado com ID 1
    Quando eu envio um GET para "/products/" com ID 1
    Entao o status code da resposta deve ser 200
    E o titulo do produto retornado deve ser "Essence Mascara Lash Princess"
    E a marca do produto deve ser "Essence"

@validarCriacaoProdutoCucumber
  Cenario: Validar a criacao de um novo produto Cucumber
    Quando eu envio um POST para "/products/add" com os dados do produto "Cucumber"
    Entao o status code da resposta deve ser 201
    E o corpo da resposta deve conter o "title" como "Cucumber"

@validarCriacaoProdutoCucumber
  Cenario: Validar a consulta de um produto por ID
    Dado que existe um produto cadastrado com ID 21
    Quando eu envio um GET para "/products/" com ID 21
    Entao o status code da resposta deve ser 200
    E o titulo do produto retornado deve ser "Cucumber"
    E a categoria do produto deve ser "groceries"