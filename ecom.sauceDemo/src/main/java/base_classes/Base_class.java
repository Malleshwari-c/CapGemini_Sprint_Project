package base_classes;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import object_repo.Login_page;


public class Base_class {
	protected WebDriver driver=null;
	@BeforeSuite(alwaysRun = true)
	public void Bs() {
		System.out.println("Open database connectivity");
	}
	@BeforeTest(alwaysRun = true)
	public void Bt() {
		System.out.println("Pre-conditions");
	}
	@BeforeClass(alwaysRun = true)
    @Parameters({"BROWSER"})
	public void Bc(@Optional("chrome") String BROWSER)throws IOException {
		
		if(BROWSER.equals("chrome")) {
			ChromeOptions settings=new ChromeOptions();
			Map<String, Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(settings);
		}
		if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Launch Browser");
		
	}
		@BeforeMethod(alwaysRun = true)
		@Parameters({"URL","USERNAME", "PASSWORD"})
		public void Bm(@Optional("https://www.saucedemo.com/") String URL,@Optional("standard_user") String USERNAME,
		        @Optional("secret_sauce") String PASSWORD) throws InterruptedException {

			driver.get(URL);
			Login_page lp = new Login_page(driver);
			lp.login(USERNAME, PASSWORD);
		}
		
		@AfterMethod(alwaysRun = true)
		public void Am() {
			System.out.println("log-out succesfully");
		}
		
		@AfterClass(alwaysRun = true)
		public void Ac() {
			driver.quit();
			System.out.println("Close the browser");
		}
		@AfterTest(alwaysRun = true)
		public void At() {
			System.out.println("Post conditions");
		}
		@AfterSuite(alwaysRun = true)
		public void As() {
			System.out.println("close database connectivity");
		}
}
