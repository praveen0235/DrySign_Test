package framework;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovyjarjarantlr4.v4.parse.ANTLRParser.action_return;


public class Elements{
	
	Waits waits = new Waits();
	
	public Logger log = Logger.getLogger(Elements.class);
	
	public  void TypeText(WebDriver driver,WebElement element, String data) {
		//scrollToElemet(driver,element);
		element.clear();
		//Thread.sleep(5000);
		element.click();
		element.sendKeys(data);
	}
	
	public void TypeTex(WebElement element, String data) {
		//scrollToElemet(element);
		element.clear();
		//Thread.sleep(5000);
		element.sendKeys(data);
		
	}
	
	public  void TypeTextWithOutText(WebElement element, String data) {
		//leep(5000);
		element.sendKeys(data);
	}

	public  void TypeTextIfElementPresent(WebElement element, String data) {
		if (element.isDisplayed()) {
			element.sendKeys(data);
		}
	}
	
	public  void redaction(WebDriver driver,WebElement element, int Xaxis,int Yaxis) {
		
		Actions action = new Actions(driver);
		//383,85
		//action.moveToElement(element).clickAndHold().moveByOffset(Xaxis, Yaxis).release().build().perform();	
		
		action.moveToElement(element).contextClick().moveByOffset(Xaxis, Yaxis).release().build().perform();
	}
	
	public  void clearTxtBox(WebElement element) {
		element.clear();
	}

	public  void typeRandomNumber(WebElement element, int data) {
		Random random = new Random();
		int rn = random.nextInt(100);
		String randomNumber = Integer.toString(rn);
		element.sendKeys(randomNumber);
	}

	public  String getTextBoxValue(WebElement element) {
		return element.getAttribute("value");
	}
	
