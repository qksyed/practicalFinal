package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.HomePage;
import util.BrowserFactory;

public class MonthDueDropDown {
	WebDriver driver;
	@Test
	public void testMonthsDueDropdown() throws InterruptedException {
		driver = BrowserFactory.init();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.getHomePage();
		Thread.sleep(3000);
		homePage.monthDropDown().click();
		Select MonthDue = new Select(homePage.monthDropDown());
		List<WebElement> months = MonthDue.getOptions();
		List DueMonth = new ArrayList();
		for (WebElement ele : months) {
			String MonthsData = ele.getText();
			DueMonth.add(MonthsData);
		}
		System.out.println(DueMonth);
		List verifymonths = new ArrayList();
		verifymonths.add("None");
		verifymonths.add("Jan");
		verifymonths.add("Feb");
		verifymonths.add("Mar");
		verifymonths.add("Apr");
		verifymonths.add("May");
		verifymonths.add("Jun");
		verifymonths.add("Jul");
		verifymonths.add("Aug");
		verifymonths.add("Sep");
		verifymonths.add("Oct");
		verifymonths.add("Nov");
		verifymonths.add("Dec");
		
		//Collections.sort(verifymonths);
		System.out.println(verifymonths);
		Assert.assertTrue(DueMonth.equals(verifymonths));
	}

}
