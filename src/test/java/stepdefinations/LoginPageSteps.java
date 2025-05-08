/**
 * 
 */
package stepdefinations;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;
import org.junit.Assert;

/**
 * 
 */
public class LoginPageSteps {
	
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private static String titleName;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    
		DriverFactory.getDriver().get("https://the-internet.herokuapp.com/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    titleName= loginPage.getLoginPageTitle();
	    System.out.println("Login page title is: "+ titleName);
	    
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
			Assert.assertTrue(titleName.contains(expectedTitle));
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);	    
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
	}

	

}
