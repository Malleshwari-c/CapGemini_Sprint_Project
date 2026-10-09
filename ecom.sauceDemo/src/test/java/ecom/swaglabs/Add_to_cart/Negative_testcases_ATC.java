package ecom.swaglabs.Add_to_cart;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import object_repo.Add_to_cart;
import object_repo.Inventory_page;

public class Negative_testcases_ATC extends Base_class{
	  @Test(groups= {"negative","smoke"})
	  public void neg1() {
		  Inventory_page ip = new Inventory_page(driver);
		  ip.addCart(1);
		  ip.cartLogo();
		  Add_to_cart adc = new Add_to_cart(driver);
		  String st = adc.cart_logo();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(st, "Cart, empty");  
	  }
	  @Test(groups= {"negative","smoke"})
	  public void neg2() {
		  Inventory_page ip = new Inventory_page(driver);
		  ip.addCart(1);
		  ip.cartLogo();
		  Add_to_cart adc = new Add_to_cart(driver);
		  String st1 = adc.cart_logo();
		  driver.navigate().refresh();
		  String st2 = adc.cart_logo();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(st1, st2);
	  }
}
