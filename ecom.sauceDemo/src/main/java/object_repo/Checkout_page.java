package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_page {
WebDriver driver;
	
	public Checkout_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class='title']")
	private WebElement page_title;
	
	@FindBy(id="first-name")
	private WebElement fn;
	
	@FindBy(id="last-name")
	private WebElement ln;
	
	@FindBy(id="postal-code")
	private WebElement pc;
	
	@FindBy(id="continue")
	private WebElement con;
	
	
	public String pageTitle() {
		return page_title.getText();
	}
	
	public void enter_info(String FN,String LN,String ZPC) {
		fn.sendKeys(FN);
		ln.sendKeys(LN);
		pc.sendKeys(ZPC);
		con.click();
	}

}
