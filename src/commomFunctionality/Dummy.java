package commomFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Dummy 
{
	WebDriver driver;
	public void addCustomer() throws InterruptedException
	{
		Thread.sleep(3000);
		//Click on customers
		driver.findElement(By.id("mi_a_customers")).click();
		
		//Click on Add 
		driver.findElement(By.xpath("//a[@class='btn btn-default ewAddEdit ewAdd btn-sm']")).click();
		
		//Enter Customer name
		driver.findElement(By.xpath("//*[@id='x_Customer_Name']")).sendKeys("BnPrasanth");
		
		//Enter Address
		driver.findElement(By.xpath("//*[@id='x_Address']")).sendKeys("Hyderabad");
		
		//Enter city
		driver.findElement(By.xpath("//*[@id='x_City']")).sendKeys("Hyderabad");
		
		//Enter Country
		driver.findElement(By.xpath("//*[@id='x_Country']")).sendKeys("India");
		
		//Enter Contact_Person
		driver.findElement(By.xpath("//*[@id='x_Contact_Person']")).sendKeys("ABC");
		
		//Enter Phone_Number
		driver.findElement(By.xpath("//*[@id='x_Phone_Number']")).sendKeys("1234567891");
		
		//Enter Email
		driver.findElement(By.xpath("//*[@id='x__Email']")).sendKeys("abc@gmail.com");
		
		//Enter x_Mobile_Number
		driver.findElement(By.xpath("//*[@id='x_Mobile_Number']")).sendKeys("1156565666");
		
		//Enter Notes
		driver.findElement(By.xpath("//*[@id='x_Notes']")).sendKeys("NA");
		
		
		driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
		
		driver.switchTo().alert().accept();
		
		
		
				
		
	}

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		ERP_Functions e=new ERP_Functions();
		e.launchApp("http://webapp.qedge.com/login.php");
		e.logIn("admin","master");
		e.addSupplier("BNPrasanth", "Hyderabad", "Hyderabad", "INDIA", "ABC", "01236364", "abc@gmail.com", "321655", "Testing");
		
		
		
		
		

	}

}
