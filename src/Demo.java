import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;



public class Demo {
	public static String Title="Guru99 Bank Manager HomePage";
	public static String name,email,currentAddress,permanentAddress;
	public static String customerID;
	public static String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Brinjal","Pumpkin","Walnuts"}; 
	public static int j=0,count=0,a=0,b=0;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static int explicitWaitTime=8;
	
	public static void main(String[] args) throws Exception 
	{
		
		// TODO Auto-generated method stub
		
		
		
		/*Object creation Syntax: ClassName ObjName= new ClassName();*/
		
		/*Note: All the driver classes are available in Webdriver interface, 
		 * so the the object has to be created with respect to Interface */
		
		//Step 1: Invoke Chrome driver 
		//(Note: webdriver.chrome.driver is a system property to specify Chrome driver location)
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome Driver\\chromedriver.exe");
		
		//Step 2: Create driver object for Chrome browser
		ChromeOptions options = new ChromeOptions();
		//DesiredCapabilities dc = new DesiredCapabilities ();
		
		
		
		//options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		options.addArguments("disable-infobars");
		
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);
		
		//options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");				
		 
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver,8);
		 
		//Launch Chrome
		//driver.get("https://demoqa.com/frames");
		driver.get("https://www.cleartrip.com");
		
		driver.findElement(By.cssSelector("div[class='flex flex-middle p-relative homeCalender']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.DayPicker-Day.DayPicker-Day--start.DayPicker-Day--selected.DayPicker-Day--today")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[class='td-none hover:td-underline px-4 mt-1 weak']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder='Airline name']")).sendKeys("Spicejet");
		//driver.findElement(By.className("col flex flex-middle")).click();
		
		
		//Maximize the browser
		//driver.manage().window().maximize();
		
	/*	//Get the total number of Link available in the page
		var links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		WebElement footer = driver.findElement(By.xpath("//table[@class='gf-t']//td"));
		var items = footer.findElements(By.tagName("a"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		String click = Keys.chord(Keys.CONTROL,Keys.ENTER);
		for(int i=1;i<items.size();i++) 
		{
			footer.findElements(By.tagName("a")).get(i).sendKeys(click);
		}
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iter= window.iterator();
		
		while(iter.hasNext()) 
		{
			driver.switchTo().window(iter.next());
			
			System.out.println(driver.getTitle());
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		
		js.executeScript("document.querySelector(\"div.tableFixHead\").scroll(0,500)");
		
		var c4 = driver.findElements(By.cssSelector("div.tableFixHead td:nth-child(4)"));
		
		for(int i=0;i<c4.size();i++) 
		{
			System.out.println(c4.get(i).getText());
			b+=Integer.parseInt(c4.get(i).getText());
			
		}
		System.out.println(b);
		
		String finalValue = driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim();
		
		a= Integer.parseInt(finalValue);
		
		if(a==b) 
		{
			System.out.println("Total amount collected is: "+b+" and it is equal !!!!");
		}
		else 
		{
			System.out.println("Total amount collected is: "+b+" and it is not equal....");
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("F:\\Screenshots\\screenshot.png"));
		
		
		
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		List<WebElement> tableList = driver.findElements(By.xpath("//td[1]"));
		
		List<String> originalList = tableList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String> webTableList = tableList.stream().filter(s->s.getText().contains("Beans")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
		
		webTableList.forEach(s->System.out.println(s));
		
		List<WebElement> rowList ;
		List<String> rowListValues; 
		do 
		{
			rowList = driver.findElements(By.xpath("//td[1]"));
			rowListValues = rowList.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
			
			if(rowListValues.size()<1) 
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
		}while(rowListValues.size()<1); 
		
		
		rowListValues.forEach(s->System.out.println(s));*/							
		
		//ClickElement(By.id("tabButton"));
		
		//var item = GetText(By.id("sampleHeading"));
		//System.out.println(item);
		
		//HandleAlert(By.id("alertButton"));
		
		//HandleAlert(By.id("timerAlertButton"),explicitWaitTime);
		
		//HandleAlert(By.id("confirmButton"),explicitWaitTime,0);
		
		//HandleAlert(By.id("promtButton"),explicitWaitTime,"Alert is being tested",1);
		
		/*driver.switchTo().frame("frame1");
	
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		//driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(By.cssSelector("div.main-header")).getText());*/
	}
	
	public static void ClickElement(By locator) throws Exception 
	{
		Set<String> windows=null;
		Iterator<String> iterator=null;
		WebElement element=null;
		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		try 
		{
			element = driver.findElement(locator);	
		}
		catch(Exception e) 
		{
			System.out.println("Element not found yet");
		}
		
		if(element==null) 
		{
			windows = driver.getWindowHandles();
			iterator = windows.iterator();
			while(iterator.hasNext()) 
			{				
				driver.switchTo().window(iterator.next());
				try 
				{
					element = driver.findElement(locator);	
				}
				catch(Exception e) 
				{
					System.out.println("Element not found yet");
				}
				
				if(element!=null) 
				{
					driver.findElement(locator).click();
				}
			}
			if(element==null) 
			{
				throw new Exception("Element cannot be located");
			}
		}
		
		if(element!=null) 
		driver.findElement(locator).click();
	}
	
	public static String GetText(By locator) throws Exception 
	{
		Set<String> windows=null;
		Iterator<String> iterator=null;
		WebElement element=null;
		String value=null;
		
		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		try 
		{
			element = driver.findElement(locator);	
		}
		catch(Exception e) 
		{
			System.out.println("Element not found yet");
		}
		
		if(element==null) 
		{
			windows = driver.getWindowHandles();
			iterator = windows.iterator();
			while(iterator.hasNext()) 
			{				
				driver.switchTo().window(iterator.next());
				try 
				{
					element = driver.findElement(locator);	
				}
				catch(Exception e) 
				{
					System.out.println("Element not found yet");
				}
				
				if(element!=null) 
				{
					value = driver.findElement(locator).getText();
				}
			}
			if(element==null) 
			{
				throw new Exception("Element cannot be located");
			}
		}
		
		if(element!=null) 		
			value = driver.findElement(locator).getText();
		return value;
		
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String value;
		value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return value;
	} 
	
	public static void HandleAlert(By locator) throws Exception {
		// TODO Auto-generated method stub		
				
		ClickElement(locator);
		driver.switchTo().alert().accept();
		System.out.println("Alert Handled");
				
	} 
	
	public static void HandleAlert(By locator, int wait) throws Exception {
		// TODO Auto-generated method stub
		WebDriverWait hold = new WebDriverWait(driver,wait);
		ClickElement(locator);
		
		if(hold.until(ExpectedConditions.alertIsPresent())!=null)
			{driver.switchTo().alert().accept();System.out.println("Timer Alert Handled");}
		else		
			throw new Exception("Alert did not pop-up after "+wait+" seconds");				
		 						 				
	}
	
	public static void HandleAlert(By locator, int wait, int action) throws Exception {
		// TODO Auto-generated method stub
		WebDriverWait hold = new WebDriverWait(driver,wait);
		ClickElement(locator);
		Alert alert;
		if((alert=hold.until(ExpectedConditions.alertIsPresent()))!=null)
			if(action==1)
				{alert.accept();System.out.println("Alert Handled-Accept");}
			if(action==0)
				{alert.dismiss();System.out.println("Alert Handled-Dismiss");}
		
		else
			throw new Exception("Alert did not pop-up after "+wait+" seconds");					
		 						 				
	} 
	
	public static void HandleAlert(By locator, int wait, String value, int action) throws Exception {
		// TODO Auto-generated method stub
		WebDriverWait hold = new WebDriverWait(driver,wait);
		ClickElement(locator);
		Alert alert;
		if((alert=hold.until(ExpectedConditions.alertIsPresent()))!=null)
			if(action==1) 
			{
				alert.sendKeys(value);
				alert.accept();System.out.println("Alert Handled-Accept");
			}
				
			if(action==0)
				{alert.dismiss();System.out.println("Alert Handled-Accept");}
		
		else
			throw new Exception("Alert did not pop-up after "+wait+" seconds");				
		 						 				
	} 
}