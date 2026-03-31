package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor jsExecutor;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void zoomOut() {

        this.jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.body.style.zoom = '70%';");

    }

    public void clicar(By by) {

        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void escrever(By by, String texto) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(texto);
    }

    protected String obterTexto(By by) {

        String text = wait.until(ExpectedConditions.presenceOfElementLocated(by)).getAttribute("innerHTML").trim();
        return text;
    }

    protected int obterQuantidade(By quantidade) {

        Integer quantidadeNaSacola = Integer.parseInt(wait.until(ExpectedConditions.presenceOfElementLocated(quantidade)).getAttribute("quantity").trim());
        return quantidadeNaSacola;
    }

    public void printTelaAtual(String nomeArquivo) throws IOException {

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pastaDestino = "C:\\Users\\colisouz\\OneDrive - NTT DATA EMEAL\\Imagens\\imagensAutomacao\\";
        FileUtils.copyFile(srcFile, new File(pastaDestino + nomeArquivo + ".png"));


    }

}