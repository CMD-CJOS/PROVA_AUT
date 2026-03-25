package pages;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    private By campoBusca = By.id("headerSearch");
    private BasePage base = new BasePage(driver);
    public HomePage(WebDriver driver) { super(driver); }

    public void buscarProduto(String produto) {
        escrever(campoBusca, produto);
        driver.findElement(campoBusca).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ptz-card-image"))).click();
        //base.clicar(By.xpath("//*[contains(.,'"+produto+"')]"));.click()
    }
}