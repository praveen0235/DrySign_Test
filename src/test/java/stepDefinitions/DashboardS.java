package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.PropertyConfigurator;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import config.PropertyFileReader;
import framework.Elements;
import framework.GenericActions;
import framework.Waits;
import imageMagick.TestXML;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.DashboardObjectS;
import pageObjects.DrySignObjects;
import pageObjects.USAMobileNoMandateObjectS;
import pageObjects.pageObjects;
import pageObjects.pageObjects2;
import util.PathHelper;
import util.Xls_Reader;



public class DashboardS {
	
SoftAssertions sft = new SoftAssertions();
	
	pageObjects pageobjects;
	pageObjects2 pageobjects2;
	DashboardObjectS dashboardObjects;
	DrySignObjects drySignObjects;
	USAMobileNoMandateObjectS uSAMobileNoMandateObjectS;
	public String mainWindowHandle;
	Waits waits =new Waits();
	GenericActions genericaction = new GenericActions();
	Elements elements = new Elements();
	TestXML imgck = new TestXML();
	public RemoteWebDriver driver;
	public String envi;
	  String pagename;
	  public  Xls_Reader suiteXLS;
	  public  int rowcount;
	  
	  public void loadPropertiesFile() throws IOException{
			PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
			PropertyFileReader prop = new PropertyFileReader();
		    }
		
	
		@Given("navigate to given URL {string}")
	public void navigate_to_given_URL(String string) throws FileNotFoundException, IOException, ParseException, ConfigurationException, InterruptedException {
		
		loadPropertiesFile();
		final String AUTOMATE_USERNAME = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("UserName");
		  final String AUTOMATE_ACCESS_KEY = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("AccessKey");
		String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
		
		 this.envi=  Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("device");
		
		      
     DesiredCapabilities caps = new DesiredCapabilities();
      if(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformType").equalsIgnoreCase("Mobile"))
      {
     
		caps.setCapability("os_version", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os_version"));
		caps.setCapability("device", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("device"));
		caps.setCapability("real_mobile", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("real_mobile"));
		caps.setCapability("project",  Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("project"));
		caps.setCapability("build", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("build"));
		caps.setCapability("name", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("name"));
		caps.setCapability("browserstack.local", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserstack_local"));
		caps.setCapability("browserstack.debug", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserstack_debug"));
		caps.setCapability("browserstack.networkLogs", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserstack_networkLogs"));
		 driver = new RemoteWebDriver( new URL(URL), caps);
      }else
      {
      	caps.setCapability("os_version", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os_version"));
  		caps.setCapability("os", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformType"));
  		caps.setCapability("browser", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
  		caps.setCapability("project",  Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("project"));
  		caps.setCapability("build", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("build"));
  		caps.setCapability("name", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("name"));
  		caps.setCapability("browserstack.local", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserstack_local"));
  		caps.setCapability("browserstack.debug", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserstack_debug"));
  		caps.setCapability("browserstack.networkLogs", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserstack_networkLogs"));		
  		caps.setCapability("browser_version", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser_version"));
  		caps.setCapability("resolution", Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("resolution"));
  		 driver = new RemoteWebDriver( new URL(URL), caps);
  		 driver.manage().window().maximize();
      }
			  
			  mainWindowHandle = driver.getWindowHandle();
			
			 // percy = new Percy(driver);
			  System.out.println("Browserstack connection is Success");
			
		
		driver.navigate().to(string);
		
		pageobjects = new pageObjects(driver);
		pageobjects2 = new pageObjects2(driver);
		dashboardObjects = new	DashboardObjectS(driver);
		drySignObjects = new DrySignObjects(driver);
		uSAMobileNoMandateObjectS = new USAMobileNoMandateObjectS(driver);

		
	}

		@When("user click on the sign in button")
		public void user_click_on_the_sign_in_button() {
			waits.waitUntilElementToClick(30, pageobjects.SignInButton,driver);
			elements.click(driver,pageobjects.SignInButton);
		}

	@When("click on SIGN DOCUMENT option")
	public void click_on_SIGN_DOCUMENT_option() throws InterruptedException {
		
		if(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformType").equalsIgnoreCase("Mobile"))
		{
			elements.switchToFrame(driver, pageobjects.YopMailFrame);
			waits.waitUntilElementToClick(30, pageobjects.OpenEmail,driver);
			elements.jclick(driver,pageobjects.OpenEmail);
		    elements.switchTodefaultContent(driver);
		    
		    elements.switchToFrame(driver, pageobjects.YopMailmobFrame2);
			waits.waitUntilElementToClick(30, pageobjects.Sign_Document,driver);
			elements.click(driver,pageobjects.Sign_Document);
		    elements.switchTodefaultContent(driver);
		    elements.switchToChild(driver, mainWindowHandle);
		}else
		{
		elements.switchToFrame(driver, pageobjects.YopMailFrame2);
		waits.waitUntilElementToClick(30, pageobjects.Sign_Document,driver);
		elements.jclick(driver,pageobjects.Sign_Document);
	    elements.switchTodefaultContent(driver);
	    elements.switchToChild(driver, mainWindowHandle);
		}
	}
	
	@When("user click on terms and conditions")
	public void user_click_on_terms_and_conditions() {
		waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.termsAndConditions,driver);
		elements.jclick(driver,uSAMobileNoMandateObjectS.termsAndConditions);
	    
	}
	
	@When("select agree check box")
	public void selectagreecheckbox() {
		waits.waitUntilElementToClick(30, pageobjects.agreeCheckBox,driver);
		elements.jclick(driver,pageobjects.agreeCheckBox);
	    
	}
	
	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	    
	}
	
	@When("click on accept button")
	public void click_on_accept_button() {
		waits.waitUntilElementToClick(30, pageobjects.AcceptButton,driver);
		elements.jclick(driver,pageobjects.AcceptButton);
	    
	}
	
	@When("system should display download, reject and finish options")
	public void system_should_display_download_reject_and_finish_options() {
		waits.waitUntilElementToClick(30, pageobjects.download,driver);
		elements.isDisplayed(pageobjects.download);
		
		waits.waitUntilElementToClick(30, pageobjects.rejectbutton,driver);
		elements.isDisplayed(pageobjects.rejectbutton);
		
		waits.waitUntilElementToClick(30, pageobjects.finish,driver);
		elements.isDisplayed(pageobjects.finish);
	    
	}
	
	@When("enter the user name as {string}")
	public void enter_the_user_name_as(String string) {
		waits.waitUntilElementLocated(30, drySignObjects.UserName,driver);
		elements.TypeText(driver,drySignObjects.UserName, string);
	}

	@When("enter the password as{string}")
	public void enter_the_password_as(String string) {
		waits.waitUntilElementLocated(30, drySignObjects.Password,driver);
		elements.TypeText(driver,drySignObjects.Password, string);
	}

	@When("click on Sign in button")
	public void click_on_Sign_in_button() {
		waits.waitUntilElementToClick(30, drySignObjects.SignIn,driver);
		elements.click(driver,drySignObjects.SignIn);
	}
	
	@When("dashboard window get display")
	public void dashboard_window_get_display() {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.dashboard,driver);
	    Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.dashboard),"Dashboard");
	}
	
	@Then("View Plan buttons should be present")
	public void view_Plan_buttons_should_be_present() {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.btnViewPlan,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.btnViewPlan);
		
	}
	@Then("user click on View Plan button")
	public void user_click_on_View_Plan_button() {
		waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.btnViewPlan,driver);
		elements.jclick(driver,uSAMobileNoMandateObjectS.btnViewPlan);
		
	}
	@Then("Pop Up get displayed with elements")
	public void pop_Up_get_displayed_with_elements() {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.elements,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.elements);
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.eightyDoc,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.eightyDoc);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.eightyDoc).trim(),"80 Documents");


		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.fiveDoc,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.fiveDoc);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.fiveDoc).trim(),"5 Templates");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.uploadPdfUsingGoogleDrive,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.uploadPdfUsingGoogleDrive);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.uploadPdfUsingGoogleDrive).trim(),"Upload PDF using Google Drive");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.uploadPdfUsingDropbox,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.uploadPdfUsingDropbox);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.uploadPdfUsingDropbox).trim(),"Upload PDF using Dropbox");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.uploadPdfUsingOneDrive,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.uploadPdfUsingOneDrive);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.uploadPdfUsingOneDrive).trim(),"Upload PDF using OneDrive");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.Self_Sign_Text,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.Self_Sign_Text);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.Self_Sign_Text).trim(),"Self sign");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.Grp_Sign_Text,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.Grp_Sign_Text);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.Grp_Sign_Text).trim(),"Group Sign");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.MFAAndverifiedByTrustedCertificationAuthority,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.MFAAndverifiedByTrustedCertificationAuthority);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.MFAAndverifiedByTrustedCertificationAuthority).trim(),"MFA & verified by trusted certification authority");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.AuditTrailwithTimestamps,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.AuditTrailwithTimestamps);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.AuditTrailwithTimestamps).trim(),"Audit Trail with Time stamps");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.GoogleSignIn,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.GoogleSignIn);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.GoogleSignIn).trim(),"Google Sign in");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.TypeDraworUpload,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.TypeDraworUpload);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.TypeDraworUpload).trim(),"Signatures: Type, Draw or Upload");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.NotifyRemoveAndReassign,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.NotifyRemoveAndReassign);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.NotifyRemoveAndReassign).trim(),"Document Tracking: Notify, Remove and Reassign");
		
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.HierarchicalSignatures,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.HierarchicalSignatures);
		Assert.assertEquals(elements.getText(uSAMobileNoMandateObjectS.HierarchicalSignatures).trim(),"Hierarchical Signatures");
		}
	@Then("existing plan details of the user should get displayed with Upgrade Plan button")
	public void existing_plan_details_of_the_user_should_get_displayed_with_Upgrade_Plan_button() {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.btnUpgradePlan,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.Plan_Details);
		elements.isDisplayed(uSAMobileNoMandateObjectS.btnUpgradePlan);
	}
	@Then("user verify that close icon is present on the pop up")
	public void user_verify_that_close_icon_is_present_on_the_pop_up() {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.closeIcon,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.closeIcon);
		
	}
	@Then("user click on Upgrade Plan button")
	public void user_click_on_Upgrade_Plan_button() throws InterruptedException {
		
		waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.btnUpgradePlan,driver);
		elements.jclick(driver,uSAMobileNoMandateObjectS.btnUpgradePlan);
		
	}
	@Then("pop up should display only the higher plan than the exisiting")
	public void pop_up_should_display_only_the_higher_plan_than_the_exisiting() {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.professional,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.professional);
	}
	
	@Then("refresh the page")
	public void refresh_the_page() {
	    driver.navigate().refresh();
	}

	@When("user click on here link")
	public void user_click_on_here_link() throws InterruptedException {
		elements.switchToChild(driver,mainWindowHandle);
		waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.clickOnHerelink,driver);
		elements.jclick(driver,uSAMobileNoMandateObjectS.clickOnHerelink);
	}
	
	@Then("enter yopmail id as {string}")
	public void enter_yopmail_id_as(String string) throws InterruptedException {
		waits.waitUntilElementLocated(30,pageObjects.YOPMail_Emailtxt_box,driver);
		elements.TypeText(driver,pageObjects.YOPMail_Emailtxt_box, string);
	    
	}

	@When("click on check inbox")
	public void click_on_check_inbox() {
		waits.waitUntilElementToClick(30,pageObjects.YOPMail_CheckInbox,driver);
		elements.click(driver,pageObjects.YOPMail_CheckInbox);
	    
	}

	@Then("system should display {string} email")
	public void system_should_display_email(String string) throws InterruptedException {
		elements.switchToFrame(driver,pageObjects.YopMailFrame);
		Assert.assertTrue(elements.VerifyTextEquals(pageObjects.MailVerification, string));
		elements.switchTodefaultContent(driver);
	    
	}
	
	@Then("user should get display refund page")
	public void user_should_get_display_refund_page() {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.refundPage,driver);
		elements.isDisplayed(uSAMobileNoMandateObjectS.refundPage);
		
	}
	@Then("user enter name as {string}")
	public void user_enter_name_as(String name) {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.entName,driver);
		elements.TypeText(driver,uSAMobileNoMandateObjectS.entName, name);
		
	  
	}

	@Then("user enter emai id as {string}")
	public void user_enter_emai_id_as(String emailid) {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.entEmailId,driver);
		elements.TypeText(driver,uSAMobileNoMandateObjectS.entEmailId, emailid);
	   
	}

	@Then("user enter subscription plan as {string}")
	public void user_enter_subscription_plan_as(String plan) {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.entSubscriptionPlan,driver);
		elements.TypeText(driver,uSAMobileNoMandateObjectS.entSubscriptionPlan, plan);
	    
	}

	@Then("user enter subscription id as {string}")
	public void user_enter_subscription_id_as(String id) {
		waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.entSubscriptionId,driver);
		elements.TypeText(driver,uSAMobileNoMandateObjectS.entSubscriptionId, id);
		
	}
	@Then("user click on confirm button")
	public void user_click_on_confirm_button() throws InterruptedException {
		waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.confirmBtnOnRefund,driver);
		elements.jclick(driver,uSAMobileNoMandateObjectS.confirmBtnOnRefund);
		
	}

