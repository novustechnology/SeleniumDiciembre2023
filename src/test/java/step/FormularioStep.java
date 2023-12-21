package step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.FormularioPage;

public class FormularioStep {

    FormularioPage formularioPage;

    public FormularioStep() {
        formularioPage= new FormularioPage(Hooks.driver);
    }

    @Given("ingreso a la pagina de NovusTechnology")
    public void ingresoALaPaginaDeNovusTechnology() {
        formularioPage.ingresarUrl();
    }

    @And("ingreso los datos del formulario")
    public void ingresoLosDatosDelFormulario(DataTable dataTable) {
        formularioPage.ingresarDatosFormulario(dataTable);
    }

    @And("ingreso el numero de telefono y correo electronico {string}")
    public void ingresoElNumeroDeTelefonoYCorreoElectronico(String email) {
        formularioPage.ingresarTelefonoYCorreo(email);
    }

    @And("seleccionamos un {string} y la primera ciudad")
    public void seleccionamosUnYLaPrimeraCiudad(String departamento) {
        formularioPage.seleccionarDepartamento(departamento);
    }

    @And("selecciono los comandos de selenium y cargo una imagen")
    public void seleccionoLosComandosDeSeleniumYCargoUnaImagen() throws InterruptedException {
        formularioPage.seleccionarComandoSelenium();
        formularioPage.cargarImagen();
    }

    @Then("hacemos click en el boton enviar y validamos el mensaje {string}")
    public void hacemosClickEnElBotonEnviarYValidamosElMensaje(String txtInfoPersonal) {
        formularioPage.clickEnviar();
        Assert.assertEquals(formularioPage.validarMensajeInfo(),txtInfoPersonal);
    }

    @Then("valido el mensaje de error {string}")
    public void validoElMensajeDeErorr(String txtError) {
        Assert.assertEquals(formularioPage.validarMensajeError(),txtError);
    }

    @Then("ingresamos la data")
    public void ingresamosLaData() {
    formularioPage.ingresarDatosCsv();
    }
}
