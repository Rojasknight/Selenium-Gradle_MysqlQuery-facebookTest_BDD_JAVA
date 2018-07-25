package co.com.accenture.Facebook.gradle.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FacebookHome  extends PageObject {

	

	public static final Target SEARCH_BOX = Target.the("Barra de busqueda Facebook").located(By.name("q"));

	public static final Target PEOPLE_BUTTON = Target.the("Barra de busqueda People")
			.located(By.xpath("//div[@class='_4xjz'][contains(text(),'People')]"));

	public static final Target FIRST_ANSWER = Target.the("Primer resultado").located(By.xpath(
			"/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
			//"/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));

	public static final Target FIRS_ANSWER_ALTERNATIVE = Target.the("Primer resultado cuando el nombre esta").located(By.xpath(
			//"//img[@class='_2yeu img']"));
			"//div[@id='xt_uniq_3']//img[@class='_2yeu img']"));

	public static final Target NAME_FIELD = Target.the("Nombre de la Persona")
			.located(By.xpath("//a[@class='_2nlw _2nlv']"));

	public static final Target ANSWER_WRONG = Target.the("No encuentra la persona").located(By.xpath(
			"/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]"));

}
