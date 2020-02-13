package commomFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class ERP_Functions 
{
	WebDriver driver;
	String result;
	public String launchApp(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		if (driver.findElement(By.id("btnsubmit")).isDisplayed())
		{
			result="Pass";
		}
		else
		{
			result="Fail";
		}
		
		return result;
	}
	
	public void logIn(String username,String password) throws InterruptedException
	{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("btnsubmit")).click();	
		
		String expTitle="Dashboard « Stock Accounting";
		String actTitle=driver.getTitle();
		
		if (expTitle.equalsIgnoreCase(actTitle)) 
		{
			System.out.println("Title Matched");
		}
		else
		{
			System.out.println("Title not Matched");
		}		
	}
	public void close()
	{
		driver.close();
	}
	
	
	public String addSupplier(String Supplier_Name,String Address,String City,String Country,String Contact_Person,String Phone_Number,String Email,String Mobile_Number,String Notes) throws InterruptedException
	{
		//Click on Suppliers 
		driver.findElement(By.linkText("Suppliers")).click();
		
		//Click on add button
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		
		//Get Supplier number
		String expdata=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
			
		//Enter Supplier_Name
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(Supplier_Name);
		
		//Enter Address
		driver.findElement(By.id("x_Address")).sendKeys(Address);
		
		//Enter City
		driver.findElement(By.id("x_City")).sendKeys(City);
				
		//Enter Country
		driver.findElement(By.id("x_Country")).sendKeys(Country);
		
		//Enter Contact_Person
		driver.findElement(By.id("x_Contact_Person")).sendKeys(Contact_Person);
		
		//Enter Phone_Number
		driver.findElement(By.id("x_Phone_Number")).sendKeys(Phone_Number);
				
        //Enter Email
		driver.findElement(By.id("x__Email")).sendKeys(Email);
				
	    //Enter Mobile_Number
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(Mobile_Number);
				
		//Enter Notes
		driver.findElement(By.id("x_Notes")).sendKeys(Notes);
		
		//Click on Add
		driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='OK!']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()='OK'])[6]")).click();
		
		
		if (driver.findElement(By.id("psearch")).isDisplayed()) 
		{
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();
		}
		else
		{
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button/span")).click();
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();
		}
		
        String actdata=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		
		
		String res;
		if(expdata.equalsIgnoreCase(actdata)){
			res="Pass";
		}else{
			res="Fail";
		}
		
		return res;
		
	}
	
	
}
