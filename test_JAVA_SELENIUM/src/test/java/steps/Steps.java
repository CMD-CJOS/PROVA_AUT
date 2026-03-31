package steps;
import io.cucumber.java.pt.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.HomePage;
import pages.ProdutoPage;

import java.io.IOException;
import java.time.Duration;


public class Steps {

    WebDriver driver = new ChromeDriver();
    HomePage home = new HomePage(driver);
    ProdutoPage produtoPage = new ProdutoPage(driver);
    BasePage base = new BasePage(driver);
    String precoCapturado;
    Point segundaTela = new Point(1920, 0);
    String nomeProduto;



    @Dado("que um usuario entra no site {string}")
    public void entrarNoSite(String url) throws IOException, InterruptedException {

        driver.manage().window().setPosition(segundaTela);
        driver.manage().window().maximize();
        driver.get(url);
        home.buscarCookies();
        base.zoomOut();
        Thread.sleep(5000);
        base.printTelaAtual("print_pagina_inicial");
    }

    @Quando("que seleciona um produto com o nome {string}")
    public void selecionaProduto(String nome) throws IOException, InterruptedException {

        this.nomeProduto = nome;
        base.zoomOut();
        home.buscarProduto(nome);
        produtoPage.irAteOElemento(produtoPage.getPrecoProduto());
        Thread.sleep(5000);
        base.printTelaAtual("print_pagina_produto_" + nomeProduto);
    }


    @E("na pagina do produto inclui o produto no carrinho e ir ate o carrinho de compra")
    public void incluirNoCarrinho() throws IOException, InterruptedException {

        base.zoomOut();
        precoCapturado = produtoPage.capturarPreco();
        produtoPage.irAteOElemento(produtoPage.getBtnAdicionarSacola());
        produtoPage.adicionarAoCarrinho();
        Thread.sleep(5000);
        base.printTelaAtual("print_pagina_produto_"+nomeProduto);

    }


    @E("verificar que no carrinho de compra so tenha {int} produto")
    public void unicoProdutoNoCarrinho(int quantidade) throws IOException, InterruptedException {

        base.zoomOut();
        int quantidadeNoCarrinho = produtoPage.quantidadeCarrinho();
        Assert.assertEquals(quantidadeNoCarrinho, quantidade);
        produtoPage.irAteOElemento(produtoPage.getQuantidadeNoCarrinho());
        Thread.sleep(5000);
        base.printTelaAtual("print_pagina_carrinho_inicial_"+nomeProduto);
    }


    @Entao("devera verificar se estao corretos os valores do produto {string}")
    public void validarValores(String valorEsperado) throws IOException, InterruptedException {

        base.zoomOut();
        Assert.assertEquals(valorEsperado, precoCapturado);
        String precoSacola = produtoPage.capturaPrecoSacola();
        produtoPage.irAteOElemento(produtoPage.getPrecoSacola());
        Assert.assertEquals(valorEsperado, precoSacola);
        Thread.sleep(5000);
        base.printTelaAtual("print_pagina_carrinho_final_"+nomeProduto);
        driver.quit();
    }

}