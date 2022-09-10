package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObjects2{
	
	RemoteWebDriver driver;
	public pageObjects2(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='My Profile']")
	
	public  WebElement My_Profile;
	
	@FindBy(xpath="//input[@aria-label='ACTION NAMEFilter']")
	
	public  WebElement ACTION_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='ACTIONFilter']")
	
	public  WebElement ACTION_Filter;
	
	@FindBy(xpath="//a[contains(text(),'Settings')]")
	
	public  WebElement Settings;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	
	public  WebElement Delete;
	
	@FindBy(xpath="//input[@placeholder='Start Date']")
	
	public  WebElement Start_DateIn;
	
	@FindBy(xpath="//input[@placeholder='End Date']")
	
	public  WebElement End_Datein;
	
	public  WebElement Settings_Options(String data)
	{
		String Xpath = "//input[@title='$']//following-sibling::span";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement Settings_Option(String data)
	{
		String Xpath = "//input[@formcontrolname='receiveOutOfOfficeNotification' and @title='$']//following-sibling::span";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement Settings_Setting_Options(String data)
	{
		String Xpath = "//a[@aria-label='$']/i";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement YopmailSettingValue(String data)
	{
		String Xpath = "//span[contains(text(),'$')]//following::td[2]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="(//button[@aria-label='Open calendar'])[1]")
	
	public  WebElement FromCalender;
	
	@FindBy(xpath="//li//button[@id='nextButton']/i")
	
	public  WebElement rignhtArrow;
	
	@FindBy(xpath="//li[@class='annotationError']/a")
	
	public  WebElement annotationAndRedectionMsg;
	
	@FindBy(xpath="//li//button[@id='previousButton']/i")
	
	public  WebElement previousButton;
	
	@FindBy(xpath="//a[@title='Total Pages']")
	
	public  WebElement Total_Pages;
	
	@FindBy(xpath="(//button[@aria-label='Open calendar'])[2]")
	
	public  WebElement ToCalender;
	
	@FindBy(xpath="//span[text()='Save']")
	
	public  WebElement Save;
	
	@FindBy(xpath="//span[text()='SAVE']")
	
	public  WebElement SAVE;
	
	@FindBy(xpath="//input[@placeholder='End Date']//parent::div//following-sibling::div//span")
	
	public  WebElement End_Date;
	
	@FindBy(xpath="//input[@placeholder='Start Date']//parent::div//following-sibling::div//span")
	
	public  WebElement Start_Date;
	
	@FindBy(xpath="//button[@aria-label='Save Rule Condition']//span[text()='Save']")
	
	public  WebElement Save_RuleCondition;
	
	@FindBy(xpath="//input[@aria-label='RULE NAMEFilter']")
	
	public  WebElement RULE_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='LOGIN NAMEFilter']")
	
	public  WebElement LOGIN_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='ROLE NAMEFilter']")
	
	public  WebElement ROLE_NAMEFilter;
	
	@FindBy(xpath="//input[@placeholder='Select client']")
	
	public  WebElement SelectclientSearch;
	
	@FindBy(xpath="//span[text()='Look Up']")
	
	public  WebElement Look_Up;
	
	@FindBy(xpath="//span[text()='OK']")
	
	public  WebElement OK_btn;
	
	@FindBy(xpath="//span[contains(text(),'Add User')]")
	
	public  WebElement AddUser;
	
	@FindBy(xpath="//input[@placeholder='Graph Name*']")
	
	public  WebElement Graph_Name;
	
	public  WebElement FolderOptions(String data)
	{
		String Xpath = "(//mat-dialog-container[contains(@id,'mat-dialog')]//*[contains(@class,'ng-star-inserted') and contains(text(),'$')])[1]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement dropdownArrow(String data)
	{
		String Xpath = "//mat-select[@aria-label='$']//div[@class='mat-select-arrow-wrapper']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
	@FindBy(xpath="//mat-select[@aria-label='Select Project']//span/span")
	public  List<WebElement> SelectProjectOptions;
	
	
	public  WebElement dropdownArrowa(String data)
	{
		String Xpath = "//div[@class='mat-select-trigger']//span[contains(text(),'$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement Select_your_delivery_preference(String data)
	{
		String Xpath = "//strong[text()='Select your delivery preference']/parent::p/following-sibling::mat-radio-group/mat-radio-button//div[@class='mat-radio-label-content' and contains(text(),'$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//a[@title='Role-Menu Assignment']")
	
	public  WebElement Role_Menu_Assignment;
	
	@FindBy(xpath="//div[contains(@class,'ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary')]//span[text()]")
	public  List<WebElement> ActionList;
	
	@FindBy(xpath="//span[text()='Select client']")
	
	public  WebElement Select_client;
	
	@FindBy(xpath="(//td[@data-title='User Name'])[1]/span/span")
	
	public  WebElement UserRecordInTable;
	
	@FindBy(xpath="//input[@aria-label='CLIENT CODEFilter']")
	
	public  WebElement CLIENT_CODEFilter;
	
	@FindBy(xpath="//th[@id='fname']")
	
	public  WebElement UserNameHeader;
	
	@FindBy(xpath="//a[@aria-label='Assign Action']")
	
	public  WebElement Assign_Action;
	
	@FindBy(xpath="//input[@placeholder='Search User']")
	
	public  WebElement Search_User;
	
	@FindBy(xpath="//div[text()='Sub Menu of no-link']//parent::div//li//label//span/span[2]")
	public  List<WebElement> DMRSubMenuOptions;
	
	@FindBy(xpath="//li//span[@aria-label]")
	public  List<WebElement> DMRMenuOptions;

	
			
			@FindBy(xpath="(//a/span/strong)[1]")
			
			public  WebElement selectclientsearchselect;
	
	
	public  WebElement Search_User_Selection(String data)
	{
		String Xpath = "//div[@title='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement Assign_Action_Options(String data)
	{
		String Xpath = "//input[@aria-checked='false']//parent::div//following-sibling::span[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement EditRoles_Headers(String data)
	{
		String Xpath = "//a[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement EditRoles_SubOptions(String data)
	{
		String Xpath = "//span[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement Delivery_Priority(String data)
	{
		String Xpath = "//strong[text()='Delivery Priority']/parent::p/following-sibling::mat-radio-group/mat-radio-button//div[@class='mat-radio-label-content' and contains(text(),'$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement DMRMenusSelections(String data)
	{
		String Xpath = "(//li//span[@aria-label='$' or contains(text(),'$')])[1]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement DMRSubMenusSelections(String data)
	{
		String Xpath = "//div[text()='Sub Menu of no-link']//parent::div//li//label//span/span[contains(text()='$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement ClientSetUpSubMenu(String data)
	{
		String Xpath = "//a[@aria-label='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement CoustamizeOption(String data)
	{
		String Xpath = "//mat-pseudo-checkbox[@class='mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted']//following::span[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement CoustamizeOptiondelect(String data)
	{
		String Xpath = "//mat-pseudo-checkbox[@class='mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted mat-pseudo-checkbox-checked']//following::span[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//button[text()='Manage Address']")
	
	public  WebElement Manage_Address;
	
	@FindBy(xpath="//h3[text()='Do you want to save this preference for next login?']")
	
	public  WebElement Custom_Msg_ACK;
	
	@FindBy(xpath="//a[@aria-label='Save Preference']")
	
	public  WebElement Save_Preference;
	
	
	@FindBy(xpath="//div[@class='action-wrap']//span[text()='Next']")
	
	public  WebElement Trigger_Next;
	
	@FindBy(xpath="//span[text()='Create']")
	
	public  WebElement Create_btn;
	
	@FindBy(xpath="//div[@class='action-wrap row']//span[text()='Next']")
	
	public  WebElement ruleCondition_Next;
	
	@FindBy(xpath="//a[text()='Routing Rule']")
	
	public  WebElement Routing_Rule;
	
	@FindBy(xpath="//input[@placeholder='Value*']")
	
	public  WebElement Rule_Value;
	
	@FindBy(xpath="//button//span[contains(text(),'Add')]")
	
	public  WebElement Add;
	
	@FindBy(xpath="//button//span[contains(text(),'ADD')]")
	
	public  WebElement ADD;
	
	@FindBy(xpath="//span[contains(text(),'Add New')]")
	
	public  WebElement Add_New;
	
	@FindBy(xpath="//span[contains(text(),'Add Role')]")
	
	public  WebElement Add_Role;
	
	@FindBy(xpath="//input[@aria-label='ROLE NAMEFilter']")
	
	public  WebElement ROLE_NAMEFilter1;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	
	public  WebElement Edit_Icon;
	
	@FindBy(xpath="//input[@placeholder='Max. Retention Period (In Days)']")
	
	public  WebElement Max_Retention_Period_In_Days;
	
	@FindBy(xpath="//input[@placeholder='Retention Period (In Days) For deleted Items']")
	
	public  WebElement Retention_Period_In_Days_For_deleted_Items;
	
	
	@FindBy(xpath="//input[@placeholder='Role Name*']")
	
	public  WebElement Role_Name;
	
	@FindBy(xpath="//input[@aria-label='RECEIVED DATEFilter']")
	
	public  WebElement RECEIVED_DATEFilter;
	
	@FindBy(xpath="//td[@data-title='RECEIVED DATE/TIME']/span/span")
	
	public  WebElement RECEIVED_DATE_TIME;
	
	@FindBy(xpath="//td[@data-title='VOLUME RECEIVED']/span/span")
	
	public  WebElement VOLUME_RECEIVED_Count;
	
	@FindBy(xpath="(//td[@data-title='VOLUME']/span/span)[1]")
	
	public  WebElement filtered_Total_Volume;
	
	@FindBy(xpath="//span[@aria-label='Forgot password']")
	
	public  WebElement Forgot_Password;
	
	@FindBy(xpath="//tr//p[2]//span/span")
	
	public  WebElement OTP_Text;
	
	@FindBy(xpath="//td[@class='whc bordfin_gbd alt']//iframe[@class='whc']")
	
	public  WebElement YopmailBodyIframe;
	
	@FindBy(xpath="//button[@aria-label='Submit']")
	
	public  WebElement OTP_SubmitBtn;
	
	@FindBy(xpath="//input[@id='EnterOTP']")
	
	public  WebElement OTP_Textbox;
	
	@FindBy(xpath="//input[@id='password']")
	
	public  WebElement forgotpassword_Passwordtxtbox;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	
	public  WebElement forgotpassword_confirmPasswordtxtbox;
	
	@FindBy(xpath="//button[@title='Change Password']")
	
	public  WebElement Change_Password_btn;

	@FindBy(xpath="//td[@data-title='PROCESSED']/span/span")
	
	public  WebElement PROCESSED_Count;
	
	@FindBy(xpath="//select[@aria-label='Number Of Pages']")
	
	public  WebElement Number_Of_Pages;
	
	@FindBy(xpath="//a[@title='Next']")
	
	public  WebElement Next_btn;
	
	@FindBy(xpath="//div[@class='table-info ng-star-inserted']")
	
	public  WebElement Pagination_Number_Of_Records;
	
	@FindBy(xpath="//input[@placeholder='Enter Address 1*']")
	
	public  WebElement Enter_Address_1;
	
	@FindBy(xpath="//input[@placeholder='City *']")
	
	public  WebElement City;
	
	@FindBy(xpath="//input[@placeholder='State *']")
	
	public  WebElement State;
	
	@FindBy(xpath="//input[@placeholder='Email Subject*']")
	
	public  WebElement Email_Subject;
	
	@FindBy(xpath="(//i[@class='fa fa-pencil'])[1]")
	
	public  WebElement clientsetup_EditIcon;
	
	@FindBy(xpath="//span[text()='Assign']")
	
	public  WebElement Assigns;
	
	public  WebElement MailTemplete_Options(String data)
	{
		String Xpath = "//span[@title='$']//parent::td//following-sibling::td//i";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//button[@aria-label='Add New Project DocType']//span")
	
	public  WebElement AddDocType;
	
	@FindBy(xpath="//span[@aria-label='Mail Template']")
	
	public  WebElement MailTemplete;
	
	@FindBy(xpath="//a[@title='DocType Setup']")
	
	public  WebElement DocTypeSetup;
	
	@FindBy(xpath="//input[@aria-label='PROJECT NAMEFilter']")
	
	public  WebElement PROJECT_NAMEFilter;
	
	@FindBy(xpath="//input[@aria-label='NAMEFilter']")
	
	public  WebElement NAMEFilter;
	
	@FindBy(xpath="//a[contains(text(),' Assign Templates ')]")
	
	public  WebElement Assign_Templates;
	
	public  WebElement Assign_Templates_Options(String data)
	{
		String Xpath = "//mat-checkbox[@class='mat-checkbox mat-accent']//span[contains(text(),'$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//input[@placeholder='Code']")
	
	public  WebElement Code;
	
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	
	public  WebElement Phone_Number;
	
	@FindBy(xpath="//input[@placeholder='Country *']")
	
	public  WebElement Country;
	
	@FindBy(xpath="//input[@placeholder='Enter Zipcode*']")
	
	public  WebElement Enter_Zipcode;
	
	@FindBy(xpath="//span[text()='Send']")
	
	public  WebElement Send_btn;
	
	@FindBy(xpath="//input[@placeholder='Rule Name*']")
	
	public  WebElement Rule_Name;
	
	@FindBy(xpath="//span[contains(text(),'Delegate Other User')]")
	
	public  WebElement Delegate_Other_User;
	
	@FindBy(xpath="//li[@class='ui-autocomplete-input-token']/input")
	
	public  WebElement DelegateInbox_Recipienttxtbox;
	
	@FindBy(xpath="//input[contains(@class,'ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted')]")
	
	public  WebElement DelegateInbox_Recipienttxtbox1;
	
	@FindBy(xpath="//div[@class='recipientEmail' and @title='$']")
	public  WebElement Recipient_Selection;
	
	@FindBy(xpath="//span[@class='igif lmenudelfl']")
	
	public  WebElement YopMail_DeletedrpArrow;
	
	@FindBy(xpath="//a[text()='Empty Inbox']")
	
	public  WebElement Empty_Inbox;
	
	@FindBy(xpath="//input[@placeholder='Enter Address Name*']")
	
	public  WebElement Enter_Address_Name;
	
	@FindBy(xpath="//input[@aria-label='TYPE OF ADDRESSFilter']")
	
	public  WebElement TYPE_OF_ADDRESSFilter;
	
	@FindBy(xpath="//input[@aria-label='GRAPH TITLEFilter']")
	
	public  WebElement GRAPH_TITLEFilter;
	
	@FindBy(xpath="//mat-option//span")
	public  List<WebElement> RuleFieldList;
	
	@FindBy(xpath="//div[contains(text(),'Advanced Search')]")
	
	public  WebElement Advanced_Search;
	
	@FindBy(xpath="//input[@aria-label='Sender Name']")
	
	public  WebElement Sender_Name;
	
	@FindBy(xpath="//input[@aria-label='Sender Company']")
	
	public  WebElement Sender_Company;
	
	public  WebElement textbox_filteroptions(String data)
	{
		String Xpath = "//input[@aria-label='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement textbox_filteroptions1(String data)
	{
		String Xpath = "//input[@placeholder='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement dropdown_filteroptions(String data)
	{
		String Xpath = "//div[@class='mat-select-value']//span[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement dropdown_filteroptions1(String data)
	{
		String Xpath = "//mat-select[@aria-label='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//th/span/span")
	public  List<WebElement> tableHeaders;
	
	@FindBy(xpath="//a[text()='Return To Volume Report']")
	
	public  WebElement Return_To_Volume_Report;
	
	@FindBy(xpath="//input[@aria-label='SCAN DATEFilter']")
	
	public  WebElement SCAN_DATEFilter;
	
	@FindBy(xpath="//input[@aria-label='DCNFilter']")
	
	public  WebElement DCNFilter;
	
	@FindBy(xpath="//div[@class='mat-select-value']//span[text()='Document Type']")
	
	public  WebElement Document_Type;
	
	@FindBy(xpath="//div[@class='mat-select-value']//span[text()='Location/Site']")
	
	public  WebElement Location_Site;
	
	@FindBy(xpath="//mat-select[@aria-label='Project']")
	
	public  WebElement Project;
	
	@FindBy(xpath="//div[@class='table-info ng-star-inserted']")
	
	public  WebElement tableInfoCount;
	
	@FindBy(xpath="//div[@class='rectangle']")
	
	public  WebElement DrawnRedaction;
	
	@FindBy(xpath="//div[@id='rectangle-2']")
	
	public  WebElement DrawnRedaction2;
	
	@FindBy(xpath="//div[@class='rectangle']")
	public  List<WebElement> ListDrawnRedaction;
	
	@FindBy(xpath="//div[@class='to-draw-rectangle']")
	
	public  WebElement redaction;
	
	@FindBy(xpath="//span[text()='Search']")
	
	public  WebElement Search_btn;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	
	public  WebElement redactionsave;
	
	@FindBy(xpath="//h2[contains(text(),'Total')]/a")
	
	public  WebElement totalCount;
	
	@FindBy(xpath="//div[contains(@class,'table-info')]")
	
	public  WebElement tableinfo_totalcount;
	
	@FindBy(xpath="(//td[@data-title='DCN']/span/span)[1]")
	
	public  WebElement DCNValue;
	
	@FindBy(xpath="(//i[contains(@class,'drag-handle fa fa-arrows-alt ')])[1]")
	
	public  WebElement DoubleClickArrow;
	
	@FindBy(xpath="//div/i[@class='fa fa-times']")
	
	public  WebElement redactionDelete;
	
	@FindBy(xpath="//div/i[@class='fa fa-times']")
	public  List<WebElement> ListredactionDelete;
	
	public  WebElement volumeReportsTableData(String data)
	{
		String Xpath = "//td[@data-title='$']//span/span";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement PDFPageheaders(String data)
	{
		String Xpath = "//a[@title='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement reportpageheaders(String data)
	{
		String Xpath = "//h2[contains(text(),'$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement citydropdwnSelection(String data)
	{
		String Xpath = "(//span[text()='$'])[1]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[text()='Completed']")
	
	public  WebElement CompletedFolder;
	
	@FindBy(xpath="//div//span[text()='Not My Mail']")
	
	public  WebElement Not_My_Mail_Folder;
	
	@FindBy(xpath="//a[@title='Open Mail']")
	
	public  WebElement Open_Mail;
	
	
	@FindBy(xpath="//span[@class='mat-option-text']")
	public  List<WebElement> FieldOptionsList;
	
	@FindBy(xpath="//ul[@id='steps-bar']//li//span")
	public  List<WebElement> Addruleoptions;
	
	@FindBy(xpath="//div[@class='full-width-input-wrap select-box-wrap addressList']//div[@class='mat-radio-label-content']")
	
	public  WebElement ManageDeliveryAddress;
	
	@FindBy(xpath="//input[@aria-label='USERFilter']")
	
	public  WebElement USERFilter;
	
	@FindBy(xpath="//input[@aria-label='EVENTFilter']")
	
	public  WebElement EVENTFilter;
	
	@FindBy(xpath="(//td[@data-title='STATUS']//span/span)[1]")
	
	public  WebElement STATUSValue;
	
	@FindBy(xpath="//span[text()='Undeliverable Mail']")
	
	public  WebElement Undeliverable_Mail;
	
	@FindBy(xpath="(//td[@data-title='EVENT']//span/span)[1]")
	
	public  WebElement EVENTName;
	
	@FindBy(xpath="(//td[@data-title='USER']//span/span)[1]")
	
	public  WebElement UsernameValue;
	
	@FindBy(xpath="//div[@class='flatpickr-calendar animate showTimeInput arrowTop open']//span[@class='flatpickr-day selected' or @class='flatpickr-day today selected']")
	
	public  WebElement Selecteddate;
	
	
	//********//
	
	public  WebElement InboxTableDataValid(String data)
	{
		String Xpath = "//table/tbody//tr[1]//*[contains(text(),'$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//table/tbody")
	
	public  WebElement Table_Valid;
	
	
	@FindBy(xpath="//table/thead//span/span")
	public  List<WebElement> TableHeaders_Valid;
	
	@FindBy(xpath="//div[@class='client-setup-tabs']//li/a")
	public  List<WebElement> EditRole_Headers;
	
	public  WebElement MainMenuArrow(String data)
	{
		String Xpath = "//span[text()='$']//ancestor::span/following-sibling::i[@class='fa fa-angle-right side-arrow']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//div[contains(text(),'Sub Menu of ')]/following::span[@class='mat-checkbox-label']")
	public  List<WebElement> SubMenu_Options;
	
	
	public  WebElement MainMenuCheckbox_Check(String data)
	{
		String Xpath = "//span[text()='$']//ancestor::mat-checkbox[contains(@class,'mat-accent')]//following::span[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
	@FindBy(xpath="//div[@class='main-dmr-dashboard-container']//h4")
	public  List<WebElement> DashboardContainer_Options;
	

	public  WebElement DashboardContainerData_Valid(String data)
	{
		String Xpath = "//h4[contains(text(),'$')]/preceding-sibling::h1";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//mat-select[@aria-label='Select Engagement']//span/span")
	
	public  WebElement SelectEngagement_DefaultValue;
	
	
	@FindBy(xpath="//mat-select[@id='mat-select-5']//span/span")
	
	public  WebElement LastDayRecords;
	
	
	
	@FindBy(xpath="//a[@aria-label='Reports']/following::a//span[@class='label-txt']")
	public  List<WebElement> ReportsSubMenu_options;
	
	@FindBy(xpath="//input[@aria-label='dcn']")
	
	public  WebElement DCN_TextBox;
	
	
	@FindBy(xpath="//select[@aria-label='Number Of Pages']")
	
	public  WebElement NoOfPages_DropDown;
	
	public  WebElement DisplayingPages_Valid(String data)
	{
		String Xpath = "//td[@data-title='No. of unique Users']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}

	
	@FindBy(xpath="//h2[contains(text(),'Total Active Users: ')]/a")
	
	public  WebElement TotalActiveUser_Link;
	
	
	@FindBy(xpath="//input[@aria-label='DATE/TIMEFilter']")
	
	public  WebElement DateTimeFilter;
	
	public  WebElement TabsLink(String data)
	{
		String Xpath = "//a[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	
	@FindBy(xpath="//input[@aria-label='FIRST NAMEFilter']")
	
	public  WebElement FirstNameFilter;
	
	@FindBy(xpath="//span[contains(text(),'Add Recipients')]")
	
	public  WebElement AddRecipients_btn;
	
	public  WebElement AddRecipients_Options(String data)
	{
		String Xpath = "//li/a[contains(text(),'$')]";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	public  WebElement ReachoutOption(String data)
	{
		String Xpath = "//span[@aria-label='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//input[@formcontrolname='firstname']")
	
	public  WebElement AddRecipients_FirstName;
	
	@FindBy(xpath="//input[@formcontrolname='lastname']")
	
	public  WebElement AddRecipients_LastName;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	
	public  WebElement AddRecipients_Email;
	
	@FindBy(xpath="//button/span[text()='ADD']")
	
	public  WebElement AddRecipients_ADD;
	
	@FindBy(xpath="//input[@aria-label='User NameFilter']")
	
	public  WebElement UserNameFilter;
	
	@FindBy(xpath="//input[@aria-label='ModuleFilter']")
	
	public  WebElement ModuleFilter;
	
	@FindBy(xpath="//input[@aria-label='RECIPIENT NAMEFilter']")
	
	public  WebElement RecipientNameFilter;
	
	
	
	@FindBy(xpath="//input[@aria-label='DateFilter']")
	
	public  WebElement DateFilter;
	
	@FindBy(xpath="//span[@style='display:block' and text()='Metadata']//following::tree-node-content/span[@style='display:block']")
	public  List<WebElement> MetadataOptions;
	
	@FindBy(xpath="//span[text()='Metadata']//parent::tree-node-content//parent::div//ancestor::tree-node-wrapper//span/span")
	
	public  WebElement Metadata;
	
	@FindBy(xpath="//span[text()='Extended Info']//parent::tree-node-content//parent::div//ancestor::tree-node//span/span")
	
	public  WebElement Extended_Info;
	
	public  WebElement HeaderAscending(String data)
	{
		String Xpath = "//thead/tr[1]/th//span[text()='$']";
		WebElement element = driver.findElement(By.xpath(Xpath.replace("$", data)));
		return element;
	}
	
	@FindBy(xpath="//span[@class='icon-arrow_left']")
	
	public  WebElement AddFields_LeftArrow;
	
	@FindBy(xpath="//div[@id='signer-1']")
	
	public  WebElement Name;
	
	@FindBy(xpath="//div[@id='signer-2']")
	
	public  WebElement Date;
	
	@FindBy(xpath="//div[@id='signer-3']")
	
	public  WebElement Signature;
	
			@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select name')]/span[@class='btn-select-arrow fa fa-angle-down'])[1]")
			
			public  WebElement NameDropDown;
	
			
	
					public  WebElement NameOptions()
					{
						String Xpath = "(//a[contains(@class,'btn btn-default btn-select name')]//li[text()])[1]";
						WebElement element = driver.findElement(By.xpath(Xpath));
						return element;
					}
					
					
	@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select date')]/span[@class='btn-select-arrow fa fa-angle-down'])[1]")
	
	public  WebElement DateDropdown;
	
	@FindBy(xpath="//div[@class='drop ui-droppable'][1]")
	
	public  WebElement droptarget;	
			
	@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select signature')]/span[@class='btn-select-arrow fa fa-angle-down'])[1]")
	
	public  WebElement signaturedropdown;
	
	@FindBy(xpath="(//a[contains(@class,'btn btn-default btn-select signature')]//li[text()])[1]")
	
	public  WebElement SignatureOption;
	
	@FindBy(xpath="//button[text()='Submit']")
	
	public  WebElement Submitbtn;
	
	@FindBy(xpath="//a[text()='Reset Password']")
	
	public  WebElement Reset_Password;
	
	@FindBy(xpath="//input[@aria-label='password']")
	
	public  WebElement Reset_Password_textbox;
	
	@FindBy(xpath="//p[2]/span/span")
	
	public  WebElement Reset_Password_mail_text;
	
	
	
	
	
}
