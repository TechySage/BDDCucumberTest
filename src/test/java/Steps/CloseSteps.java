package Steps;

import io.cucumber.java.en.Then;

public class CloseSteps extends BaseSteps {
	
	@Then("Close browser")
	public void close_browser() {

		driver.close();
		// driver.quit();

		log.info("close the browser window page");

	}

}
