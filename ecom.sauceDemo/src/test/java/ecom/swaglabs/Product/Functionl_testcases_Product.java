package ecom.swaglabs.Product;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import object_repo.Inventory_page;
import object_repo.Login_page;
import object_repo.Respective_product_page;

public class Functionl_testcases_Product extends Base_class{
  @Test(groups= {"functional"})
  public void fun1() {
	  Inventory_page ip = new Inventory_page(driver);
	  String title=ip.getProdTitle(4);
	  ip.nameToProdPage(4);
	  Respective_product_page rpp = new Respective_product_page(driver);
	  String titleName=rpp.product_tit();
	  SoftAssert s = new SoftAssert();
	  s.assertEquals(title, titleName);
  }
  @Test(groups= {"functional"})
  public void fun2() {
	  Inventory_page ip = new Inventory_page(driver);
	  String title=ip.getProdTitle(2);
	  ip.picToProdPage(2);
	  Respective_product_page rpp = new Respective_product_page(driver);
	  String titleName=rpp.product_tit();
	  SoftAssert s = new SoftAssert();
	  s.assertEquals(title, titleName);
  }
  
  @Test(groups= {"functional"})
  public void fun3() {
	  Inventory_page ip = new Inventory_page(driver);
	  ip.picToProdPage(2);
	  Respective_product_page rpp = new Respective_product_page(driver);
	  rpp.backHomePage();
	  ip.menuBtn();
  }

}

