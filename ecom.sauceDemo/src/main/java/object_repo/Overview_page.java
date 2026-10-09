package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Overview_page {
WebDriver driver;
	
	public Overview_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="finish")
	private WebElement fin;
	

	public void click_finish() {
		fin.click();
	}

}
