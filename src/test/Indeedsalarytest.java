package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Indeedsalarypage;
import utilities.Indeedutilities;

public class Indeedsalarytest {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://in.indeed.com/career/salaries?from=gnav-homepage");
	}
	
	@Test(priority=1)
	public void validateTitle()
	{
		Indeedsalarypage obb=new Indeedsalarypage(driver);
		obb.pageTitle();
	}
	@Test(priority=2)
	public void validateLinks()  
	{
		Indeedsalarypage obb=new Indeedsalarypage(driver);
		obb.linkCount();
		obb.linkDetails();
		try {
			obb.linkResponsecode();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("link details are showing");
	}
	
	
	@Test(priority=3)
	public void validateDropdown()
	{
		Indeedsalarypage obb=new Indeedsalarypage(driver);
		for(int i=1;i<=23;i++)
		{
			obb.chooseIndustry(i);
		}
		System.out.println("industry can be selected from dropdown");
		
	}
	@Test(priority=4)
	public void validateButton()
	{
		Indeedsalarypage obb=new Indeedsalarypage(driver);
		obb.buttonText();
		obb.buttonenabled();
	}
	
	
	@Test(priority=5)
	public void validateSalarySearch() throws Exception
	{
		Indeedsalarypage obb=new Indeedsalarypage(driver);
		 String xl="C:\\Users\\91810\\OneDrive\\Documents\\ANUSHA\\indeed.xlsx";
		    String sheet="searchsalary";
		    int rowcount=Indeedutilities.getRowCount(xl,sheet);
		    for(int i=1;i<=rowcount;i++)
		    {
		    	String what=Indeedutilities.getCellValue(xl,sheet,i,0);
		    	String where=Indeedutilities.getCellValue(xl,sheet,i,1);
		    	obb.salarySearch(what, where);
		    }
		    System.out.println("salary is displaying");
	
	
	}
	

}