	public  String getAttributeValue(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public  String getText(WebElement element){
		return element.getText();
	}
	
	public  boolean VerifyTextEquals(WebElement element,String expected){
		boolean flag=false;
		if(element.getText().equals(expected))
			return flag=true;
		return flag;
	}
	
	public  boolean VerifyTextnotEquals(WebElement element,String expected){
		boolean flag=false;
		if(!element.getText().equals(expected))
			return flag=true;
		return flag;
	}
	
	public  String getTitle(WebDriver driver){
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver){
		return driver.getCurrentUrl();
	}

	public boolean isSelected(WebElement element) {
		if (element.isSelected()) 
			return true;
		return false;
	}

	public void selectCheckBox(WebElement element) {
		if (!isSelected(element))
			element.click();
	}

	public void deSelectCheckbox(WebElement element) {
		if (isSelected(element))
			element.click();
	}

	public void selectRadioButton(WebElement element) {
		if (!isSelected(element))
			element.click();
	}

	public void deSelectRadioButton(WebElement element) {
		if (isSelected(element))
			element.click();
	}
	
	public  boolean isEnabled(WebElement element){
		if(element.isEnabled())
			return true;
		return false;
	}
	
	public  boolean isDisplayed(WebElement element){
		if(element.isDisplayed())
			return true;
		return false;
	}
	
	public  void selectByText(WebElement element,String text){
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement element,int index){
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public  void selectByValue(WebElement element,String value){
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public  String getFirstSelectedOption(WebElement element){
		Select select=new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public List<WebElement> getAllSelectedOptions(WebElement element){
		Select select=new Select(element);
		return select.getAllSelectedOptions();
		}
	
	public  List<WebElement> getAllOptions(WebElement element){
		Select select=new Select(element);
		return select.getOptions();
	}
	
	public void deSelectByText(WebElement element,String text){
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	
	public void deSelectByIndex(WebElement element,int index){
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	
	public void deSelectByValue(WebElement element,String value){
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	
	public  void click(WebDriver driver,final WebElement element){
		//div[@class='loading-wrap']//div[@class='sk-fading-circle loading-icon']
		waits.waitUntil(() ->isDisplayed(element), driver);
		//scrollToElemet(element);
		element.click();
		
				}
	
	public  void jclick(WebDriver driver,final WebElement element){
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        
        for(int i=0;i<=120;i++)
		{
		List<WebElement> spinner =driver.findElements(By.xpath("//div[@class='loading-wrap']//div"));
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
		
		for(int i=0;i<=60;i++)
		{
		List<WebElement> spinner =driver.findElements(By.xpath("//div[@class='loading-wrap']//div"));
		
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
	}
	
	public  void jTypeText(WebDriver driver,final WebElement element,String tData){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+tData+"';", element);
	}
	
	public  void Mouseclick(WebDriver driver,final WebElement element){
		//waits.waitUntil(() ->isDisplayed(element), driver);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
		/*for(int i=0;i<=120;i++)
		{
		List<WebElement> spinner =driver.findElements(By.xpath("//div[@class='loading-wrap']//div"));
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
		
		for(int i=0;i<=60;i++)
		{
		List<WebElement> spinner =driver.findElements(By.xpath("//div[@class='loading-wrap']//div"));
		
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}*/
	}
	
	public  void mouseDoubleclick(WebDriver driver,final WebElement element){
		waits.waitUntil(() ->isDisplayed(element), driver);
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().build().perform();
		
		for(int i=0;i<=120;i++)
		{
		List<WebElement> spinner =driver.findElements(By.xpath("//div[@class='loading-wrap']//div"));
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
		
		for(int i=0;i<=60;i++)
		{
		List<WebElement> spinner =driver.findElements(By.xpath("//div[@class='loading-wrap']//div"));
		
		try
		{
		if(spinner.size()==0)
		{
			break;
		}else
		{
			Thread.sleep(1000);
			//System.out.println(spinner.size());
		}
		}catch(Exception e)
		{
			
		}
		}
	}
	
	
	public void clickOnlyIfElementPresent(WebElement element){
		if(isDisplayed(element))
			element.click();
	}
	
	public Alert getAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void AcceptAlert(WebDriver driver) {
		getAlert(driver).accept();
	}
	
	public void DismissAlert(WebDriver driver) {
		getAlert(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		String text = getAlert(driver).getText();
		return text;
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void AcceptAlertIfPresent(WebDriver driver) {
		if (!isAlertPresent(driver))
			return;
		AcceptAlert(driver);
	}

	public void DismissAlertIfPresent(WebDriver driver) {

		if (!isAlertPresent(driver))
			return;
		DismissAlert(driver);
	}
	
	public void AcceptPrompt(WebDriver driver,String text) {
		
		if (!isAlertPresent(driver))
			return;
		
		Alert alert = getAlert(driver);
		alert.sendKeys(text);
		alert.accept();
	}

	/*public  void scrollToElemet(WebDriver driver,WebElement element) {
		waits.tryJavascript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}
	
	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
	}*/

	public  void scrollIntoView(WebDriver driver,WebElement element) {
		waits.tryJavascript(driver,"arguments[0].scrollIntoView()", element);
	}

	public  void scrollIntoViewAndClick(WebDriver driver,WebElement element) {
		scrollIntoView(driver,element);
		element.click();
	}
	
	/*public void scrollDownVertically() {
		waits.tryJavascript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		waits.tryJavascript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public void scrollDownByPixel() {
		waits.tryJavascript("window.scrollBy(0,1500)");
	}

	public void scrollUpByPixel() {
		waits.tryJavascript("window.scrollBy(0,-1500)");
	}

	public void ZoomInBypercentage() {
		waits.tryJavascript("document.body.style.zoom='40%'");
	}

	public void ZoomBy100percentage() {
		waits.tryJavascript("document.body.style.zoom='100%'");
	}
*/	
	public  void switchToParentWindow(WebDriver driver,String mainWindowHandle)
	{
		Set<String> window = driver.getWindowHandles();
		//System.out.println(window.size());
		if(window.size() > 0)
        {
            Iterator<String> iterator= window.iterator();
            while(iterator.hasNext())
            {
                String popupHandle=iterator.next().toString();
                if(!popupHandle.contains(mainWindowHandle))
                {
                		driver.close();
                }
     
                }
            driver.switchTo().window(mainWindowHandle);
            }
		}
	
	public  void switchToChild(WebDriver driver,String mainWindowHandle) throws InterruptedException
	{
		Thread.sleep(5000);
		Set<String> window = driver.getWindowHandles();
		//System.out.println(window.size());
		if(window.size() > 0)
        {
            Iterator<String> iterator= window.iterator();
            while(iterator.hasNext())
            {
                String popupHandle=iterator.next().toString();
                if(!popupHandle.contains(mainWindowHandle))
                {
                	driver.switchTo().window(popupHandle);
                	driver.manage().window().maximize();
                }
      
                }
            }
		}
	public  void switchToFrame(WebDriver driver,WebElement element)  
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
					
	}
	
	public  void switchTodefaultContent(WebDriver driver) throws InterruptedException  
	{
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
					
	}
	
	public   void dragAndDrop(WebElement source,WebElement destination,WebDriver driver) throws InterruptedException
	{		
		/*
		 * Actions action = new Actions(driver);
		 * 
		 * action.dragAndDrop(source, destination).build().perform();
		 */
		
		int x = destination.getLocation().x;
        int y = destination.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(source)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(source)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(destination)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
	
	}

	

}
