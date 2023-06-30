package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Indeedhomepage;
import utilities.Indeedutilities;

public class Indeedhometest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://in.indeed.com/?from=gnav-homepage");
	}
	@Test(priority=1)
	public void validateLogo()
	{
		Indeedhomepage ob=new Indeedhomepage(driver);
		ob.logoDisplay();
		
	}
	@Test(priority=2)
	public void validateTitle()
	{
		Indeedhomepage ob=new Indeedhomepage(driver);
		ob.title();
		
	}
	
	@Test(priority=3)
	public void validateLinks() throws Exception
	{
		Indeedhomepage ob=new Indeedhomepage(driver);
		ob.linkCount();
		ob.linkDetails();
		ob.linkResponsecode();
		System.out.println("link details are showing");
		
	}
	@Test(priority=4)
	public void validateButton()
	{
		Indeedhomepage ob=new Indeedhomepage(driver);
		ob.buttonText();
	    ob.buttonenabled();
		
	}
	
	@Test(priority=5)
	public void validateFindJobs() throws Exception
	{
		Indeedhomepage ob=new Indeedhomepage(driver);
	    
	    String xl="C:\\Users\\91810\\OneDrive\\Documents\\ANUSHA\\indeed.xlsx";
	    String sheet="findjobs";
	    int rowcount=Indeedutilities.getRowCount(xl,sheet);
	    for(int i=1;i<=rowcount;i++)
	    {
	    	String what=Indeedutilities.getCellValue(xl,sheet,i,0);
	    	String where=Indeedutilities.getCellValue(xl,sheet,i,1);
	    	ob.findJobs(what, where);
	    }
	    System.out.println("jobs are displaying");
	}

}
