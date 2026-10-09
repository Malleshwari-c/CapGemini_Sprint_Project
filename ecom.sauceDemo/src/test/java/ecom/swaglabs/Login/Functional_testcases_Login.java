package ecom.swaglabs.Login;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class_login_page;
import generic_utility.Common_data;
import object_repo.Inventory_page;
import object_repo.Login_page;

public class Functional_testcases_Login extends Base_class_login_page {
	  @Test(groups= {"functional"})
	  public void fun1() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.user_name(cd.USERNAME);
		   String UN = lp.get_userName();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(UN, "visual_user");
	  }
	  
	  @Test(groups= {"functional"})
	  public void fun2() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.pass_word(cd.PASSWORD);
		   String PW = lp.get_password();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(PW, "secret_sauce");
	  }
	  @Test(groups= {"integration"})
	  public void int1() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.login(cd.USERNAME, cd.PASSWORD);
		   Inventory_page ip = new Inventory_page(driver);
		   String val=ip.pageTitle();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(val, "Products");
	  }
	  
	}

