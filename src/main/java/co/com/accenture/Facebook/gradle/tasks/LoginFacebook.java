package co.com.accenture.Facebook.gradle.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import co.com.accenture.Facebook.gradle.user_interfaces.FacebookLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class LoginFacebook implements Task {

	private String user;
	private String pass;

	public LoginFacebook(String user, String pass) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.pass = pass;
	}

	@Override
	@Step("{0} ingresar credenciales ")
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(Enter.theValue(user).into(FacebookLogin.EMAIL_FIELD),

				Enter.theValue(pass).into(FacebookLogin.PASS_FIELD).thenHit(ENTER));

	}

	public static LoginFacebook ingresar(String user, String pass) {
		// TODO Auto-generated method stub
		return instrumented(LoginFacebook.class, user, pass);
	}

}
