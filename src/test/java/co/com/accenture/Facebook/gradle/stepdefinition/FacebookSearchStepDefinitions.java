package co.com.accenture.Facebook.gradle.stepdefinition;

//import org.junit.Before;
import org.openqa.selenium.WebDriver;

import co.com.accenture.Facebook.gradle.tasks.LoginFacebook;
import co.com.accenture.Facebook.gradle.tasks.OpenTheBrowser;
import co.com.accenture.Facebook.gradle.tasks.SearchPeople;
import co.com.accenture.Facebook.gradle.user_interfaces.FacebookLogin;
import co.com.accenture.Facebook.gradle.util.ConnectMysql;
import co.com.accenture.Facebook.gradle.util.TheResult;
import co.com.accenture.Facebook.gradle.util.Usuario;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class FacebookSearchStepDefinitions {

	@Managed(driver = "chrome")
	private WebDriver herBrowser;
	private Actor juanita = Actor.named("Juanita");
	private FacebookLogin facebook;

	@Before
	public void setup() {

		juanita.can(BrowseTheWeb.with(herBrowser)); // Se le asigna el driver al actor
		// juanita.wasAbleTo(OpenTheBrowser.at(facebook));
		// herBrowser.manage().
		herBrowser.manage().window().maximize();
	}

	@Given("^El usuario  abre el navegador en facebook.com$")
	public void thatTheUserOpenedTheBrowserAt() throws Exception {
		juanita.wasAbleTo(OpenTheBrowser.at(facebook));

	}

	@When("^El usuario ingresas su correo (.*) y su contrasena (.*)$")
	public void ingresarCredencialesFacebook(String usuario, String passs) throws Exception {

		// Esta clase encapsula mi datos personas, aunque recibe el correo y la
		// contraseña no las utilizo porque las tengo encapsuladas
		Usuario user = new Usuario();

		juanita.attemptsTo(LoginFacebook.ingresar(user.getUsuario(), user.getPass()));
		System.out.println("");
	}

	@When("^El usuario busca las personas de la lista e ingresa a su perfil$")
	public void buscarPersona() throws Exception {

		int i;

		ConnectMysql x = new ConnectMysql();

		ArrayList<String> listDatos = x.connectDatabase();

		for (i = 0; i < listDatos.size(); i++) {
			System.out.println(listDatos.get(i));

			juanita.attemptsTo(SearchPeople.ingresar(listDatos.get(i).toString()));

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String nombre = TheResult.is().answeredBy(juanita).toString().split(Pattern.quote(" ("))[0];

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
