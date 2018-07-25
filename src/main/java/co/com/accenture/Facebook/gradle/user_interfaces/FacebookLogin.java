package co.com.accenture.Facebook.gradle.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.fb.com")
public class FacebookLogin extends PageObject {
//

	public static final Target EMAIL_FIELD = Target.the("Usuario Facebook").located(By.xpath("//*[@id=\"email\"]"));
	public static final Target PASS_FIELD = Target.the("Pass Facebook").located(By.xpath("//*[@id=\"pass\"]"));

	//
}
