package co.com.accenture.Facebook.gradle.util;



import co.com.accenture.Facebook.gradle.user_interfaces.FacebookHome;
import co.com.accenture.Facebook.gradle.user_interfaces.FacebookLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.UIStateReaderBuilder;


public class TheResult implements Question<String> {

	
	
    @Override
    public String answeredBy(Actor actor) {
                   // TODO Auto-generated method stub
                   return Text.of(FacebookHome.NAME_FIELD).viewedBy(actor).asString();
    }

    public static TheResult is( ) {
                   // TODO Auto-generated method stub
                   return new TheResult();
    }




}
