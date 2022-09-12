package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.HomePage;
import util.BrowserFactory;

public class TestAddingCategory {
	WebDriver driver;
	@Test
	public void testAddingCategory() throws InterruptedException {
		driver = BrowserFactory.init();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.getHomePage();
		Thread.sleep(3000);
		homePage.insertCategory("FinalTestNG");
		homePage.clickAddCategoryButton();
		System.out.println("Category added");
		Thread.sleep(3000);
		boolean newCatAddedDisplayed = driver.findElement(By.linkText("FinalTestNG")).isDisplayed();
		Assert.assertEquals(true, newCatAddedDisplayed);
		System.out.println("Trying to add duplicate Category ");
		/*String parent = driver.getWindowHandle();
		System.out.println("this is 1st parent print" + parent);*/
		homePage.insertCategory("FinalTestNG");
		homePage.clickAddCategoryButton();
		Thread.sleep(2000);		
		
		String duplicateWarning;	
		/*
		Set<String> Window_Handles = driver.getWindowHandles();
		Iterator<String> I1 = Window_Handles.iterator();
		while(I1.hasNext())	{
			String child_window = I1.next();
			System.out.println("this is pre if while loop" + child_window);
			if(!parent.equalsIgnoreCase(child_window) ) {
				driver.switchTo().window(child_window);
				duplicateWarning = driver.findElement(By.tagName("body")).getText();
				System.out.println(duplicateWarning);
				driver.findElement(By.xpath("/html/body/a[1]")).click();
				System.out.println("this is if while loop" + child_window);
			}
			else {
				System.out.println("could not iterate");
			}

		}
		*/
		driver.switchTo().activeElement();
		duplicateWarning = driver.findElement(By.tagName("body")).getText();
		System.out.println(duplicateWarning);
		boolean duplicateBlocked;
		if (duplicateWarning.contains("The category you want to add already exists: FinalTestNG.")) {
			duplicateBlocked = true;
		}
		else {
			duplicateBlocked = false;
		}
		if (duplicateBlocked) {
			System.out.println("true");
		}
		else {
			System.out.println("flase");
		}
		//Assert.assertEquals(true, duplicateBlocked);
		driver.findElement(By.xpath("/html/body/a[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();	
		driver.findElement(By.xpath("/html/body/div[3]/a[562]/span")).click();
		/*System.out.println("this is last parent print" + parent);
		driver.findElement(By.xpath("/html/body/div[3]/a[562]/span")).click();
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("/html/body/a[1]"));*/
		Thread.sleep(2000);	
		BrowserFactory.tearDown();

	}
		
	
}


