package generic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomData {
	
			@DataProvider(name="logintestdata")
			public Object[][] testData()
			{
				Object [][]data={{"Admin","admin123"},{"Ravi","test123"},{"Sara","test123"},{"Admin","admin123"}};
				return data;
			}
			
			  XSSFWorkbook wb;
			  
			@DataProvider(name="excelfile")
			public Object[][] fileData()
			{
				File f1=new File(System.getProperty("user.dir")+"//TestData//Data.xlsx");
				  FileInputStream fs;
				  Object data[][]=null;
				try {
					fs = new FileInputStream(f1);
					
					 //wb-->sheet-->row--->cell--->value
					 wb=new XSSFWorkbook(fs);
					  
					 XSSFSheet sheet1= wb.getSheet("userdata");
					 
					 //number of rows from the file
					 int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
					 System.out.println("Total Rows are: "+rows);//5
					 
					 //number of columns from the file
					 int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
					 System.out.println("Number of cells are: "+cells);//2
					 
					 //declare Storage as Array of same size like file- to store file data
					 data=new Object[rows-1][cells];//reading only 4 rows
					 
					  
					 //iterate array and read data from file and store it into array
					 
					 for(int r=1;r<rows;r++)//rows skip the heading starts iteration from 1st row
					 {
						 
						 for(int c=0;c<cells;c++)
						 {
							 
							 data[r-1][c]=wb.getSheet("userdata").getRow(r).getCell(c).getStringCellValue();
							
						 }
						 
					 }
					
						
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				return data;
				 
			}

}
