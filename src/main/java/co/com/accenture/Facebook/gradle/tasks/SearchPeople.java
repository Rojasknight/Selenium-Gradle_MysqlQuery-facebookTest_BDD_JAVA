package co.com.accenture.Facebook.gradle.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import co.com.accenture.Facebook.gradle.user_interfaces.FacebookHome;
import co.com.accenture.Facebook.gradle.user_interfaces.FacebookLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SearchPeople implements Task {

	private String nombre;

	public SearchPeople(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}

	@Override
	@Step("{0} buscar por nombre  ")
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub

		actor.attemptsTo(Enter.theValue(nombre).into(FacebookHome.SEARCH_BOX).thenHit(ENTER),

				Click.on(FacebookHome.PEOPLE_BUTTON)

		);
		try {

			actor.attemptsTo(Click.on(FacebookHome.FIRST_ANSWER)

			);
		} catch (Exception e) {
			// TODO: handle exception

			try {

				System.out.println("Quizás existe un nombre mal escrito");
				actor.attemptsTo(

						Click.on(FacebookHome.FIRS_ANSWER_ALTERNATIVE)

				);

			} catch (Exception es) {

				System.out.println("No existe el usuario escrito no existe :" + nombre);

				// TODO: handle exception
			}

		}

	}

	public static SearchPeople ingresar(String nombre) {
		// TODO Auto-generated method stub
		return instrumented(SearchPeople.class, nombre);
	}

}
