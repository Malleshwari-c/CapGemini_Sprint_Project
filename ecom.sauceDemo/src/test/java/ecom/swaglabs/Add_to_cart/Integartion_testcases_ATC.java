package ecom.swaglabs.Add_to_cart;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import object_repo.Add_to_cart;
import object_repo.Checkout_page;
import object_repo.Inventory_page;
import object_repo.Respective_product_page;

public class Integartion_testcases_ATC extends Base_class{
	  @Test(groups= {"integration"})
	  public void int1() {
		  Inventory_page ip = new Inventory_page(driver);
		  ip.addCart(1);
		  ip.cartLogo();
		  Add_to_cart adc = new Add_to_cart(driver);
		  String cp=adc.product_title();
		  Respective_product_page rp = new Respective_product_page(driver);
		  String title = rp.product_tit();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(cp,title); 
	  }
	  @Test(groups= {"integration","smoke"})
	  public void int2() {
		  Inventory_page ip = new Inventory_page(driver);
		  ip.addCart(0);
		  ip.cartLogo();
		  Add_to_cart adc = new Add_to_cart(driver);
		  adc.cart_logo();
		  Checkout_page cp=new Checkout_page(driver);
		  String title=cp.pageTitle();
		  SoftAssert s=new SoftAssert();
		  s.assertEquals(title,"Checkout: Your Information");
	  }
	  
}

