package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import junit.framework.Assert;
import page.HomePage;
import util.BrowserFactory;

public class BackgroudColor {
	WebDriver driver;
	@Test
	public void testBackgroundColorChange() throws InterruptedException {
		//driver = HomePage.getHomePage();		
		driver = BrowserFactory.init();
		//this.driver = driver;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.getHomePage();
		Thread.sleep(3000);
		WebElement SkyBlueBackground = homePage.setBackgroundColor("Set SkyBlue Background");
		WebElement WhiteBackground = homePage.setBackgroundColor("Set White Background");
		if (SkyBlueBackground.isDisplayed()) {
			SkyBlueBackground.click();
			WebElement backgroundStyleElement = driver.findElement(By.xpath("//body"));
			String backgroundStyleValue = backgroundStyleElement.getAttribute("style");
			System.out.println(backgroundStyleValue);
			if (backgroundStyleValue.equalsIgnoreCase("background-color: skyblue;")) {
				System.out.println("Backgroung color changed to sky blue");
			}
			/*boolean backgroundchanged = backgroundStyleValue.equalsIgnoreCase("background-color: skyblue;");
			Assert.assertEquals(true, backgroundchanged);*/
		}
		Thread.sleep(2000);
		if (WhiteBackground.isDisplayed()) {
			WhiteBackground.click();
			WebElement backgroundStyleElement = driver.findElement(By.xpath("//body"));
			String backgroundStyleValue = backgroundStyleElement.getAttribute("style");
			System.out.println(backgroundStyleValue);
			if (backgroundStyleValue.equalsIgnoreCase("background-color: white;")) {
				System.out.println("Background color changed to white");
			}
		}
		else {
			System.out.println("Button not displayed");
		}
	}

}
