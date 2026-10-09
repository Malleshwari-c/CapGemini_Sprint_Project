package ecom.swaglabs.Login;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class_login_page;
import generic_utility.Common_data;
import object_repo.Login_page;

public class Negative_testcases_Login extends Base_class_login_page {
	  @Test(groups= {"negative"})
	  public void fun_neg_1() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.user_name(cd.USERNAME);
		   Thread.sleep(2000);
		   lp.log_button();
		   String error_mess=lp.error_message();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(error_mess, "Epic sadface: Password is required");
	  }
	  
	  @Test(groups= {"negative"})
	  public void fun_neg_2() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.pass_word(cd.PASSWORD);
		   Thread.sleep(2000);
		   lp.log_button();
		   String error_mess=lp.error_message();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(error_mess, "Epic sadface: Username is required");
	  }
	  
	  @Test(groups= {"negative"})
	  public void fun_neg_3() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.log_button();
		   String error_mess=lp.error_message();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(error_mess, "Epic sadface: Username is required");
	  }
	  
	  @Test(groups= {"negative","smoke"})
	  public void fun_neg_4() throws IOException, InterruptedException {
		   Common_data cd = new Common_data();
		   cd.com_data();
		   Login_page lp = new Login_page(driver);
		   lp.login("invalid_username","invalid_password");
		   String error_mess=lp.error_message();
		   SoftAssert s=new SoftAssert();
		   s.assertEquals(error_mess, "Epic sadface: Username and password do not match any user in this service");
	  }
	}

