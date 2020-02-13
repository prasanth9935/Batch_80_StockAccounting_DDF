package commomFunctionality;

import java.io.IOException;

import utilities.ExcelFileUtil;

public class DriverScript 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		ExcelFileUtil excel=new ExcelFileUtil();
		
		int rowCount=excel.rowCount("Supplier");
		
		ERP_Functions ef=new ERP_Functions();
		
		for (int i = 1; i < rowCount; i++) 
		{
			String Supplier_Name=excel.getData("Supplier", i, 0);
			String Address= excel.getData("Supplier", i, 1);
			String City=excel.getData("Supplier", i, 2);
			String Country=excel.getData("Supplier", i, 3);
			String Contact_Person= excel.getData("Supplier", i, 4);
			String Phone_Number= excel.getData("Supplier", i, 5);
			String Email=excel.getData("Supplier", i, 6);
			String Mobile_Number= excel.getData("Supplier", i, 7);
			String Notes=excel.getData("Supplier", i, 8);
			
			ef.launchApp("http://webapp.qedge.com/login.php");
			ef.logIn("admin","master");
			
			String result=ef.addSupplier(Supplier_Name, Address, City, Country, Contact_Person, Phone_Number, Email, Mobile_Number, Notes);
			ef.close();
			excel.setData("Supplier", i, 9, result);			
		}
	}

}
