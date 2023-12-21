package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KiwiPage extends BasePage {
    public KiwiPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "cookies_accept")
    private WebElement btnAceptarCookies;

    @FindBy(xpath = "//div[@data-test='PlacePickerInputPlace-close']")
    private WebElement btnCerrarOrigen;

    @FindBy(xpath = "(//input[@data-test='SearchField-input'])[1]")
    private WebElement txtOrigen;


    public void clickAceptarCookies(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAceptarCookies)).click();
    }

    public void ingresarOrigen(String origen) throws InterruptedException {
        btnCerrarOrigen.click();
        txtOrigen.sendKeys(origen);


        Thread.sleep(3000);
        List<WebElement> optionList = driver.findElements(By.xpath("//div[@data-test='PlacePickerRow-wrapper']"));

        //ver todos los elementos dentro de la lista
        //optionList.forEach(ele-> System.out.println(ele.getText()));

        for(WebElement element:optionList){
            System.out.println("elemento: "+element.getText());

            if (element.getText().contains(origen)){
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
        }
    }



}
