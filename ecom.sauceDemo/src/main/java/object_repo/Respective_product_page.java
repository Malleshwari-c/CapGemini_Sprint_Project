package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Respective_product_page {
	protected WebDriver driver;
	public Respective_product_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[class='inventory_details_name large_size']")
	private WebElement pro_tit;
	
	@FindBy(id="add-to-cart")
	private WebElement add;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cart;
	
	@FindBy(id="back-to-products")
	private WebElement back;
	
	public String product_tit() {
		String productTitle=pro_tit.getText();
		return productTitle;
	}
	
	public void backHomePage() {
		back.click();
	}
	public void add2cart() {
		add.click();		
	}
	public void cartLogo() {
		cart.click();
	}

}
