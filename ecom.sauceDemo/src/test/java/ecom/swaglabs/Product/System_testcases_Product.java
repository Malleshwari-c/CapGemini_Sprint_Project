package ecom.swaglabs.Product;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Add_to_cart;
import object_repo.Checkout_page;
import object_repo.Complete_page;
import object_repo.Inventory_page;
import object_repo.Login_page;
import object_repo.Overview_page;
import object_repo.Respective_product_page;

public class System_testcases_Product extends Base_class{
  @Test(groups= {"system","smoke"})
  public void sys1() throws IOException {
	  Specific_data sd = new Specific_data();
	  sd.spData();
	  Inventory_page ip = new Inventory_page(driver);
	  ip.picToProdPage(1);
	  Respective_product_page rpp = new Respective_product_page(driver);
	  rpp.add2cart();
	  rpp.backHomePage();
	  ip.cartLogo();
	  Add_to_cart atc = new Add_to_cart(driver);
	  atc.checkOut();
	  Checkout_page cp = new Checkout_page(driver);
	  cp.enter_info(sd.FIRSTNAME, sd.LASTNAME, sd.POSTALCODE);
	  Overview_page op = new Overview_page(driver);
	  op.click_finish();
	  Complete_page com = new Complete_page(driver);
	  com.back_home();
  }
  @Test(groups= {"system"})
  public void sys2() throws IOException, InterruptedException {
	  Specific_data sd = new Specific_data();
	  sd.spData();
	  Inventory_page ip = new Inventory_page(driver);
	  ip.picToProdPage(1);
	  Thread.sleep(1000);
	  Respective_product_page rpp = new Respective_product_page(driver);
	  rpp.add2cart();
	  Thread.sleep(1000);
	  rpp.backHomePage();
	  Thread.sleep(1000);
	  ip.cartLogo();
	  Add_to_cart atc = new Add_to_cart(driver);
	  atc.checkOut();
	  Thread.sleep(1000);
	  Checkout_page cp = new Checkout_page(driver);
	  Thread.sleep(1000);
	  cp.enter_info(sd.FIRSTNAME, sd.LASTNAME, sd.POSTALCODE);
	  Overview_page op = new Overview_page(driver);
	  Thread.sleep(1000);
	  op.click_finish();
	  Complete_page com = new Complete_page(driver);
	  com.back_home();
	  Thread.sleep(1000);
	  ip.menuBtn();
	  Login_page lp = new Login_page(driver);
	  Thread.sleep(1000);
	  String login=lp.log_button();
	  SoftAssert s = new SoftAssert();
	  Thread.sleep(1000);
	  s.assertEquals(login, "Login");
  }
}

