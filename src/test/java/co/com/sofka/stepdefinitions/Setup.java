package co.com.sofka.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Setup {

    protected static final String URL_BASE_PAGE = "https://reqres.in/api";
    protected static final String RESOURCE_REQRES_GET12 = "/users/12";
    protected static final String RESOURCE_REQRES_GET23 = "/users/23";
    protected static final String RESOURCE_REQRES_POST_REGISTER = "/register";


    protected final Actor actor = new Actor("Natalia");

    protected void setupReqres () {
        actorCanReqres();
    }

    private void actorCanReqres () {
        actor.can(CallAnApi.at(URL_BASE_PAGE));
    }


}
