package co.com.sofka.questions;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseGet implements Question<Integer> {

    public static Question<Integer> was() {
        return new ResponseGet();
    }


    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
