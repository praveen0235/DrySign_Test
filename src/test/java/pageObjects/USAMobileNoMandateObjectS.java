package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class USAMobileNoMandateObjectS {
	
	public USAMobileNoMandateObjectS (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//TS1	
	@FindBy(xpath="//*[text()='Sign Up']")
	public static WebElement signUpButton;
	
	@FindBy(xpath="//*[@formcontrolname='firstName']")
	public static WebElement entFirstName;
	
	@FindBy(xpath="//*[@formcontrolname='lastName']")
	public static WebElement entLastName;
	
	@FindBy(xpath="//*[@formcontrolname='companyName']")
	public static WebElement entCompName;
	

	@FindBy(xpath="//input[@formcontrolname='phone']")
	public static WebElement entPhoneNo;
	
	@FindBy(xpath="//*[@formcontrolname='email']")
	public static WebElement entEmail;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	public static WebElement entPassword;
	
	@FindBy(xpath="//*[@formcontrolname='confirmPassword']")
	public static WebElement entConfirmPassword;
	
	@FindBy(xpath="//*[@class='mat-checkbox-inner-container']")
	public static WebElement clickCheckBox;
	
	@FindBy(xpath="//*[@class='mat-checkbox-inner-container']")
	public static WebElement successOnSignUp;
	
	@FindBy(xpath="(//span[@aria-hidden='true'])[4]")
	public static WebElement astrixSymbol;
	
	@FindBy(xpath="(//span[@aria-hidden='true'])[3]")
	public static WebElement astrix_ymbol;
	
	
	
	
	
	/*
	 * public static WebElement personalProfile(String data) { String Xpath =
	 * "//label[@id='$']"; WebElement element =
	 * Base.driver.findElement(By.xpath(Xpath.replace("$", data))); return element;
	 * }
	 * 
	 * public static WebElement PasswordField(String data) { String Xpath =
	 * "//h1[text()=' $ ']"; WebElement element =
	 * Base.driver.findElement(By.xpath(Xpath.replace("$", data))); return element;
	 * }
	 * 
	 * public static WebElement enterOTP(String string) { String xpath =
	 * "//ng-otp-input[1]//input[$]"; WebElement element =
	 * Base.driver.findElement(By.xpath(xpath.replace("$", string))); return
	 * element; }
	 */
	
	@FindBy(xpath="//div[@class='login-info pt-5']")
	public static WebElement loginInfo;
	
	@FindBy(xpath="//span[text()='Mobile number is mandatory.']")
	public static WebElement mobileNOIsMand;
	
	@FindBy(xpath="//*[text()='Enter valid Mobile number.']")
	public static WebElement entValidMoNumber;
	
	@FindBy(xpath="//div[text()=' Mobile number already registered. ']")
	public static WebElement mobNoAlreadyReg;
	
	//*[@aria-label='Invalid username or password']
	
	//TS5
	@FindBy(xpath="//input[@formcontrolname='email']")
	public static  WebElement emailId;
	
	       
	@FindBy(xpath="//input[@formcontrolname='password']")
	public static WebElement passWd;

	@FindBy(xpath="//span[text()='Sign In']")
	public static WebElement sub;
	
	@FindBy(xpath="//*[text()=' Continue With Free Version ']")
	public static WebElement clickOnContWithfreeVersion;
	
	
	       
	
	@FindBy(xpath="//span[text()='Dashboard']")
	public static WebElement dashboard;


	@FindBy(xpath="//*[text()='more_vert']")
	public static WebElement icon;

	@FindBy(xpath="//span[text()=' account_circle']")
	public static WebElement profile;
  
	@FindBy(xpath="//span[text()=' account_circle']")
	public static WebElement Profile1;

	@FindBy(xpath="//*[text()='Manage Account']")
	public static WebElement mangeAcc;
	
	@FindBy(xpath="//span[text()=' Cancel Subscription ']")
	public static WebElement Cancel_Subscription;
	
	
	//span[text()=' Cancel Subscription ']
	@FindBy(xpath="//span[text()=' exit_to_app ']")
	public static  WebElement clickLogOut;
	
	@FindBy(xpath="//span[text()='Buy Now']")
	public static  WebElement clickBuyNow;
	
	@FindBy(xpath="//span[text()='Upgrade']")
	public static  WebElement btnUpgrade;
	
	@FindBy(xpath="//span[text()=' Buy Now ']")
	public static  WebElement btnBuyNow;
	
	
	@FindBy(xpath="//span[text()='Buy Now']")
	public static  WebElement Btn_Buy_Now;
	
	@FindBy(xpath="//span[text()='View Plan']")
	public static  WebElement btnViewPlan;
	
	@FindBy(xpath="//span[text()='Plan']")
	public static  WebElement indiPlan;
	
	@FindBy(xpath="//div[@class='sub-section-content row']")
	public static  WebElement elements;
	@FindBy(xpath="//li[text()=' 80 Documents ']")
	public static  WebElement eightyDoc;
	
	@FindBy(xpath="//li[text()=' 5 Templates ']")
	public static  WebElement fiveDoc;
	
	@FindBy(xpath="//li[text()=' Upload PDF using Google Drive ']")
	public static  WebElement uploadPdfUsingGoogleDrive;
	
	@FindBy(xpath="//li[text()=' Upload PDF using Dropbox ']")
	public static  WebElement uploadPdfUsingDropbox;
	
	@FindBy(xpath="//li[text()=' Upload PDF using OneDrive ']")
	public static  WebElement uploadPdfUsingOneDrive;
	
	@FindBy(xpath="//li[text()=' Self sign ']")
	public static  WebElement Self_Sign_Text;
	
	@FindBy(xpath="//li[text()=' Group Sign ']")
	public static  WebElement Grp_Sign_Text;
	
	@FindBy(xpath="//li[text()=' MFA & verified by trusted certification authority ']")
	public static  WebElement MFAAndverifiedByTrustedCertificationAuthority;
	
	@FindBy(xpath="//li[text()=' Audit Trail with Time stamps ']")
	public static  WebElement AuditTrailwithTimestamps;
	
	@FindBy(xpath="//li[text()=' Google Sign in ']")
	public static  WebElement GoogleSignIn;
	
	@FindBy(xpath="//li[text()=' Signatures: Type, Draw or Upload ']")
	public static  WebElement TypeDraworUpload ;
	
	@FindBy(xpath="//li[text()=' Document Tracking: Notify, Remove and Reassign ']")
	public static  WebElement  NotifyRemoveAndReassign ;
	
	@FindBy(xpath="//li[text()=' Hierarchical Signatures ']")
	public static  WebElement  HierarchicalSignatures ;
	
	 @FindBy(xpath="//label[text()='Group Sign']")
	  public static WebElement grpSignBtn;
	 
	 
	 @FindBy(xpath="//span[text()=' Save and Continue ']")
	    public static WebElement btnSaveAndCon;
	 
	 @FindBy(xpath="//div[text()=' File uploaded successfully ']")
	    public static WebElement fileUploadSuccessfully;
	 
	 
	    @FindBy(xpath="//input[@formcontrolname='signerName']")
	    public static WebElement signName;
	    @FindBy(xpath="//input[@placeholder='Signatory Email ID']")
	    public static WebElement signEmailId;
	
	    
	    @FindBy(xpath=" //*[@id=\"mat-tab-label-2-1\"]/div/div/label/img")
	    public static WebElement addSignatory;
	    
		@FindBy(xpath="(//div[@class='mat-checkbox-inner-container'])[3]")
		public static  WebElement check_Box;
		
		@FindBy(xpath="//input[@formcontrolname='password']")
		public static  WebElement Password_Field;
		
		@FindBy(xpath="//h1[text()=' Please enter the password to proceed ']")
		public static  WebElement PleaseEnterThePassword;
		
		
		@FindBy(xpath="//input[@type='password']")
		public static  WebElement EnterPassword;
		
		@FindBy(xpath="//span[text()='Submit']")
		public static  WebElement clickSubmit;
		
		@FindBy(xpath="//span[text()='You have entered incorrect password']")
		public static  WebElement YouHaveEnteredIncorrectPassword;
		
		@FindBy(xpath="//span[@aria-hidden='true']")
		public static  WebElement Symbol_Astrix;
		
		@FindBy(xpath="//h1[text()='Consent to Proceed Electronically']")
		public static  WebElement ConsentToProceedElectronically;
		
		@FindBy(xpath="//div[text()='Out for Signature']")
		public static  WebElement OutforSignature;
	
		
		@FindBy(xpath="//td[@id='accordian1']")
		public static  WebElement plus_Icon;
		
		@FindBy(xpath="(//a[@class='ng-star-inserted'])[9]")
		public static  WebElement Reassign;
		
		@FindBy(xpath="//span[text()='Yes']")
		public static  WebElement Yes_Btn;
		
		@FindBy(xpath="//input[@formcontrolname='newName']")
		public static  WebElement New_Name;
		
		@FindBy(xpath="//input[@type='email']")
		public static  WebElement Email_Address;
		
		@FindBy(xpath="//img[@alt='DrySign logo']")
		public static  WebElement Blank_Page;
		
		//div[@class='card-body arrow-section']
	@FindBy(xpath="//button[text()='Upgrade Plan']")
	public static  WebElement btnUpgradePlan;
	//span[text()=' Buy Now ']
	//div[@class='section-plan p-3']
	
	@FindBy(xpath="//div[@class='section-plan p-3']")
	public static  WebElement Plan_Details;
	
	@FindBy(xpath="//a[text()='Pricing']")
	public static  WebElement tabPricing;
	
	
	@FindBy(xpath="//div[text()='Annual Plans']")
	public static  WebElement plansAnnual;
	
	@FindBy(xpath="//div[@id='main']")
	public static  WebElement plansAllAnnual;
	
	@FindBy(xpath="//div[@class='sub-section-wrap dashboard-outer-box py-3 px-3 ng-star-inserted']")
	public static  WebElement Card_Body;
	
	//h1[text()='PAYMENT CONFIRMATION']
	
	@FindBy(xpath="//h1[text()='PAYMENT CONFIRMATION']")
	public static  WebElement PAYMENT_CONFIRMATION;
	
	@FindBy(xpath="(//h2[@id='sub-section-title'])[6]")
	public static  WebElement Professional_Plan_text;
	
	@FindBy(xpath="//a[text()='Login']")
	public static  WebElement Login;
	
	
	
	
	//div[@class='sub-section-wrap dashboard-outer-box py-3 px-3 ng-star-inserted']
	//a[text()='Login']
	//div[@class='card-body']
	@FindBy(xpath="//div[@id='main']")
	public static  WebElement plansAllMonthly;
	
	@FindBy(xpath="//button[text()='Accept All Cookies']")
	public static  WebElement acceptAllCookies;
	
	@FindBy(xpath="//strong[text()='To proceed further, please Sign In or Sign Up to DrySign.']")
	public static  WebElement toproceedfurther;
	
	
	@FindBy(xpath="//a[text()='Confirm']")
	public static  WebElement btnConfirm;
	
	@FindBy(xpath="//div[text()='Monthly Plans']")
	public static  WebElement planMonthly;
	
	@FindBy(xpath="//div[text()='Premium']")
	public static  WebElement planPremium;
	
	@FindBy(xpath="//a[text()='Buy Now'][1]")
	public static  WebElement nowBuy;
	
	//a[text()='Buy Now']
	
	@FindBy(xpath="(//mat-icon[@role='img'])[10]")
	public static  WebElement closeIcon;
	
	@FindBy(xpath="//div[@class='section-plans ng-star-inserted']")
	public static  WebElement professional;
	
	
	@FindBy(xpath="//span[text()=' Edit ']")
	public static WebElement btnEdit;
	
	@FindBy(xpath="//input[@placeholder='ZIP Code']")
	public static WebElement Zip_code;
	
	@FindBy(xpath="//mat-error[text()=' ZiP code should be minimum of 4 digit. ']")
	public static WebElement Zip_code_Min_Four_Digit;
	
	@FindBy(xpath=" //div[text()=' Please Note: Cancel Subscription is not available for free corporate Subscription plan users. ']")
	public static WebElement  Cancel_Subscription_Is_Not_Available;
	
	 
	//mat-error[text()=' ZiP code should be minimum of 4 digit. ']
	
	//div[text()='Personal Information']
	
	@FindBy(xpath="//div[text()='Personal Information']")
	public static WebElement Personal_Information;

	
	@FindBy(xpath="//*[@id='mat-tab-content-0-0']")
	public static WebElement personalInfoPage;
	
	@FindBy(xpath="//mat-select[@formcontrolname='countryCode']")
	public static WebElement countryCode;
	
	
	@FindBy(xpath="//span[text()=' Save ']")
	public static WebElement btnSave;
	
	@FindBy(xpath="//input[@name='CreditCardHolderName']")
	public static WebElement txtCardHolderName;


	@FindBy(xpath="//input[@name='CreditCardNumber']")
	public static WebElement txtCreditCardNumber;

	@FindBy(xpath="//select[@name='CreditExpiryMonth']")
	public static WebElement ddlCreditExpiryMonth;

	@FindBy(xpath="//select[@name='CreditExpiryYear']")
	public static WebElement ddlCreditExpiryYear;


	@FindBy(xpath="//input[@name='CreditCvv']")
	public static WebElement txtCreditCvv;

	@FindBy(xpath="//button[@id='credit']")
	public static WebElement btnPay;
	//TS6
	@FindBy(xpath="//button[@type='button']")
    public static WebElement signInWithGoogle;

	
    @FindBy(xpath="//input[@type='email']")          
    public static WebElement userName;
         
 
    @FindBy(xpath="//*[text()='Sign in']")
    public static WebElement popUp;

    @FindBy(xpath="//span[text()='Next']")
    public static WebElement btnNext;


    @FindBy(xpath="//*[text()='Enter your password']")
    public static WebElement pass;

    @FindBy(xpath="//input[@formcontrolname='phone']")
    public static WebElement mobNum;

    @FindBy(xpath="//*[text()='OK']")
    public static WebElement okButton;
    
    @FindBy(xpath="//*[text()='Next']")
    public static WebElement clickNext;
    
    @FindBy(xpath="//a[text()='Terms and Conditions']")
    public static WebElement termsAndConditions;
    
    @FindBy(xpath="//a[text()='HERE']")
    public static WebElement clickOnHerelink;
    
  //span[text()='Confirm']
    
    @FindBy(xpath="//div[@class='main-content-fixed-header bg-white']")
    public static WebElement refundPage;
    
 
    @FindBy(xpath="//input[@placeholder='Name']")
    public static WebElement entName;
  
    
    @FindBy(xpath="//input[@placeholder='Email id']")
    public static WebElement entEmailId;
  
    @FindBy(xpath="//input[@placeholder='Subscription Plan']")
    public static WebElement entSubscriptionPlan;

    
    @FindBy(xpath="//input[@placeholder='Subscription ID']")
    public static WebElement entSubscriptionId;
    
    @FindBy(xpath="//span[text()='Confirm']")
    public static WebElement confirmBtnOnRefund;
    
    @FindBy(xpath="//button[@tabindex='-1'][2]")
    public static WebElement confirmBtnOnPopUp;
    
  //button[@tabindex='-1'][2]
    
    @FindBy(xpath="//h1[text()=' Refund ']")
    public static WebElement refundPopUp;
  //h1[text()=' Refund ']
    
    @FindBy(xpath="//span[text()='Upgrade'][1]")
    public static WebElement btnUpgradeDash;
    
    @FindBy(xpath="//div[text()=' Your refund has been successful. ']")
    public static WebElement yourRefundHasBeenSuccessful;
  //img[@id='logo']
    
    
  //span[text()='Ok']
    
    @FindBy(xpath="//span[text()='Ok']")
    public static WebElement Ok_Btn;
    
    @FindBy(xpath="//img[@id='logo']")
    public static WebElement drySignLogo;
    
    @FindBy(xpath="//span[text()=' Buy Now ']")
    public static WebElement buyNowGeneralPlan;
    
    @FindBy(xpath="//span[text()='Buy Now']")
    public static WebElement buyNowNoActivePlan;
    
    @FindBy(xpath="//h1[text()='General Plans']")
    public static WebElement generalPlans;
    
    @FindBy(xpath="//button[text()='Accept All Cookies']")
	public static WebElement Accept_All_Cookies;
  
  //TS8
    @FindBy(xpath="//input[@placeholder='Contact Number']")
    public static WebElement contactNumber;
 
    
    @FindBy(xpath="//span[text()=' Delete Account ']")
    public static WebElement deleteAccount;
    
    @FindBy(xpath="//h1[text()=' Deleting Your Account ']")
    public static WebElement deleteYourAccount;
    
    @FindBy(xpath="//p[@class='text strong ng-star-inserted']")
    public static WebElement deleteYourAccountPopUp;
    
  //p[@class='text strong ng-star-inserted']
    
    @FindBy(xpath="//p[@class='text strong ng-star-inserted']")
    public static WebElement popContWithFreeVersion;
    
    
	@FindBy(xpath="//div[text()='Security']")     
	public static  WebElement tabSecurity;
	
	@FindBy(xpath="//span[text()='Email OTP ']")
	public static  WebElement emailOtp;
	
	@FindBy(xpath="//span[text()='Setup Secure Code ']")
	public static  WebElement setupSecureCode;
	
	@FindBy(xpath="//label[text()='Confirm Secure Code']")
	public static  WebElement textConfirmSecureCode;
	
	
	
	@FindBy(xpath="//span[text()=' Update ']")     
	public static  WebElement tabSecurityUpdate;
	
	@FindBy(xpath="//span[text()='OK']")     
	public static  WebElement tabSecurityOk;
	
	@FindBy(xpath="//div[@class='wrapper-lg']")     
	public static  WebElement onLogInpage;
	
	@FindBy(xpath="//span[text()='Send One Time Password']")     
	public static  WebElement sendOneTimePassword;
	
	@FindBy(xpath="//input[@placeholder='Enter Public Mailinator Inbox']")     
	public static  WebElement mailinatorInput;
	
	@FindBy(xpath="//input[@id='inbox_field']")     
	public static  WebElement mailinatorInPut1;
	
	@FindBy(xpath="//div[text()=' Please enter the Valid Secure Code ']")     
	public static  WebElement Pls_Enter_Valid_Secure_Code;
	
	@FindBy(xpath="//span[text()=' Cancel ']")     
	public static  WebElement Cancel_Button;
	
	@FindBy(xpath="//span[text()='Secure Code doest not match']")     
	public static  WebElement SecureCodeDoestNotMatch;
	
	@FindBy(xpath="//p[text()='The Secure Code provided is incorrect. Please enter the correct code and try again.']")     
	public static  WebElement SecureCodeProvidedIsIncorrect;
	
	@FindBy(xpath="//p[text()='The One Time Password provided is incorrect, please try again.']")     
	public static  WebElement oneTimePasswdIsIncorrect;
	
	
	
	
	//a[text()=' Resend One Time Password ']
	
	
	@FindBy(xpath="//a[text()=' Resend One Time Password ']")     
	public static  WebElement ResendOneTimePassword;
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath="//a[text()=' Resend One Time Password ']")     
	public static  WebElement resendOneTimePasswdLink;
	
	@FindBy(xpath="//button[@class='primary-btn']")     
	public static  WebElement clickGo;
	
	@FindBy(xpath="//span[text()='Verify']")     
	public static  WebElement clickOnVerify;
	
	@FindBy(xpath="//*[@id='pause_light']")     
	public static  WebElement pauseLight;
	
	@FindBy(xpath="//td[@class='ng-binding']")     
	public static  WebElement clickOnDrySign;
	
	//*[@id="pause_light"]
	@FindBy(xpath="//td[contains(text(),'just now')]/preceding-sibling::td[contains(text(),'One Time Password')]")     
	public static  WebElement clickOnOTP;
	
	@FindBy(xpath="//p[contains(text(),'Your One Time Password (OTP)')]")  //p[contains(text(),'Your One Time Password')]
	public static  WebElement copyText;
	
	@FindBy(xpath = "//p[contains(text(),'Your One Time Password')]")
	public static WebElement otp;
	
	@FindBy(xpath="//iframe[@id='html_msg_body']")     
	public static  WebElement bodyIframe;
	
	@FindBy(xpath="//p[text()='Secure Code successfully updated']")     
	public static  WebElement secureCodeSuccessfullyOnPop;
	
	@FindBy(xpath="//a[text()='Sign Document']")     
	public static  WebElement Sign_Document;
	//a[text()='Sign Document']
	
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[1]")     
	public static  WebElement code1;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[2]")     
	public static  WebElement code2;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[3]")     
	public static  WebElement code3;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[4]")     
	public static  WebElement code4;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[5]")     
	public static  WebElement code5;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[6]")     
	public static  WebElement code6;
	
	
	
	
	

	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[7]")     
	public static  WebElement code7;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[8]")     
	public static  WebElement code8;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[9]")     
	public static  WebElement code9;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[10]")     
	public static  WebElement code10;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[11]")     
	public static  WebElement code11;
	@FindBy(xpath="(//input[@autocomplete='one-time-code'])[12]")     
	public static  WebElement code12;
	
	
	@FindBy(xpath="//a[text()=' Forgot Your Secure Code? ']")     
	public static  WebElement forgotYourSecureCode;
	
	@FindBy(xpath="//span[text()='OK']")     
	public static  WebElement ok;
	
	
	
	
//	public static WebElement enterSecurePassword(String string)
//	{
//	String xpath = "//i//ng-otp-input[1]//input[$]";
//	WebElement element = Base.driver.findElement(By.xpath(xpath.replace("$", string)));
//	return element;
//	}

	
	/*
	 * public static WebElement SecurePassword(String string1) { WebElement element
	 * = Base.driver.findElement(By.
	 * xpath("//label[text()='Enter Secure Code']/following-sibling::ng-otp-input//input[$]"
	 * .replace("$", string1)));
	 * 
	 * return element; }
	 * 
	 * public static WebElement confirmSecurePassword(String string) { WebElement
	 * element = Base.driver.findElement(By.
	 * xpath("//label[text()='Confirm Secure Code']/following-sibling::ng-otp-input//input[$]"
	 * .replace("$", string)));
	 * 
	 * return element; }
	 * 
	 * public static WebElement Securecode(String string) { WebElement element =
	 * Base.driver.findElement(By.
	 * xpath("//mat-label[text()='Secure Code']/following-sibling::ng-otp-input//input[$]"
	 * .replace("$", string)));
	 * 
	 * return element; }
	 * 
	 * public static WebElement confirmSecureCode(String string) { WebElement
	 * element = Base.driver.findElement(By.
	 * xpath("//mat-label[text()='Confirm Secure Code']/following-sibling::ng-otp-input//input[$]"
	 * .replace("$", string)));
	 * 
	 * return element; }
	 * 
	 */
	
//MYFILES
	@FindBy(xpath="//span[text()='My Files']")     
	public static  WebElement clickOnMyFiles;
	
	@FindBy(xpath="//input[@id='search']")     
	public static  WebElement searchBox;
	
	
	
	@FindBy(xpath="//span[text()=' sign ']")     
	public static  WebElement genricAction;
	
	
	
	@FindBy(xpath="//input[@data-column='subject']")     
	public static  WebElement subjectColumn;
	
	@FindBy(xpath="(//input[@placeholder='Filter'])[3]")     
	public static  WebElement Completed_Date;
	
	@FindBy(xpath="//span[text()=' Sign Type ']")     
	public static  WebElement Sign_Type;
	
	@FindBy(xpath="//input[@data-column='fileName']")     
	public static  WebElement documentName;
	
	@FindBy(xpath="//input[@data-column='assignedDate']")     
	public static  WebElement assignedDate;
	
	@FindBy(xpath="//input[@data-column='requestedBy']")     
	public static  WebElement requestedBy;
	
	@FindBy(xpath="//tr[@id='accordion0']")     
	public static  WebElement totalColumnData;
	
	@FindBy(xpath="//div[text()='Rejected']")     
	public static  WebElement tabRejected;
	
	@FindBy(xpath="//div[text()='Signed']")     
	public static  WebElement tabSigned;
	
	
	//div[text()='Signed']
	
	//div[@aria-controls='mat-tab-content-7-5']
	//mat-icon[text()='remove_red_eye']
	@FindBy(xpath="//mat-icon[text()='remove_red_eye']")     
	public static  WebElement iconView;
	
	//div[@class='textLayer']
	
	@FindBy(xpath="//div[@class='textLayer']")     
	public static  WebElement viewRejectedDoc;
	//mat-icon[text()='close']
	
	@FindBy(xpath="//div[@class='textLayer']")     
	public static  WebElement docCompleted;
	
	@FindBy(xpath="//mat-icon[text()='close']")     
	public static  WebElement clickCloseIcon;
	
	@FindBy(xpath="//mat-icon[text()='cloud_download']")     
	public static  WebElement cloudDownload;
	
	@FindBy(xpath="//td[@id='accordian0']")     
	public static  WebElement iconPlus;
	
	@FindBy(xpath="(//tr[@class='hide-table-padding ng-star-inserted'])[1]")     
	public static  WebElement detailsRejected;
	//div[@class='col-12 col-sm-12 col-md-12']
	//tr[@id='accordion1']
	
	@FindBy(xpath="//div[@class='col-12 col-sm-12 col-md-12']")     
	public static  WebElement downloadDocDisplay;
	
	@FindBy(xpath="//div[text()='Drafts']")     
	public static  WebElement tabDrafts;
	
	@FindBy(xpath="(//div[@class='ng-star-inserted'])[1]")     
	public static  WebElement iconDelete;
	
	@FindBy(xpath="//mat-icon[text()='edit']")     
	public static  WebElement iconEdit;
	
	@FindBy(xpath="//div[@id='uploaded-doc-wrapper']")     
	public static  WebElement redirectScreen;
	
	@FindBy(xpath="//h1[text()=' Delete documents from drafts ']")     
	public static  WebElement popUpDelete;
	
	@FindBy(xpath="//span[text()='Cancel']")     
	public static  WebElement popUpDeleteCancel;;
	
	
	
	
	@FindBy(xpath="//span[text()='Confirm']")     
	public static  WebElement popUpDeleteConfirm;
	
	@FindBy(xpath="//div[text()=' Successfully deleted ']")     
	public static  WebElement msgDeletedSuccessfully;
	
	@FindBy(xpath="//div[text()='Completed Documents']")     
	public static  WebElement tabCompletedDocument;
	
	@FindBy(xpath="//mat-icon[text()='mail_outline']")     
	public static  WebElement mailOutline;
	
	
	@FindBy(xpath="//h1[text()=' Send Email ']")     
	public static  WebElement sendEmailPopUp;
	
	@FindBy(xpath="//input[@formcontrolname='email']")     
	public static  WebElement recipientEmailAddress;
	
	@FindBy(xpath="//input[@formcontrolname='subject']")     
	public static  WebElement addSubject;
	
	@FindBy(xpath="//textarea[@formcontrolname='message']")     
	public static  WebElement msgBox;
	
	@FindBy(xpath="//input[@formcontrolname='cc']")     
	public static  WebElement cCEmail;
	
	
	@FindBy(xpath="//span[text()='Send']")     
	public static  WebElement btnSend;

	@FindBy(xpath="//div[text()=' Successfully Mail Sent ']")     
	public static  WebElement successfullyMailSent;
	
	@FindBy(xpath="//a[text()='Out for Signature (1) ']")     
	public static  WebElement outForSignature;
	
	
	@FindBy(xpath="//td[@class='ng-binding']")     
	public static  WebElement grpSignMail;
	
	@FindBy(xpath="//td[@class='ng-binding']")     
	public static  WebElement Reset_Secure_code_Malin;
	
	@FindBy(xpath="//a[text()='Sign Document']")     
	public static  WebElement signDocument;
	
	
	@FindBy(xpath="//a[text()='Reset Secure Code']")     
	public static  WebElement Reset_Secure_Code_Link;
	
	
	//a[text()='Reset Secure Code']
	
	@FindBy(xpath="//input[@type='checkbox']")     
	public static  WebElement checkBox;
	
	@FindBy(xpath="//button[text()='Accept']")     
	public static  WebElement acceptBtn;
	
	@FindBy(xpath="//button[text()='Ok']")     
	public static  WebElement okButn;
	
	@FindBy(xpath="//div[@class='annotation_placeholder']")     
	public static  WebElement clickOnSignature;
	
	@FindBy(xpath="//iframe[@title='PSPDFKit']")     
	public static  WebElement iFrame_Doc;
	
	@FindBy(xpath="//iframe[@id='ssIFrame_google']")     
	public static  WebElement iFrame_Type;
	

	//iframe[@id='ssIFrame_google']
	@FindBy(xpath="(//div[@class='mat-tab-label-content'])[2]")     
	public static  WebElement clickonType;
	
	@FindBy(xpath="//span[@id='image-section-1']")     
	public static  WebElement selectSignature;
	
	@FindBy(xpath="//button[text()='Save']")     
	public static  WebElement Save_Doc;
	
	
	@FindBy(xpath="//i[text()='Finish']")     
	public static  WebElement Finish_Doc;
	
	

	@FindBy(xpath="//h3[text()='You have successfully signed this document.']")     
	public static  WebElement successfullySignedDocPage;
	
	@FindBy(xpath="//div[@class='mat-form-field-suffix ng-tns-c153-24 ng-star-inserted']")     
	public static  WebElement astrixSymbol1;
	
	//a[text()='Sign Document']
	//input[@type='checkbox']
	//span[text()='Accept']
//	(//td[@class='ng-binding'])[5]
	//div[text()='Signature']
//	(//div[@class='w-48 text-center sign-type-container sign-chips border p-2 mb-3 ng-star-inserted'])[1]
	//div[text()='TYPE']
	//div[@id='toast-container']
	//span[text()='Ok']
	//h3[text()='You have successfully signed this document.']
//	(//span[@aria-hidden='true'])[5]


//Multiple Doc Upload

@FindBy(xpath="//label[text()='Self Sign']")
public static WebElement selfSign;


@FindBy(xpath="//a[text()='Browse']")
public static WebElement browser;

@FindBy(xpath="//span[text()=' Upload Photo ']/..")
public static WebElement Upload_Btn;

@FindBy(xpath="//div[@class='image-upload-circle ng-star-inserted']")
public static WebElement Profile_Picture;


//div[@class='image-upload-circle ng-star-inserted']

@FindBy(xpath="//input[@placeholder='Name']")
public static WebElement Name_field;

@FindBy(xpath="//span[text()='First name is required.']")
public static WebElement FirstNameisrequired;

@FindBy(xpath="//div[text()=' Successfully Updated. ']")
public static WebElement Successfully_Updated;

//input[@placeholder='Street Address']

@FindBy(xpath="//input[@placeholder='Street Address']")
public static WebElement Stree_Address;

@FindBy(xpath="//h2[text()=' Plans ']")
public static WebElement Plans_PopUp;

@FindBy(xpath="(//h2[text()=' FREE VERSION '])[2]")
public static WebElement FREE_VERSION;

@FindBy(xpath="//h2[text()=' INDIVIDUAL ']")
public static WebElement INDIVIDUAL;

@FindBy(xpath="//h2[text()=' PROFESSIONAL ']")
public static WebElement PROFESSIONAL;

@FindBy(xpath="(//span[text()=' Upgrade '])[1]")
public static WebElement Upgrade1;

@FindBy(xpath="(//span[text()=' Upgrade '])[2]")
public static WebElement Upgrade2;

@FindBy(xpath="(//span[text()=' Upgrade '])[3]")
public static WebElement Upgrade3;

@FindBy(xpath="(//span[text()=' Upgrade '])[4]")
public static WebElement Upgrade4;

//div[@class='d-flex sub-section-wrap dashboard-outer-box p-3']

@FindBy(xpath="//div[@class='d-flex sub-section-wrap dashboard-outer-box p-3']")
public static WebElement Pie_Chart1;

@FindBy(xpath="//div[@class='col-12 col-sm-12 col-md-6 pe-md-0']")
public static WebElement Pie_Chart2;

@FindBy(xpath="(//span[text()='Upgrade'])[1]")
public static WebElement Upgrade5;

@FindBy(xpath="(//span[text()='Upgrade'])[2]")
public static WebElement Upgrade6;

@FindBy(xpath="//h2[text()=' INDIVIDUAL Plan']")
public static WebElement INDIVIDUAL_Plan;

@FindBy(xpath="//h2[text()=' PROFESSIONAL Plan']")
public static WebElement PROFESSIONAL_Plan;

@FindBy(xpath="(//*[@style='user-select: none;'])[5]")
public static WebElement Five_Documents;

@FindBy(xpath="(//*[@style='user-select: none;'])[5]")
public static WebElement Zero_Documents;

@FindBy(xpath="//h2[@id='sub-section-title']")
public static WebElement Individual_Plan;

@FindBy(xpath="(//span[text()='Self sign'])[1]")
public static WebElement Self_sign_Text;


@FindBy(xpath="(//span[text()='Group Sign'])[1]")
public static WebElement Group_sign_Text;
		
@FindBy(xpath="(//span[text()='Signatures: Type, Draw or Upload'])[1]")
public static WebElement Sign_Type_Draw_upload;

@FindBy(xpath="//h2[text()=' FREE VERSION ']")
public static WebElement FREEVERSION;

@FindBy(xpath="//*[text()='To proceed further, please Sign In or Sign Up to DrySign.']")
public static WebElement Toproceedfurther;

@FindBy(xpath="//*[text()='Confirm']")
public static WebElement Confirm_Btn;

@FindBy(xpath="(//*[text()='Cancel'])[3]")
public static WebElement Cancel_Btn;

@FindBy(xpath="//a[text()='Sign In']")
public static WebElement Sign_In;





}