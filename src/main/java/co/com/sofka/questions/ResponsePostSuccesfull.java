package co.com.sofka.questions;

import co.com.sofka.models.PostModelSuccesfull;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponsePostSuccesfull implements Question <PostModelSuccesfull>{
    @Override
    public PostModelSuccesfull answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PostModelSuccesfull.class);
    }
}
