package common;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Configuration.Config;
import Locators.Objectlocators;

public class CommonMethod {
	static WebDriver driver;
	 public static void login (String username , String password) throws IOException {
		 System.setProperty("webdriver.chrome.driver", Config.driverPath);
	    	driver = new ChromeDriver();
	    	String url = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" , "0");
	        driver.get(url);
	        driver.manage().window().maximize();
	        System.out.println(username);
	        driver.findElement(By.name(Objectlocators.UserName)).sendKeys(username);
		    driver.findElement(By.name(Objectlocators.Password)).sendKeys(password);
		    
		    driver.findElement(By.xpath(Objectlocators.loginBtn)).click();
}
	 public static String getExcelData(String filepath, String SheetName,String Row, String Column) throws IOException {
            int Rnumber = Integer.parseInt(Row);
			int Cnumber = Integer.parseInt(Column);
			XSSFWorkbook wb = new XSSFWorkbook(filepath);
			XSSFSheet sheet = wb.getSheet(SheetName);
			Row row = sheet.getRow(Rnumber);
			Cell cell = row.getCell(Cnumber);
			String value = cell.getStringCellValue();
			return value;
}
		
		public static String getRowCount(String fileLocation,String SheetName) throws IOException {
			XSSFWorkbook wb = new XSSFWorkbook(fileLocation);
			XSSFSheet sheet= wb.getSheet(SheetName);
			int row =sheet.getPhysicalNumberOfRows();
			String rowCount =Integer.toString(row);
			System.out.println("////////////////////////////////////" + rowCount + "/////////////////////////////");
			return rowCount;	
		
		}

}
