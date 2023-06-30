package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Indeedreviewpage;
import utilities.Indeedutilities;

public class Indeedreviewtest {
	
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://in.indeed.com/companies?from=gnav-homepage");
		
	}
	@Test(priority=1)
	public void validateTitle()
	{
		Indeedreviewpage ob=new Indeedreviewpage(driver);
		ob.pageTitle();
		
	}
	@Test(priority=2)
	public void validateLinks() throws Exception
	{
		Indeedreviewpage ob=new Indeedreviewpage(driver);
		ob.linkCount();
		ob.linkDetails();
		ob.linkResponsecode();
		System.out.println("link details are showing");
	}
	@Test(priority=3)
	public void validateButton()
	{
		Indeedreviewpage ob=new Indeedreviewpage(driver);
		ob.buttonText();
		ob.buttonEnabled();
		
	}
	
	@Test(priority=4)
	public void validateFindCompany() throws Exception
	{
		Indeedreviewpage ob=new Indeedreviewpage(driver);
		String xl="C:\\Users\\91810\\OneDrive\\Documents\\ANUSHA\\indeed.xlsx";
	    String sheet="company";
	    int rowcount=Indeedutilities.getRowCount(xl,sheet);
	    for(int i=1;i<=rowcount;i++)
	    {
	    	String company=Indeedutilities.getCellValue(xl,sheet,i,0);
	    	ob.findCompany(company);
	    }
	    System.out.println("companies are showing");
	
	}
	

}
