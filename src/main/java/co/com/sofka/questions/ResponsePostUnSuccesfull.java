package co.com.sofka.questions;


import co.com.sofka.models.PostModelUnSuccesfull;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponsePostUnSuccesfull implements Question <PostModelUnSuccesfull>{
    @Override
    public PostModelUnSuccesfull answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PostModelUnSuccesfull.class);
    }
}
