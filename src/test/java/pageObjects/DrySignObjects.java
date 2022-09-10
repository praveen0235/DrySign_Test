package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrySignObjects {
	
	public DrySignObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@placeholder='Enter Email Address']")
	public static WebElement UserName;
	
	@FindBy(xpath="//*[@placeholder='Enter Password']")
	public static WebElement Password;
	
	@FindBy(xpath="//input[@id='login']")
	public static WebElement YOPMail_Emailtxt_box;
	
	@FindBy(xpath="//*[@type='submit']")
	public static WebElement SignIn;
	
	@FindBy(xpath="(//*[@class='lms'])[1]")
	public static WebElement MailVerification;
	
	@FindBy(xpath="//iframe[@id='ifinbox']")
	public static WebElement YopMailFrame;
	
	@FindBy(xpath="(//div[@class='wminboxheader']//button/i)[1]")
	public static WebElement YopDelete;
	
	@FindBy(xpath="//*[contains(text(),'Empty Inbox')]")
	public static WebElement YopEmpty_Inbox;
	
	@FindBy(xpath="//iframe[@id='ifmail']")
	public static WebElement YopMailFrame2;
	
	@FindBy(xpath="//*[text()='Group Sign']")
	public static WebElement GroupSign_btn;
	
	@FindBy(xpath="//*[text()='Browse']")
	public static WebElement Browse;
	
	@FindBy(xpath="//span[contains(text(),'Save and Continue')]")
	public static WebElement SaveandContinue;
	
	@FindBy(xpath="//input[@type='submit']//parent::div/button/i")
	public static WebElement YOPMail_CheckInbox;
	
	@FindBy(xpath="(//button[contains(text(),'Full Name')]/following::div)[1]")
	public static WebElement Full_Name_drp;
	
	@FindBy(xpath="(//button[contains(text(),'Date')]/following::div)[1]")
	public static WebElement Date_drp;
	
	@FindBy(xpath="(//button[contains(text(),'Signature')]/following::div)[1]")
	public static WebElement Signature_drp;
	
	@FindBy(xpath="//span[contains(text(),'Set priority for signatories')]")
	public static WebElement Setpriorityforsignatories;
	
	@FindBy(xpath="//input[@formcontrolname='ccEmailID']")
	public static WebElement ccEmailID;
	
	@FindBy(xpath="//input[@formcontrolname='subject']")
	public static WebElement subject;
	
	@FindBy(xpath="//div[contains(@aria-label,'Rich Text Editor')]")
	public static WebElement Message;
	
	@FindBy(xpath="//span[contains(text(),'Send')]")
	public static WebElement Send_btn;
	
	@FindBy(xpath="//a[contains(text(),'Out for Signature')]")
	public static WebElement OutforSignature;
	
	@FindBy(xpath="//td[contains(@id,'accordian0')]")
	public static WebElement accordian;
	
	@FindBy(xpath="//span[contains(text(),'Confirm')]")
	public static WebElement Confirm;
	
	@FindBy(xpath="//span[@id='Template']")
	public static WebElement Template;
	
	@FindBy(xpath="//span[contains(text(),'Upload New Template')]")
	public static WebElement UploadNewTemplate;
	
	@FindBy(xpath="(//div[@id='main-content-wrapper']//*[@aria-label='Sidenav']//li//span)[3]")
	public static WebElement FullName;
	
	@FindBy(xpath="(//div[@id='main-content-wrapper']//*[@aria-label='Sidenav']//li//span)[4]")
	public static WebElement Date;
	
	@FindBy(xpath="(//div[@id='main-content-wrapper']//*[@aria-label='Sidenav']//li//span)[5]")
	public static WebElement TextBox;
	
	@FindBy(xpath="(//div[@id='main-content-wrapper']//*[@aria-label='Sidenav']//li//span)[6]")
	public static WebElement Initials;
	
	@FindBy(xpath="(//div[@id='main-content-wrapper']//*[@aria-label='Sidenav']//li//span)[7]")
	public static WebElement Seal;
	
	@FindBy(xpath="(//div[@id='main-content-wrapper']//*[@aria-label='Sidenav']//li//span)[8]")
	public static WebElement signature;
	
	@FindBy(xpath="(//div[@id='main-content-wrapper']//*[@aria-label='Sidenav']//li//span)[9]")
	public static WebElement signatureStamp;
	
	@FindBy(xpath="//div[contains(@id,'PSPDFKit-dd-fullName')]//div/div/div")
	public static List<WebElement> FullNameDrpList;
	
	@FindBy(xpath="//div[contains(@id,'PSPDFKit-dd-date')]//div/div/div")
	public static List<WebElement> DateDrpList;
	
	@FindBy(xpath="//div[contains(@id,'PSPDFKit-dd-signature')]//div/div/div")
	public static List<WebElement> SignatureDrpList;
	
	@FindBy(xpath="(//span[contains(text(),'Save')])[1]")
	public static WebElement Save;
	
	@FindBy(xpath="//span[text()='OK']")
	public static WebElement OK;
	
	@FindBy(xpath="//title[text()='Dashboard | DrySign']")
	public static WebElement Dashboard;
	
	@FindBy(xpath="//label[contains(text(),'Upload')]")
	public static WebElement Upload;
	
	@FindBy(xpath="//div[text()='Loading']")
	public static WebElement Loading;
	
	@FindBy(xpath="//iframe[@title='PSPDFKit']")
	public static WebElement iFrame;
	
	@FindBy(xpath="//span[text()='A Simple PDF File']")
	public static WebElement SimplePDF;
				
}
