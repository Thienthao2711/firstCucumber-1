package pageoject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    WebDriver driver;
    @FindBy(name = "q")
    public WebElement TxtSearchGoogle;
    @FindBy(name = "btnk")
    public WebElement BtnSearchKeyword;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomepage() {
        this.driver.get("https://www.google.com.vn/");
        this.driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
    }

}
