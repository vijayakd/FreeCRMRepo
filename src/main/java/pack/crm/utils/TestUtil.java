package pack.crm.utils;

import java.io.File;
//import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pack.crm.base.TestBase;

public class TestUtil extends TestBase{

		public static long 	page_load_timeout=40;
		public static long implicit_wait=50;
		
		
		
		public void switchtoFrame() {
		driver.switchTo().frame("mainpanel");

		}
		
	public static void takeScreenShot() throws IOException {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\vijay\\eclipse-workspace\\FreeCRMTest\\failedtcscreenshots"));
			
			
		}

		
public  static Object[][] getTestdata(String sheetname){
	 int j=0;

		// int col=0;
		   XSSFWorkbook excel=null;
		  // int rowcnt;
	 FileInputStream fis=null;
	        try {
				fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\FreeCRMTestData.xlsx");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	        try {
				excel = new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
	       XSSFSheet sheet= excel.getSheet(sheetname);
	       
	       Object[][] objdata= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 
		 
for(int i=0;i<sheet.getLastRowNum();i++) {
	for(j=0;j<sheet.getRow(0).getLastCellNum();j++) {
	      
		objdata[i][j]=sheet.getRow(i+1).getCell(j).toString();
	}}

	return objdata;
	
	
}













}
