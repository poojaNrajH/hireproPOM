package Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
//	public static final String username = "sangeetha@promantus.com";
//	public static final String password = "hireprous@123";
//	public static final String url= "http://3.82.142.185:9393/";
	public static final String driverPath= "./Drivers/chromedriver.exe";
	public static final String excelTestData= "./TestData/InputData.xlsx";
	
	public static Properties prop;
	public static String excelTestData() throws IOException {

	    prop= new Properties();
	    FileInputStream file = new FileInputStream(System.getProperty("user.dir")
	            + "/src/test/java/Configuration/environment.properties");
	    prop.load(file);
	    String envVar = prop.getProperty("ENV");
	    System.out.println(envVar);
	    String excelTestData ="./TestData/" + envVar + ".xlsx";
	    return excelTestData ;
	}

	}
	
	


