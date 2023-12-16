package page;

import base.BasePage;
import base.ConfigFileReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class FormularioPage extends BasePage {
    public FormularioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    ConfigFileReader configFileReader = new ConfigFileReader();

    @FindBy(xpath = "//img[@class='loader-gif']")
    public static WebElement loader;

    @FindBy(id = "nombre")
    private WebElement txtNombre;

    @FindBy(id = "apellido")
    private WebElement txtApellido;

    @FindBy(xpath = "//input[starts-with(@id,'mobile_')]")
    private WebElement txtNumeroTelefono;

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "department")
    private WebElement cbDepartamento;

    @FindBy(id = "picture")
    private WebElement btnImagen;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg mb-3']")
    private WebElement btnEnviar;

    @FindBy(id = "infoModalLabel")
    private WebElement lblInfoPersonal;

    public void ingresarUrl() {
        driver.get(configFileReader.getProp("url1"));
    }

    public void ingresarDatosFormulario(DataTable dataTable) {
        wait.until(ExpectedConditions.invisibilityOf(loader));
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            txtNombre.sendKeys(lista.get(i).get("Nombre"));
            txtApellido.sendKeys(lista.get(i).get("Apellido"));
            driver.findElement(By.xpath("//label[text()='" + lista.get(i).get("Pasatiempos") + "']")).click();
            driver.findElement(By.xpath("//label[text()='" + lista.get(i).get("Genero") + "']")).click();
        }


    }

    public void ingresarTelefonoYCorreo(String email) {
        String numeroAleatorio = new Random().ints(10, 0, 10)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        txtNumeroTelefono.sendKeys(numeroAleatorio);
        txtEmail.sendKeys(email);
    }

    public void seleccionarDepartamento(String departamento) {
        new Select(cbDepartamento).selectByValue(departamento);
        new Select(driver.findElement(By.id("city"))).selectByIndex(1);
    }

    public void seleccionarComandoSelenium() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(driver.findElement(By.xpath("//option[text()='Browser Commands']")))
                .click(driver.findElement(By.xpath("//option[text()='Navigation Commands']")))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void cargarImagen() throws InterruptedException {
        btnImagen.sendKeys("D:\\Proyectos Intellij\\SeleniumDiciembre2023\\src\\test\\resources\\data\\cucumber.png");
        Thread.sleep(5000);
    }

    public void clickEnviar() {
        btnEnviar.click();
    }

    public String validarMensajeInfo() {
        wait.until(ExpectedConditions.visibilityOf(lblInfoPersonal));
        return lblInfoPersonal.getText();
    }

    public String validarMensajeError() {
        wait.until(ExpectedConditions.invisibilityOf(loader));
        btnEnviar.click();
        String mensajeError = txtApellido.getAttribute("validationMessage");
        System.out.println("Error: " + mensajeError);
        return mensajeError;


    }

}
