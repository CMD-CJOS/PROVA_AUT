package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {


    private final By campoBusca = By.id("headerSearch");
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void buscarProduto(String produto) {
        escrever(campoBusca, produto);
        driver.findElement(campoBusca).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ptz-card-image"))).click();
    }

    public void buscarCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnCookie = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));
        jsExecutor.executeScript("arguments[0].click();", btnCookie);
    }



}