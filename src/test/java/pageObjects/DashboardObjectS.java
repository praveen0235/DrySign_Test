package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObjectS {
	public DashboardObjectS(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=' Cancel Subscription ']")
	public static  WebElement clickCancelSubscription;
	
	@FindBy(xpath="//span[text()='Confirm']")
	public static  WebElement clickConfirm;
	
	@FindBy(xpath="//span[text()='Buy Now']")
	public static  WebElement clickBuyNow;
	//span[text()=' exit_to_app ']
	
	@FindBy(xpath="//span[text()='Dashboard']")
	public static  WebElement clickDashboard;
	
	@FindBy(xpath="//span[text()=' exit_to_app ']")
	public static  WebElement clickLogOut;
	
	@FindBy(xpath="//button[@aria-label='Header menu dropdown']")
	public static WebElement matIcon;
	
	/*
	 * public static WebElement Field(String data) { String Xpath =
	 * "//li[text()=' $ ']"; WebElement element =
	 * driver.findElement(By.xpath(Xpath.replace("$", data))); return element; }
	 */
	
	@FindBy(xpath="//h2[text()=' Documents Received ']")
	public static  WebElement Documents_Received;
	
			
			@FindBy(xpath="(//*[text()='Documents'])[2]")
			public static  WebElement Documents;
			
			@FindBy(xpath="//*[text()='8']")
			public static  WebElement Eight_Documents;
			
			
			@FindBy(xpath="//h2[text()=' Documents Sent ']")
			public static  WebElement Documents_Sent;
			
			@FindBy(xpath="//*[text()='4']")
			public static  WebElement Four_Documents;

			@FindBy(xpath="//label[text()='Self Sign']")
			public static WebElement selfSign;
			
			@FindBy(xpath="//span[text()='signature']")
			public static WebElement signature;
			
					
		    @FindBy(xpath="(//span[@class='PSPDFKit-6y44nrshuzvz454nzf891rm7u5'])[1]")
		    public static WebElement Page;
					
			@FindBy(xpath="//label[text()='Group Sign']")
			public static WebElement grpSignBtn;

			@FindBy(xpath="(//span[text()='Upgrade'])[1]")
			public static  WebElement btnUpgrade;
			
			@FindBy(xpath="(//span[text()='Upgrade'])[1]")
			public static WebElement Upgrade5;




}        



