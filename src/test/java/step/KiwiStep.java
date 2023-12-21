package step;

import base.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.KiwiPage;

public class KiwiStep {

    KiwiPage kiwiPage;

    ConfigFileReader configFileReader = new ConfigFileReader();

    public KiwiStep() {
        kiwiPage= new KiwiPage(Hooks.driver);
    }

    @Given("el usuario ingresa a la pagina de Kiwi")
    public void elUsuarioIngresaALaPaginaDeKiwi() {
        Hooks.driver.get(configFileReader.getProp("url2"));
    }

    @When("selecciona el origen {string}")
    public void seleccionaElOrigen(String origen) throws InterruptedException {
        kiwiPage.clickAceptarCookies();
        kiwiPage.ingresarOrigen(origen);

    }
}
