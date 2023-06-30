package page;


import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Indeedsalarypage {
	WebDriver driver;
	By alllinks=By.tagName("a");
	By whatjobfield=By.xpath("//*[@id=\"input-title-autocomplete\"]");
	By wherejobfield=By.xpath("//input[@aria-label='location']");
	By searchbutton=By.xpath("//*[@id=\"what-where-search-btn\"]");
	By dropdownbutton=By.xpath("/html/body/div/div/main/div/div/div[3]/div/button");
	By dropdownfield=By.xpath("//*[@id=\"downshift-0-menu\"]/div");
	
	public Indeedsalarypage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void pageTitle()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle="Salaries | Indeed";
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
		String actualtext=driver.findElement(searchbutton).getText();
		String expectedtext="Search";
		Assert.assertEquals(actualtext, expectedtext);
		System.out.println("button text verified");
	}
	public void buttonenabled()
	{
		boolean actual=driver.findElement(searchbutton).isEnabled();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("search button is enabled");
	}
	public void chooseIndustry(int i)
	{
		driver.findElement(dropdownbutton).click();
		List<WebElement>li=driver.findElements(dropdownfield);
		li.get(i).click();
		
		
	}
	
	public void salarySearch(String whatjob,String wherejob )
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(whatjobfield));
		driver.findElement(whatjobfield).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
		driver.findElement(whatjobfield).sendKeys(whatjob);
		driver.findElement(wherejobfield).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
		driver.findElement(wherejobfield).sendKeys(wherejob);
		driver.findElement(searchbutton).click();
		driver.navigate().refresh();
		
	}

}
