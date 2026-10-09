package object_repo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_page {
	
	protected WebDriver driver;
	String productNumber;
	int p;
	
	public Inventory_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class='title']")
	private WebElement page_title;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cart_logo;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private List<WebElement> atc_button;
	
	@FindBy(xpath="//div[@data-test='inventory-item-name']")
	private List<WebElement> prod_name;
	
	@FindBy(xpath="//div[@class='inventory_item_img']")
	private List<WebElement> prod_img;

	@FindBy(id="react-burger-menu-btn")
	private WebElement menu_btn;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logout_btn;
	
	public void menuBtn() {
		menu_btn.click();
		logout_btn.click();
	}
	
	public String pageTitle() {
		String sl=page_title.getText();
		return sl;
	}
	
	public String getProdTitle(int n) {
		String pt=prod_name.get(n).getText();
		return pt;
	}
	
	public void addCart(int n) {
		atc_button.get(n).click();
	}
	
//	public void time() {
//		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		  wait.until(ExpectedConditions.condition());
//	}
	
	public void nameToProdPage(int n) {
		prod_name.get(n).click();
	}
	
	public void picToProdPage(int n) {
		prod_img.get(n).click();
	}
	
	public void cartLogo() {
		cart_logo.click();
	}
}
