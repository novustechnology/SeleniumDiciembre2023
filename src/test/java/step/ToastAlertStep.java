package step;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.ToastAlertPage;

public class ToastAlertStep {


    ToastAlertPage toastAlertPage;

    public ToastAlertStep() {
        toastAlertPage = new ToastAlertPage(Hooks.driver);
    }

    @When("doy click al boton Toast")
    public void doyClickAlBotonToast() {
        toastAlertPage.clickToast();
    }

    @Then("valido que se muestre el Toast")
    public void validoQueSeMuestreElToast() {
        Assert.assertTrue("El toast no se mostró correctamente", toastAlertPage.validarToast());
    }

    @Then("valido que al aceptar se abra una nueva ventana y al cancelar no haga nada")
    public void validoQueAlAceptarSeAbraUnaNuevaVentanaYAlCancelarNoHagaNada() throws InterruptedException {
        toastAlertPage.aceptarCancelarAlerta();
    }
}
