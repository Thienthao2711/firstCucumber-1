package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageoject.SearchPage;

import static org.junit.Assert.*;

public class SearchStepDefinitions {
    WebDriver driver;
    SearchPage searchPage;

    @Before
    public void IniTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.searchPage = new SearchPage(this.driver);

    }

    @After
    public void AfterTest(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] ScreenShortArr = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(ScreenShortArr, "image/png", "error");

            this.driver.quit();

        }
    }

    @Given("^the google hompage is showed$")
    public void the_google_hompage_is_showed() throws Throwable {
        this.searchPage.openHomepage();

    }

    @When("^the user attempt to search with keyword \"([^\"]*)\"$")
    public void the_user_attempt_to_search_with_keyword_something(String keyword) throws Throwable {
        this.searchPage.TxtSearchGoogle.sendKeys(keyword);
        this.searchPage.TxtSearchGoogle.sendKeys(Keys.ENTER);
    }


    @Then("^List of Result is \"([^\"]*)\"showed$")
    public void list_of_result_is_somethingshowed(String result) throws Throwable {
        System.out.println("then compare");
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h2[class=\"qrShPb kno-ecr-pt PZPZlf mfMhoc\"]"))));
        String Expected = this.driver.findElement(By.cssSelector("h2[class=\"qrShPb kno-ecr-pt PZPZlf mfMhoc\"]")).getText();
        ;
        String Actual = "Java";
        System.out.println(Expected.equalsIgnoreCase(Actual));

        boolean Compare = Expected.equalsIgnoreCase(Actual);
        Assert.assertTrue(Compare);


      /*  String Abc = this.driver.getTitle();
        Assert.assertEquals(result, Abc);*/
    }

}
