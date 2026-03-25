package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;
import pages.HomePage;
import pages.ProdutoPage;


public class Steps {
    WebDriver driver = new FirefoxDriver();
    HomePage home = new HomePage(driver);
    BasePage base = new BasePage(driver);
    ProdutoPage produtoPage = new ProdutoPage(driver);
    String precoCapturado;

    @Dado("que um usuario entra no site {string}")
    public void entrarNoSite(String url) {
//        driver.manage().window().setPosition(new Point(-2000, 0));
        driver.manage().window().maximize();
        driver.get(url);

    }

    @Quando("que seleciona um produto com o nome {string}")
    public void selecionaProduto(String nome) {
        home.buscarProduto(nome);
        //home.clicar(By.cssSelector("ptz-card-portrayal ptz-card-portrayal-md"));
        //home.clicar(By.xpath(("(//h3[contains(text(),'" + nome + "')])[3]")));
    }

    @E("na pagina do produto inclui o produto no carrinho e ir ate o carrinho de compra")
    public void incluirNoCarrinho() {
        precoCapturado = produtoPage.capturarPreco();
        produtoPage.adicionarAoCarrinho();
//      System.out.println(precoCapturado);
    }
        @E("verificar que no carrinho de compra so tenha {int} produto")
        public void unicoProdutoNoCarrinho(int quantidade) {
            int quantidadeNoCarrinho = produtoPage.quantidadeCarrinho();
            Assert.assertEquals(quantidadeNoCarrinho, quantidade);
            //      System.out.println(precoCapturado);
    }

    @Entao("devera verificar se estao corretos os valores do produto {string}")
    public void validarValores(String valorEsperado) {
        Assert.assertEquals(valorEsperado, precoCapturado);
        String precoSacola = produtoPage.capturaPrecoSacola();
//        System.out.println(precoSacola);
        Assert.assertEquals(valorEsperado, precoSacola);
        driver.quit();
    }

}