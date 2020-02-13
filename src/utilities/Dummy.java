package utilities;

import java.io.IOException;

public class Dummy
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		ExcelFileUtil excel=new ExcelFileUtil();
		
		int rowCount=excel.rowCount("Supplier");
		
		System.out.println(rowCount);
		
		int colCount=excel.colCount("Supplier", 1);
		
		System.out.println(colCount);
		
		
		Object data=excel.getData("Supplier", 2, 4);
		System.out.println(data);
		
		
		excel.setData("Supplier", 1, 1, "pass");
		
		
		
		
		
		
//		excel.getData("Supplier", 2, 3);
//		
//		excel.setData("Supplier", 3, 4, "Pass");
		
		

	}

}
