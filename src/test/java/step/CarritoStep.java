package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.DatosPagoPage;
import page.DatosTarjetaPage;
import page.HomePage;

public class CarritoStep {

    HomePage homePage;

    DatosTarjetaPage datosTarjetaPage;

    DatosPagoPage datosPagoPage;

    public CarritoStep() {
        homePage= new HomePage(Hooks.driver);
        datosTarjetaPage= new DatosTarjetaPage(Hooks.driver);
        datosPagoPage= new DatosPagoPage(Hooks.driver);
    }

    @Given("la pagina DemoGuru esta disponible")
    public void laPaginaDemoGuruEstaDisponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("doy click en generar tarjeta")
    public void doyClickEnGenerarTarjeta() {
        homePage.clickGenerarTarjeta();
    }

    @And("capturo los datos de la tarjeta")
    public void capturoLosDatosDeLaTarjeta() {
        datosTarjetaPage.cambiarVentana();
        datosTarjetaPage.capturarTarjeta();
        datosTarjetaPage.capturarCvv();
        datosTarjetaPage.capturarFechaExp();
        datosTarjetaPage.cerrarVentana();
    }

    @And("selecciono una cantidad de productos al carrito y le doy comprar")
    public void seleccionoUnaCantidadDeProductosAlCarritoYLeDoyComprar() {
        homePage.seleccionarCant();
        homePage.clickComprar();
    }

    @Then("ingreso los datos de la tarjeta")
    public void ingresoLosDatosDeLaTarjeta() {
        datosPagoPage.ingresarDatos();
    }

    @And("agrego una cantidad {string} de productos al carrito")
    public void agregoUnaCantidadDeProductosAlCarrito(String cantProducto) {
        homePage.seleccionarCantFinal(cantProducto);
        homePage.clickComprar();
    }

    @Then("validamos que el pago fue exitoso {string}")
    public void validamosQueElPagoFueExitoso(String arg0) {
    }
}