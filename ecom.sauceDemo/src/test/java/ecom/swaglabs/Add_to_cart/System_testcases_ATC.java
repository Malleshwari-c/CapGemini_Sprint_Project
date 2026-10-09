package ecom.swaglabs.Add_to_cart;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_classes.Base_class;
import generic_utility.Specific_data;
import object_repo.Add_to_cart;
import object_repo.Checkout_page;
import object_repo.Complete_page;
import object_repo.Inventory_page;
import object_repo.Overview_page;
import object_repo.Respective_product_page;

public class System_testcases_ATC extends Base_class{

	  @Test(groups = {"system"})
	  public void sys1() throws InterruptedException {
	      SoftAssert s = new SoftAssert();
	      // Step 1: Open inventory page after login
	      Inventory_page ip = new Inventory_page(driver);
	      // Step 2: Add products to the cart
	      ip.addCart(1);
	      ip.addCart(2);
	      ip.addCart(3);
	      // Step 3: Open cart
	      ip.cartLogo();
	      Thread.sleep(1000);
	      Add_to_cart adc = new Add_to_cart(driver);
	      // Step 4: Verify that 3 products are in the cart
	      String num_items = adc.cart_logo();
	      System.out.println("Cart count before removal: " + num_items);
	      s.assertEquals(num_items, "3","Cart should contain 3 products");
	      // Step 5: Get the title of the product to remove
	      String removedProduct = adc.pro_tit(0);
	      System.out.println("Product selected for removal: " + removedProduct);
	      // Step 6: Remove the selected product
	      adc.remove_button();
	      Thread.sleep(1000);
	      // Verify that 2 products remain
	      String num_items1 = adc.cart_logo();
	      System.out.println("Cart count after removal: " + num_items1);
	      s.assertEquals(num_items1, "2","Cart should contain 2 products after removal");
	      // Step 7: Click Continue Shopping
	      adc.continue_shop();
	      Thread.sleep(1000);
	      // Step 8: Open the same product that was removed
	      ip.nameToProdPage(1);
	      Thread.sleep(1000);
	      Respective_product_page rpp =new Respective_product_page(driver);
	      // Verify the selected product title
	      String productTitle = rpp.product_tit();
	      System.out.println("Product opened: " + productTitle);
	      s.assertEquals(productTitle, removedProduct,"The opened product should match the removed product");
	      // Step 9: Add the same product to the cart again
	      rpp.add2cart();
	      Thread.sleep(1000);
	      // Step 10: Open the cart and verify the product
	      ip.cartLogo();
	      Thread.sleep(1000);
	      String cartProduct = adc.pro_tit(0);
	      System.out.println("Product in cart after adding again: " + cartProduct);
	      s.assertEquals(cartProduct, removedProduct,"The removed product should be added to the cart again");
	      // Verify the cart count returns to 3
	      String num_items2 = adc.cart_logo();
	      System.out.println("Cart count after adding again: " + num_items2);
	  }
	
	  	  
	  @Test(groups = {"smoke", "system"})
	    public void sys2() throws IOException {
	        SoftAssert s = new SoftAssert();
	        Specific_data test_data = new Specific_data();
	        test_data.spData();
	        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	        // Step 1: Add products to cart
	        Inventory_page ip = new Inventory_page(driver);
	        wait.until(d -> d.getCurrentUrl().contains("inventory"));
	        ip.addCart(1);
	        // Step 2: Open cart
	        ip.cartLogo();
	        wait.until(d -> d.getCurrentUrl().contains("cart"));
	        // Step 3: Checkout
	        Add_to_cart adc = new Add_to_cart(driver);
	        adc.checkOut();
	        wait.until(d -> d.getCurrentUrl().contains("checkout-step-one"));
	        // Step 4: Enter customer information
	        Checkout_page cp = new Checkout_page(driver);
	        cp.enter_info(test_data.FIRSTNAME,test_data.LASTNAME,test_data.POSTALCODE);
	        wait.until(d -> d.getCurrentUrl().contains("checkout-step-two"));
	        // Step 5: Finish the order
	        Overview_page op = new Overview_page(driver);
	        op.click_finish();
	        wait.until(d -> d.getCurrentUrl().contains("checkout-complete"));
	        // Step 6: Verify order completion
	        Complete_page cop = new Complete_page(driver);
	        String tq = cop.back_home();
	        System.out.println("Order confirmation: " + tq);
	        s.assertEquals(tq,"Thank you for your order!","Order confirmation message is incorrect");
	        s.assertAll();
	    }
	  }