@Then("refund pop up get display")
public void refund_pop_up_get_display() {
	waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.refundPopUp,driver);
	elements.isDisplayed(uSAMobileNoMandateObjectS.refundPopUp);
	
}



@Then("user click on confirm button which present on pop up")
public void user_click_on_confirm_button_which_present_on_pop_up() throws InterruptedException {
	
	waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.confirmBtnOnPopUp,driver);
	elements.jclick(driver,uSAMobileNoMandateObjectS.confirmBtnOnPopUp);
}

@Then("user should get display message as your refund has been successful")
public void user_should_get_display_message_as_your_refund_has_been_successful() {
	waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.yourRefundHasBeenSuccessful,driver);
	elements.isDisplayed(uSAMobileNoMandateObjectS.yourRefundHasBeenSuccessful);
    
}

@Then("click on ok button")
public void click_on_ok_button() {
	waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.Ok_Btn,driver);
	elements.jclick(driver,uSAMobileNoMandateObjectS.Ok_Btn);
	
}

@Then("user click on drysign logo")
public void user_click_on_drysign_logo() {
	waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.drySignLogo,driver);
	elements.jclick(driver,uSAMobileNoMandateObjectS.drySignLogo);
	
 
}

@When("click on cancel subscription button")
public void click_on_cancel_subscription_button() {
	waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.Cancel_Subscription,driver);
	elements.jclick(driver,uSAMobileNoMandateObjectS.Cancel_Subscription);
	
}




