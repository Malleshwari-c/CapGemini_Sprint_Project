package ecom.swaglabs.Add_to_cart;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import object_repo.Add_to_cart;
import object_repo.Inventory_page;

public class Functional_testcases_ATC extends Base_class{
	  @Test(groups= {"functional"})
	  public void fun1() {
		  Inventory_page ip = new Inventory_page(driver);
		  ip.addCart(2);
		  ip.cartLogo();
		  Add_to_cart adc = new Add_to_cart(driver);
		  adc.continue_shop();
		  String st = ip.pageTitle();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(st, "Products");  
	  }
	  
	  @Test(groups= {"functional","smoke"})
	  public void fun2() {
		  Inventory_page ip = new Inventory_page(driver);
		  ip.addCart(4);
		  Add_to_cart adc = new Add_to_cart(driver);
		  adc.remove_button();
		  String st = adc.cart_logo();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(st, "Cart, empty");  
	  }
	  
}
