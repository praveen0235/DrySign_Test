package framework;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	static int timeinSec=30;
	
	
	public  void setImplicitWait(int time,WebDriver driver){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
		
		  public  void waitUntilElementLocated(int time,WebElement element,WebDriver driver){
			 
					WebDriverWait wait=new WebDriverWait(driver,time);
					wait.until(ExpectedConditions.visibilityOf(element));
					
			}
		 
		  public  void waitUntilElementToClick(int time,WebElement element,WebDriver driver){
			
		  WebDriverWait wait=new WebDriverWait(driver,time);
		 
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		    
				  }
		  
		  public  void waitUntilElementsToClick(int time,List<WebElement> element,WebDriver driver){
				
			  WebDriverWait wait=new WebDriverWait(driver,time);
			 
			  wait.until(ExpectedConditions.visibilityOfAllElements(element));
					 
			    
					  }
		 
	 
	
	public  synchronized Object execJavascript(WebDriver driver,String script, Object... args) {
        JavascriptExecutor scriptExe = ((JavascriptExecutor)driver);
        return scriptExe.executeScript(script, args);
    }

    public  synchronized Object tryJavascript(WebDriver driver,String script, Object... args) {
        try {
            return execJavascript(driver,script, args);
        } catch (Exception ignore) {
            return "";
        }
    }

    public  boolean isPageLoaded(WebDriver driver) {
        String state = (String) tryJavascript(driver,"return document.readyState;");
        return state.matches("complete|loaded|interactive");
    }

    public  boolean isJQueryDone(WebDriver driver) {
        Object jsResponse = tryJavascript(driver,"return jQuery.active;");
        if (jsResponse instanceof Long) {
            return ((Long) jsResponse) == 0;
        } else if (jsResponse instanceof String) {
            String response = (String) jsResponse;
            return (response.startsWith("{\"hCode\"") || response.isEmpty());
        } else {
            return true;
        }
    }

    public  boolean isAngularDone(WebDriver driver) {
        Object jsResponse = tryJavascript(driver,"return window.getAllAngularTestabilities().filter(x=>!x.isStable()).length;", null, null);
        if (jsResponse instanceof Long) {
            return ((Long) jsResponse) == 0;
        } else if (jsResponse instanceof String) {
            String response = (String) jsResponse;
            return response.isEmpty();
        } else {
            return true;
        }
    }
    
    public  void waitUntil( BooleanSupplier condition, int seconds,WebDriver driver) {
        new WebDriverWait(driver, seconds).until((WebDriver Driver) -> condition.getAsBoolean());
    }

    public  void waitUntil(BooleanSupplier condition ,WebDriver driver) {
        waitUntil(condition, timeinSec, driver);
    }

}
