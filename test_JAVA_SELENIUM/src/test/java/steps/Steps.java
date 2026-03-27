package steps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePage;
import pages.HomePage;
import pages.ProdutoPage;


public class Steps {
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);
    HomePage home = new HomePage(driver);
    ProdutoPage produtoPage = new ProdutoPage(driver);
    BasePage base = new BasePage(driver);
    String precoCapturado;



    @Dado("que um usuario entra no site {string}")
    public void entrarNoSite(String url) {
        driver.manage().window().maximize();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver.get(url);
        home.buscarCookies();
        base.zoomOut();
    }


    @Quando("que seleciona um produto com o nome {string}")
    public void selecionaProduto(String nome) {
        base.zoomOut();
        home.buscarProduto(nome);
    }


    @E("na pagina do produto inclui o produto no carrinho e ir ate o carrinho de compra")
    public void incluirNoCarrinho() {
        base.zoomOut();
        precoCapturado = produtoPage.capturarPreco();
        produtoPage.adicionarAoCarrinho();
    }


    @E("verificar que no carrinho de compra so tenha {int} produto")
    public void unicoProdutoNoCarrinho(int quantidade) {
        base.zoomOut();
        int quantidadeNoCarrinho = produtoPage.quantidadeCarrinho();
        Assert.assertEquals(quantidadeNoCarrinho, quantidade);
    }


    @Entao("devera verificar se estao corretos os valores do produto {string}")
    public void validarValores(String valorEsperado) {
        base.zoomOut();
        Assert.assertEquals(valorEsperado, precoCapturado);
        String precoSacola = produtoPage.capturaPrecoSacola();
        Assert.assertEquals(valorEsperado, precoSacola);
        driver.quit();
    }

}