@Then("user get display Buy Now button")
public void user_get_display_Buy_Now_button() {
	waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.buyNowNoActivePlan,driver);
	elements.isDisplayed(uSAMobileNoMandateObjectS.buyNowNoActivePlan);
	
	}
@Then("user click on the Buy Now button")
public void user_click_on_the_Buy_Now_button() {
	waits.waitUntilElementToClick(30, uSAMobileNoMandateObjectS.buyNowNoActivePlan,driver);
	elements.click(driver,uSAMobileNoMandateObjectS.buyNowNoActivePlan);
	
}
@Then("all the available plans should get displayed to purchase for the user")
public void all_the_available_plans_should_get_displayed_to_purchase_for_the_user() {
	waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.generalPlans,driver);
	elements.isDisplayed(uSAMobileNoMandateObjectS.generalPlans);
	
}

@Then("Upgrade button should not display on dashboard to paid user as {string}")
public void upgrade_button_should_not_display_on_dashboard_to_paid_user_as(String string) {
	waits.waitUntilElementLocated(30, uSAMobileNoMandateObjectS.btnViewPlan,driver);
	elements.isDisplayed(uSAMobileNoMandateObjectS.btnViewPlan);
	Assert.assertNotSame(elements.getText(uSAMobileNoMandateObjectS.btnViewPlan),string);
}
@Then("user should display the correct document received count")
public void user_should_display_the_correct_document_received_count() {
	waits.waitUntilElementLocated(30, dashboardObjects.Documents_Received,driver);
	elements.isDisplayed(dashboardObjects.Eight_Documents);
	elements.isDisplayed(dashboardObjects.Documents);
	Assert.assertNotSame(elements.getText(dashboardObjects.Documents_Received)," Documents Received ");
	
}
@Then("user should display the correct document sent count")
public void user_should_display_the_correct_document_sent_count() {
	waits.waitUntilElementLocated(30, dashboardObjects.Documents_Sent,driver);
	elements.isDisplayed(dashboardObjects.Documents_Sent);
	Assert.assertNotSame(elements.getText(dashboardObjects.Documents_Sent),"Documents Sent");
	
	elements.isDisplayed(dashboardObjects.Four_Documents);
	Assert.assertNotSame(elements.getText(dashboardObjects.Documents_Sent),"4");
	elements.isDisplayed(dashboardObjects.Documents);
	Assert.assertNotSame(elements.getText(dashboardObjects.Documents_Sent),"Documents");
	
	
}
@Then("user click on self sign")
public void user_click_on_self_sign() throws InterruptedException {
	
	waits.waitUntilElementToClick(30,uSAMobileNoMandateObjectS.selfSign,driver);
	elements.jclick(driver,uSAMobileNoMandateObjectS.selfSign);
	
}
@Then("User drag and drop the signature")
public void user_drag_and_drop_the_signature() throws InterruptedException {
	waits.waitUntilElementLocated(30,dashboardObjects.signature,driver);
	elements.dragAndDrop(dashboardObjects.signature,dashboardObjects.Page,driver);
}
@Then("user display self sign and group sign and it should be clickable")
public void user_display_self_sign_and_group_sign_and_it_should_be_clickable() {
	//waits.waitUntilElementLocated(30, dashboardObjects.selfSign);
	waits.waitUntilElementToClick(30,dashboardObjects.selfSign,driver );
	elements.isDisplayed(dashboardObjects.selfSign);
	
	
	//waits.waitUntilElementLocated(30, dashboardObjects.grpSignBtn);
	waits.waitUntilElementToClick(30,dashboardObjects.grpSignBtn,driver );
	elements.isDisplayed(dashboardObjects.grpSignBtn);	
}

