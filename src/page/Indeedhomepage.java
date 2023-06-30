package page;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Indeedhomepage {
	WebDriver driver;
	By alllinks=By.tagName("a");
	By whatfield=By.xpath("//*[@id=\"text-input-what\"]");
	By wherefield=By.xpath("//*[@id=\"text-input-where\"]");
	By findjobsbutton=By.xpath("//*[@id=\"jobsearch\"]/button");
	By indeedlogo=By.xpath("//*[@id=\"indeed-globalnav-logo\"]");
	
	public Indeedhomepage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void logoDisplay()
	{
		boolean actual=driver.findElement(indeedlogo).isDisplayed();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("logo is displayed");
	}
	public void title()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle="Job Search India | Indeed";
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Title verified");
	}
	public void linkCount()
	{
		List<WebElement> links=driver.findElements(alllinks);
		System.out.println("total links="+links.size());
	}
	public void linkDetails()
	{
		List<WebElement> links=driver.findElements(alllinks);
		for(WebElement link:links)
		{
			System.out.println(link.getText()+"----"+link.getAttribute("href"));
		}
	}
	public void linkResponsecode() throws Exception
	{
		List<WebElement> links=driver.findElements(alllinks);
		for(WebElement l:links)
		{
			String link=l.getAttribute("href");
			URL u=new URL(link);
			HttpURLConnection con=(HttpURLConnection)u.openConnection();
			con.connect();
			int responsecode=con.getResponseCode();
			System.out.println(responsecode+"---"+link);
			
		}
	}
	public void buttonText()
	{
		String actualtext=driver.findElement(findjobsbutton).getText();
		String expectedtext="Find jobs";
		Assert.assertEquals(actualtext, expectedtext);
		System.out.println("button text verified");
	}
	public void buttonenabled()
	{
		boolean actual=driver.findElement(findjobsbutton).isEnabled();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("find jobs button is enabled");
	}
	
	public void findJobs(String what,String where)
	{
		
		driver.findElement(whatfield).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		driver.findElement(whatfield).sendKeys(what);
		driver.findElement(wherefield).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		driver.findElement(wherefield).sendKeys(where);
		driver.findElement(findjobsbutton).click();
		if(isAlertPresent())
		{
		Alert a=driver.switchTo().alert();
		a.dismiss();
		}
	
	}
	
	public boolean isAlertPresent() {
	    try{
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	       wait.until(ExpectedConditions.alertIsPresent());
	       return true;
	    }
	    catch (NoAlertPresentException noAlert) {
	      return false;
	    }
	    catch (TimeoutException timeOutEx){
	      return false;
	    }
	}

}
