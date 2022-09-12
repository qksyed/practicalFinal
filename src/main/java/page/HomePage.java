package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	//static WebDriver driver = BrowserFactory.driver;
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void getHomePage() {
		
		driver.get("https://techfios.com/test/101/");
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/input[1]" ) WebElement Add_ListItem_Element;
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/input[2]" ) WebElement Add_Button_Element;
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/input[3]" ) WebElement Toggle_All_Element;
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/input[1]" ) WebElement Remove_Button_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[1]" ) WebElement Add_Category_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]" ) WebElement Add_Category_Button_Element;
	@FindBy(how = How.XPATH, using = "//button" ) WebElement Set_Background_Button_Element;
	public void insertListItem(String ListItem) {
		Add_ListItem_Element.sendKeys(ListItem);
		
	}
	public void insertCategory(String Category) {
		Add_Category_Element.sendKeys(Category);
		
	}
	public void clickAddButton() {
		Add_Button_Element.click();
		
	}
	public void clickAddCategoryButton() {
		Add_Category_Button_Element.click();
		
	}
	public WebElement checkToggleAll() {
		Toggle_All_Element.click();
		return Toggle_All_Element;	
	}
	public void clickRemoveButton() {
		Remove_Button_Element.click();
		
	}
	public WebElement setBackgroundColor(String buttonName) {
		WebElement BackgroundButton = driver.findElement(By.xpath("//" + Set_Background_Button_Element.getTagName() + "[text()='" + buttonName + "']"));
		return BackgroundButton;		
	}

}
