package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProdutoPage extends BasePage {

    private final By precoSacola = By.cssSelector(".total-installment .money");
    private final By quantidadeNoCarrinho = By.cssSelector("input[data-testid='ptz-bag-product-quantity']");
    private final By precoProduto = By.cssSelector(".current-price-left strong");
    private final By btnAdicionarSacola = By.xpath("//button[@data-testid='ptz-button-add-to-bag']");
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public By getPrecoSacola() {
        return precoSacola;
    }

    public By getQuantidadeNoCarrinho() {
        return quantidadeNoCarrinho;
    }

    public By getPrecoProduto() {
        return precoProduto;
    }

    public By getBtnAdicionarSacola() {
        return btnAdicionarSacola;
    }

    public ProdutoPage(WebDriver driver) {
        super(driver);
    }


    public String capturarPreco() {
        return obterTexto(precoProduto);
    }


    public int quantidadeCarrinho() {
        return obterQuantidade(quantidadeNoCarrinho);
    }


    public void adicionarAoCarrinho() {
        clicar(btnAdicionarSacola);
        wait.until(ExpectedConditions.urlContains("checkout/cart"));

    }


    public String capturaPrecoSacola() {
        return obterTexto(precoSacola);

    }

    public void irAteOElemento(By xpathElemento) {
        WebElement elemento = driver.findElement(xpathElemento);
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'up'});",elemento);

    }
}
