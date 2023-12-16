package page;

import base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static page.FormularioPage.loader;

public class ToastAlertPage extends BasePage {
    public ToastAlertPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "liveToastBtn")
    private WebElement btnToast;


    @FindBy(id = "liveToast")
    private WebElement modalToast;

    @FindBy(id = "mostrarAlerta")
    private WebElement btnAlerta;


    public void clickToast() {
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.elementToBeClickable(btnToast)).click();
    }

    public boolean validarToast() {
        wait.until(ExpectedConditions.visibilityOf(modalToast));
        return modalToast.isDisplayed();
    }

    public void aceptarCancelarAlerta() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.elementToBeClickable(btnAlerta)).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        //Alert alerta = driver.switchTo().alert();
        //alerta.dismiss();
        Thread.sleep(4000);

    }

}
