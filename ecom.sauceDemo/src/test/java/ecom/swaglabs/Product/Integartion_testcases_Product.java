package ecom.swaglabs.Product;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import object_repo.Add_to_cart;
import object_repo.Inventory_page;
import object_repo.Respective_product_page;

public class Integartion_testcases_Product extends Base_class{
  @Test(groups= {"integration"})
  public void int1() {
	  Inventory_page ip = new Inventory_page(driver);
	  String title=ip.getProdTitle(5);
	  ip.picToProdPage(5);
	  Respective_product_page rpp = new Respective_product_page(driver);
	  rpp.add2cart();
	  String titleName=rpp.product_tit();
	  rpp.cartLogo();
	  String title_home_page=ip.pageTitle();
	  SoftAssert s = new SoftAssert();
	  s.assertEquals(title, titleName);
	  s.assertEquals(title_home_page, "Swag Labs");
  }
  @Test(groups= {"integration"})
  public void int2() {
	  Inventory_page ip = new Inventory_page(driver);
	  String title=ip.getProdTitle(2);
	  ip.picToProdPage(2);
	  Respective_product_page rpp = new Respective_product_page(driver);
	  rpp.add2cart();
	  String titleName=rpp.product_tit();
	  rpp.backHomePage();
	  Add_to_cart atc = new Add_to_cart(driver);
	  String product_title=atc.pro_tit(2);
	  SoftAssert s = new SoftAssert();
	  s.assertEquals(title, titleName);
	  s.assertEquals(product_title, title);
  }
}

