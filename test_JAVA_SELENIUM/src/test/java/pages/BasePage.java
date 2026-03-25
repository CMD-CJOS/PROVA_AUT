package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clicar(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void escrever(By by, String texto) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(texto);
    }

    protected String obterTexto(By by) {
//        return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getText();
        return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getAttribute("innerHTML").trim();
    }

    protected int obterQuantidade(By quantidade) {
        return Integer.parseInt(wait.until(ExpectedConditions.presenceOfElementLocated(quantidade)).getAttribute("quantity").trim());
    }

}