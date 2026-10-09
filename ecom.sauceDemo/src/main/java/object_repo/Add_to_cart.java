package object_repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_to_cart {
	protected WebDriver driver;
	String productTitle;
	public Add_to_cart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="continue-shopping")
	private WebElement con_shop;
	
	@FindBy(xpath="(//button[text()='Remove'])[1]")
	private WebElement rem_button;
	
	@FindBy(xpath="(//button[text()='Remove'])[3]")
	private WebElement rem_button3;
	
	@FindBy(css="[class='shopping_cart_link']")
	private WebElement clogo;
	
	@FindBy(css="[class='inventory_item_name']")
	private WebElement pro_tit;

	@FindBy(id="checkout")
	private WebElement checkout;
	
	@FindBy(xpath="//div[@data-test='inventory-item-name']")
	private List<WebElement> prod_tit;
	
	public void continue_shop() {
		con_shop.click();
	}
	
	public String cart_logo() {
		String c=clogo.getAttribute("aria-label");
		return c;
	}
	
	public void remove_button() {
		rem_button.click();
	}
	
	public String pro_tit(int n) {
		return prod_tit.get(n).getText();
	}
	
	public String product_title() {
		productTitle=pro_tit.getText();
		pro_tit.click();
		return productTitle;
	}
	
	public void checkOut() {
		checkout.click();
	}
	
	public void remLastEle() {
		System.out.println("zxcv");
		rem_button3.click();
	}

}