@Then("click on signature option")
public void click_on_signature_option() {
	
	elements.scrollIntoView(driver, pageobjects.signature);
    waits.waitUntilElementLocated(30, pageobjects.signature, driver);
    elements.jclick(driver, pageobjects.signature);
}

@Then("click on type option and select the sign")
public void click_on_type_option() throws InterruptedException {
	Thread.sleep(1500);
	waits.waitUntilElementLocated(30, pageobjects.TYPE, driver);
	elements.click(driver, pageobjects.TYPE);
	
	waits.waitUntilElementLocated(30, pageobjects.sigSelection, driver);
	elements.click(driver, pageobjects.sigSelection);
	
	
}

@Then("click on OK button")
public void click_on_OK_button() {
	waits.waitUntilElementLocated(30, pageobjects.OK, driver);
	elements.click(driver, pageobjects.OK);
}

@Then("save it")
public void save_it() {
	/*
	 * waits.waitUntilElementLocated(30, pageobjects.signaturepad, driver);
	 * System.out.println(pageobjects.signaturepad.getLocation().getX());
	 * System.out.println(pageobjects.signaturepad.getLocation().getY());
	 * elements.redaction(driver,pageobjects.signaturepad, 980, 320);
	 */
	
	waits.waitUntilElementLocated(30, pageobjects.SignSave, driver);
	elements.click(driver, pageobjects.SignSave);
}


