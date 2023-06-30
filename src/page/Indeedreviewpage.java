package page;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Indeedreviewpage {
	WebDriver driver;
	By alllinks=By.tagName("a");
	By companynamefield=By.xpath("//*[@id=\"ifl-InputFormField-:R6l:\"]");
	
	By findcompanybutton=By.xpath("//*[@id=\"main\"]/div/div[1]/form/div/div[2]/button");
	
	public Indeedreviewpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void pageTitle()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle="Find The Best Companies to Work For | Indeed.com";
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
		String actualtext=driver.findElement(findcompanybutton).getText();
		String expectedtext="Find Companies";
		Assert.assertEquals(actualtext, expectedtext);
		System.out.println("button text verified");
	}
	public void buttonEnabled()
	{
		boolean actual=driver.findElement(findcompanybutton).isEnabled();
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		System.out.println("Find companies button is enabled");
	}
	public void findCompany(String company)
	{
		driver.findElement(findcompanybutton).click();
		driver.findElement(companynamefield).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		driver.findElement(companynamefield).sendKeys(company);
		driver.findElement(findcompanybutton).click();
		
	}

}
