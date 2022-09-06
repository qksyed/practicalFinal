package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.HomePage;
import util.BrowserFactory;

public class GetHomePage {
	WebDriver driver;
	@Test
	public void testLandHomePage() throws InterruptedException {
		//driver = HomePage.getHomePage();		
		driver = BrowserFactory.init();
		//this.driver = driver;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.getHomePage();
		Thread.sleep(3000);
		homePage.insertListItem("abc123");
		homePage.clickAddButton();
		homePage.insertListItem("def456");
		homePage.clickAddButton();
		homePage.insertListItem("ghi789");
		homePage.clickAddButton();
		WebElement toggleallCheckbox = homePage.checkToggleAll();
		Assert.assertEquals(true, toggleallCheckbox.isSelected()); 
		System.out.println("ToggleAll Checkbox is selected");
		WebElement listItem1 = driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[1]/input"));
		WebElement listItem2 = driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[2]/input"));
		WebElement listItem3 = driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[3]/input"));
		Assert.assertEquals(true, listItem1.isSelected());
		Assert.assertEquals(true, listItem2.isSelected());
		Assert.assertEquals(true, listItem3.isSelected());
		System.out.println("All List Items Checkbox are selected - verified");
		toggleallCheckbox.click();
		Thread.sleep(3000);		
		List<WebElement> itemsInList = driver.findElements(By.tagName("li"));
		//System.out.println(itemsInList.size()  + itemsInList.get(0).getText());
		listItem1.click();		
		homePage.clickRemoveButton();
		List<WebElement> itemsInListAfter = driver.findElements(By.tagName("li"));
		System.out.println(itemsInListAfter.get(0).getText());
		boolean isPresent;
		if (itemsInListAfter.get(0).getText().equalsIgnoreCase(" 1def456 (None)")) {
			isPresent = true;			
		}
		else {
			isPresent = false;
		}
		Assert.assertEquals(true, isPresent);	
		toggleallCheckbox.click();
		homePage.clickRemoveButton();
		List<WebElement> itemsInListAfterToggleAll = driver.findElements(By.tagName("li"));
		boolean isPresentAtAll;
		if (itemsInListAfterToggleAll.size() <= 0) {
			isPresentAtAll = true;
		}
		else {
			isPresentAtAll = false;
		}
		Assert.assertEquals(true, isPresentAtAll);
		
		System.out.println("Verified- All list items deleted with ToggleAll checkbox");
		BrowserFactory.tearDown();		
	}
	
}