@AfterStep
public void waitToPageRender(Scenario scenario) throws InterruptedException
{
	
	for(int i=1;i<=60;i++)
	{
		if(waits.isPageLoaded(driver))
		{
			break;
		}
		
		Thread.sleep(1000);
	}
	
	for(int i=0;i<=60;i++)
	{
	List<WebElement> spinner =pageobjects.loading;
	
	if(spinner.size()==0)
	{
		break;
	}else
	{
		Thread.sleep(1000);
		
	}
	
	}
}

@Before
public void before(Scenario scenario)
{
	
	suiteXLS = new Xls_Reader(PathHelper.getBasePath()+"/test-output/ExcelReport/ExcelReport.xlsx");
	rowcount = suiteXLS.getRowCount("Result");
	if(suiteXLS.getCellData("Result", "SlNo", 2).isEmpty())
	{
		suiteXLS.setCellData("Result", "SlNo", rowcount+1, "1");
	}else
	{
		suiteXLS.setCellData("Result", "SlNo", rowcount+1, String.valueOf(Integer.parseInt(suiteXLS.getCellData("Result", "SlNo", rowcount))+1));
	}
	GenericActions.date(suiteXLS, "TestStartedTime", rowcount+1);
	suiteXLS.setCellData("Result", "Scenario Name", rowcount+1, scenario.getName());
	suiteXLS.setCellData("Result", "platformType", rowcount+1, Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformType"));
	suiteXLS.setCellData("Result", "os_version", rowcount+1, Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os_version"));
	suiteXLS.setCellData("Result", "browser", rowcount+1, Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
	suiteXLS.setCellData("Result", "browser_version", rowcount+1, Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser_version"));
	suiteXLS.setCellData("Result", "resolution", rowcount+1, Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("resolution"));
	suiteXLS.setCellData("Result", "Device", rowcount+1, Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("device"));
}

@After

public void closeBrowser(Scenario scenario) throws ParseException, java.text.ParseException{
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	if(scenario.isFailed()){
		
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"failed\"}}");
		
	}else
	{
	
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Passed\"}}");
	
	}
	
	suiteXLS.setCellData("Result", "Result", rowcount+1, String.valueOf(scenario.getStatus()));
	GenericActions.date(suiteXLS, "TestEndedTime", rowcount+1);
	String startdate= suiteXLS.getCellData("Result", "TestStartedTime", rowcount+1);
	String Enddate= suiteXLS.getCellData("Result", "TestEndedTime", rowcount+1);
	GenericActions.datediff(startdate, Enddate, suiteXLS, rowcount+1);
	
	System.out.println("Scenario Status is: "+scenario.getStatus());
	System.out.println("Scenario Status is: "+scenario.getName());
	driver.quit();
	
	}


}

