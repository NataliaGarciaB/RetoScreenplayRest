package co.com.sofka.stepdefinitions.services;

import co.com.sofka.questions.ResponseGet;
import co.com.sofka.questions.ResponsePostSuccesfull;
import co.com.sofka.questions.ResponsePostUnSuccesfull;
import co.com.sofka.stepdefinitions.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.tasks.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostStepDefinitions extends Setup {
    private static final Logger LOGGER = Logger.getLogger(PostStepDefinitions.class);

    @Given("el cliente se encuentra en Reqres")
    public void elClienteSeEncuentraEnReqres() {
        try {
            super.setupReqres();
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }
    }

    @When("el cliente solicita la peticion del servicio POST REGISTER")
    public void elClienteSolicitaLaPeticionDelServicioPOSTREGISTER() {
        try {
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RESOURCE_REQRES_POST_REGISTER)
                            .andTheBodyRequest("{\n" +
                                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                                    "    \"password\": \"pistol\"\n" +
                                    "}")
            );
            LOGGER.info("Comparacion exitosa");
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }

    }

    @Then("la respuesta del token deberia ser {string}")
    public void laRespuestaDelTokenDeberiaSer(String token) {
        try {
            actor.should(
                    seeThat("El codigo de respuesta deberia ser", ResponseGet.was(), equalTo(200)),
                    seeThat("el token deberia ser ", respuesta -> new ResponsePostSuccesfull().answeredBy(actor).getToken(), equalTo(token))
            );
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }

    }

    @Given("el cliente se encuentra en Reqres POST")
    public void elClienteSeEncuentraEnReqresPOST() {
        try {
            super.setupReqres();
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }

    }

    @When("el cliente solicita la peticion del servicio POST UNSUCCESFUL")
    public void elClienteSolicitaLaPeticionDelServicioPOSTUNSUCCESFUL() {
        try {
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RESOURCE_REQRES_POST_REGISTER)
                            .andTheBodyRequest("{\n" +
                                    "    \"email\": \"eve.holt@reqres.in\"\n" +
                                    "}")
            );
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }

    }

    @Then("la respuesta del mensaje deberia ser {string}")
    public void laRespuestaDelMensajeDeberiaSer(String mensajeError) {
        try {
            actor.should(
                    seeThat("El codigo de respuesta deberia ser", ResponseGet.was(), equalTo(400)),
                    seeThat("el mensaje deberia ser  ", respuesta -> new ResponsePostUnSuccesfull().answeredBy(actor).getError(), equalTo(mensajeError))
            );
            LOGGER.info("Comparacion exitosa");
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail("");
        }

    }

}
