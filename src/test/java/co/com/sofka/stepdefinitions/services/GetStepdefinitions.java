package co.com.sofka.stepdefinitions.services;

import co.com.sofka.questions.ResponseGet;
import co.com.sofka.stepdefinitions.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetStepdefinitions extends Setup {
    private static final Logger LOGGER = Logger.getLogger(GetStepdefinitions.class);

    @Given("el cliente se encunetra en el dominio Reqres")
    public void elClienteSeEncunetraEnElDominioReqres() {
        try {
            super.setupReqres();
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }
    }

    @When("el cliente realiza la peticion del servicio GET")
    public void elClienteRealizaLaPeticionDelServicioGET() {
        try {
            actor.attemptsTo(
                    doGet().withTheResource(RESOURCE_REQRES_GET23)
            );
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }
    }

    @Then("la respues del servicio deberia de ser {int}")
    public void laRespuesDelServicioDeberiaDeSer(Integer Code) {
        try {
            actor.should(
                    seeThat("El status de codigo es: ",
                            ResponseGet.was(), equalTo(Code)
                    )
            );
            LOGGER.info("Comparacion exitosa");
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }

    }

    @Given("el cliente se encunetra en el dominio Reqres principal")
    public void elClienteSeEncunetraEnElDominioReqresPrincipal() {
        try {
            super.setupReqres();
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }
    }

    @When("el cliente realiza la peticion del servicio")
    public void elClienteRealizaLaPeticionDelServicio() {
        try {
            actor.attemptsTo(
                    doGet().withTheResource(RESOURCE_REQRES_GET12)
            );
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }
    }

    @Then("el codigo respuesta deberia ser {int}")
    public void elNombreDeUsuarioEnElServicioDeberiaSer(Integer Code) {
        try {

            actor.should(
                    seeThat("El status de codigo es: ",
                            ResponseGet.was(), equalTo(Code)
                    )
            );
            LOGGER.info("Comparacion exitosa");
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }

    }

}
