package com.app.actTime.Util;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility implements WebDriver {
	public WebDriver driver;
	WebElement element;
	
	public Utility(WebDriver driver) {
		this.driver=driver;
	}
	// This method's will handle sync issue - It will wait for webelement and highlight webelement
	  public static WebElement waitForWebElement(WebDriver driver, By byLocator) {
		  WebDriverWait wait = new WebDriverWait(driver, 15); 
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator)); 
		  highLightElement(driver, element);
		  return element; 
	  }

	  public static WebElement waitForWebElement(WebDriver driver, By byLocator,int time) { 
		  WebDriverWait wait = new WebDriverWait(driver, time); 
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		  highLightElement(driver, element);
		  return element; 
	  }

	  public static WebElement waitForWebElement(WebDriver driver, WebElement webElement,int time) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			highLightElement(driver, element);
			return element;
	  }
	  public static Boolean waitForWebElement(WebDriver driver, long time, String title) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			Boolean element = wait.until(ExpectedConditions.titleContains(title));
		//	highLightElement(driver, element);
			return element;
	  }

	  public static void highLightElement(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;  //downward casting
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {

			System.out.println(e.getMessage());
			}

			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	  	}
	
	  public static  List<WebElement> waitForMultipleWebElement(WebDriver driver, By byLocator) {
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  List<WebElement> allElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
		  return allElements;
	  }
	  public static  List<WebElement> waitForMultipleWebElement(WebDriver driver, By byLocator,int time) {
		  WebDriverWait wait = new WebDriverWait(driver, time);
		  List<WebElement> allElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
		  return allElements;
	  }
	
	  public void customListBoxGetText(By locatorName, String exptecteValue) {
			 
			List<WebElement> elements = driver.findElements(locatorName);
		//	int count = elements.size();
		//	System.out.println("No of values present in the dropdownList: "+count);
			for(WebElement option: elements){	
				String text = option.getText();
				if(text.equalsIgnoreCase(exptecteValue)) {
					 option.click();
					 break;
				 }
			}
			
	 }
		public static void selectValueFromCalendar(List<WebElement> elements,String values) {
			
			for(WebElement ele:elements)
			{
				String data=ele.getText();
				if(data.equalsIgnoreCase(values))
				{
					ele.click();
					break;
				}
			}	
		}
		
		public static void acceptAlert(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		}
		
		public static void dismissAlert(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		}
		
		public static void verifyAlertText(WebDriver driver,String expectedText)
		{
			WebDriverWait wait=new WebDriverWait(driver, 15);
			String alert_text_actual=wait.until(ExpectedConditions.alertIsPresent()).getText();
			Assert.assertEquals(alert_text_actual, expectedText);
		}
		
		public static void verifyAlertPartially(WebDriver driver,String expectedText)
		{
			WebDriverWait wait=new WebDriverWait(driver, 15);
			String alert_text_actual=wait.until(ExpectedConditions.alertIsPresent()).getText();
			Assert.assertTrue(alert_text_actual.contains(expectedText));
		}
		public static void verifyTitle(WebDriver driver,String title)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
		}
		
		public static void verifyContainsTitle(WebDriver driver,String title)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			Assert.assertTrue(wait.until(ExpectedConditions.titleContains(title)));
		}
		
		public static void verifyURL(WebDriver driver,String url)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(url)));
		}
		
		public static void verifyURLContains(WebDriver driver,String url)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
		}
		public static void threadsleep(int time)
		{
			try 
			{
				Thread.sleep(time*1000);
			} catch (InterruptedException e) 
			{
				
			}
		}
	

	@Override
	public void get(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

}
