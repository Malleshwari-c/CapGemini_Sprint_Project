package object_repo;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Complete_page {
WebDriver driver;
	
	public Complete_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="generate-pdf-order")
	private WebElement pdf;
	
	@FindBy(id="back-to-products")
	private WebElement b2h;
	
	@FindBy(css="[class='complete-header']")
	private WebElement mess;

	public void click_pdf() {
		pdf.click();
	}
	
	public void takeScreenshot1() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./ecom.sauceDemo/pdf_download.png");
		FileUtils.copyFile(source, destination);
	}
	public void takeScreenshot() throws IOException, AWTException {
		Robot robot = new Robot();
		Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(screen);
		ImageIO.write(image,"png",new File("./ecom.sauceDemo/download_popup.png"));
	}
	
	public String back_home() {
		String message=mess.getText();
		b2h.click();	
		return message;
	}
	

}
