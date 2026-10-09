package ecom.swaglabs.Add_to_cart;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Add_to_cart;
import object_repo.Checkout_page;
import object_repo.Complete_page;
import object_repo.Inventory_page;
import object_repo.Overview_page;

public class Smoke_testcases_ATC extends Base_class{
	  @Test(groups= {"smoke"})
	  public void smk1() throws IOException, InterruptedException, AWTException {
		  Specific_data test_data = new Specific_data();
		  test_data.spData();
		  Inventory_page ip = new Inventory_page(driver);
		  ip.addCart(1);
		  ip.addCart(2);
		  ip.addCart(3);
		  ip.cartLogo();
		  Add_to_cart adc = new Add_to_cart(driver);
		  adc.checkOut();
		  Checkout_page cp = new Checkout_page(driver);
		  cp.enter_info(test_data.FIRSTNAME, test_data.LASTNAME, test_data.POSTALCODE);
		  Overview_page op = new Overview_page(driver);
		  op.click_finish();
		  Complete_page cop = new Complete_page(driver);
		  cop.click_pdf();
		  Thread.sleep(1000);
		  cop.takeScreenshot();
	  }
	  

}

