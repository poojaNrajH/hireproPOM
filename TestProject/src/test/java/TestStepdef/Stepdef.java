package TestStepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Configuration.Config;
import Locators.Objectlocators;
import Utils.ExcelUtils;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import common.CommonMethod;
@SuppressWarnings("deprecation")
public class Stepdef {
	static WebDriver driver;
	int row;
	XSSFSheet sheet;
	
	
	@After
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}
//	
    @Given("User navigate to Hireprous page")
	public void user_navigate_to_hireprous_page() throws IOException {
    	System.setProperty("webdriver.chrome.driver", Config.driverPath);
    	driver = new ChromeDriver();
    	String url = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" , "0");
        driver.get(url);
        driver.manage().window().maximize();
    
	}

	@When("user verifies Hireprous logo")
	public void user_verifies_hireprous_logo() throws InterruptedException {
		Boolean Display = driver.findElement(By.xpath(Objectlocators.logo)).isDisplayed();
		System.out.println("Element displayed is :"+Display);
		Thread.sleep(2000);
	}

	@And("User verifies login page fields")
	public void user_verifies_login_page_fields() {
		 driver.findElement(By.name(Objectlocators.UserName)).isEnabled();
		 driver.findElement(By.name(Objectlocators.Password)).isEnabled();
     	 driver.findElement(By.xpath(Objectlocators.loginBtn)).isEnabled();
	}
	
//////////////////////Login to application with Invalid user credentials////////////////////////////////////
	@Given("User is on the Hireprous page")
	public void user_is_on_the_hireprous_page() throws InterruptedException {
		Boolean Display = driver.findElement(By.xpath(Objectlocators.logo)).isDisplayed();
		System.out.println("Element displayed is :"+Display);
		Thread.sleep(2000);
	}
	@When("User enters invalid username and password")
	public void user_enters_invalid_username_and_password() throws InterruptedException, IOException {
		int row = 1;
		String s = Integer.toString(row);
		Thread.sleep(1000);
		String username = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" , "1");
		String password = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" , "3");
		driver.findElement(By.name(Objectlocators.UserName)).sendKeys(username);
	    driver.findElement(By.name(Objectlocators.Password)).sendKeys(password);
	    
	}

	@And("User clicks on the Log IN button")
	public void user_clicks_on_the_log_in_button() throws InterruptedException {
		driver.findElement(By.xpath(Objectlocators.loginBtn)).click();
		Thread.sleep(1000);
		
	}

	@SuppressWarnings("deprecation")
	@Then("User verifes the error message for invalid credentials")
	public void user_verifes_the_error_message_for_invalid_credentials() {
		String exp = "User Name - is invalid.";
	      WebElement m = driver.findElement(By.xpath("//*[@class='alertify-notifier ajs-top ajs-right']"));
	      String act = m.getText();
	      System.out.println("Error message is: "+ act);
	      Assert.assertEquals(exp, act);
	      }
//////////////////////Login to application with Valid user credentials////////////////////////////////////

	@Given("User is on Hireprous login page")
	public void user_is_on_hireprous_login_page() throws InterruptedException {
		
		Boolean Display = driver.findElement(By.xpath(Objectlocators.logo)).isDisplayed();
		System.out.println("Element displayed is :"+Display);
		Thread.sleep(2000);
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() throws InterruptedException, IOException {
		Thread.sleep(3000);
		int row = 1;
		String s = Integer.toString(row);
		Thread.sleep(1000);
		driver.findElement(By.name(Objectlocators.UserName)).clear();
		driver.findElement(By.name(Objectlocators.Password)).clear();
		Thread.sleep(1000);
		
		String username = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" , "2");
		String password = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" ,  "3");
		driver.findElement(By.name(Objectlocators.UserName)).sendKeys(username);
	    driver.findElement(By.name(Objectlocators.Password)).sendKeys(password);
	    Thread.sleep(1000);

	}

	@And("User clicks on Log IN button")
	public void user_clicks_on_log_in_button() throws InterruptedException {
		Thread.sleep(2000);
		 driver.findElement(By.xpath(Objectlocators.loginBtn)).click();
		 Thread.sleep(2000);
	}
	@Then("User login must be successful")
	public void user_login_must_be_successful() throws InterruptedException {
		Boolean Display = driver.findElement(By.xpath(Objectlocators.dashboard)).isDisplayed();
		System.out.println("Element displayed is :"+Display);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='btn btn-xs pull-right']")).click();
	    driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/div/div/div/div[3]/ul/li[5]/a")).click();
	    Thread.sleep(4000);
	}

////////////////////////////////////////////jobRequest//////////////////////////////////////////////////

@Given("User navigate to the Dashboard page by logging in Hireprous page")
public void user_navigate_to_the_dashboard_page_by_logging_in_hireprous_page() throws InterruptedException, IOException {
	
	String username = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" , "2");
	String password = CommonMethod.getExcelData(Config.excelTestData(), "Login", "1" ,  "3");
	CommonMethod.login(username , password);
}

@When("User clicks on  Recruitment from top menu")
public void user_clicks_on_recruitment_from_top_menu() throws InterruptedException {
Thread.sleep(2000);
driver.findElement(By.xpath(Objectlocators.Recbtn)).click();
Thread.sleep(1000);

}

@And("User will be redirected to Recruitment process page")
public void user_will_be_redirected_to_recruitment_process_page() throws InterruptedException {
driver.findElement(By.xpath(Objectlocators.dashboard)).isEnabled();
Boolean Display = driver.findElement(By.xpath(Objectlocators.recprocess)).isDisplayed();
System.out.println("Element displayed is :"+Display);
Thread.sleep(2000);
}

@Then("User clicks on Job Request menu")
public void user_clicks_on_job_request_menu() throws InterruptedException {
Thread.sleep(2000);
driver.findElement(By.xpath(Objectlocators.jobrequest)).click();
Thread.sleep(1000);
}

@Then("User will be redirected to the JOb Request list page successfully")
public void user_will_be_redirected_to_the_j_ob_request_list_page_successfully() throws InterruptedException {
Boolean Display = driver.findElement(By.xpath(Objectlocators.jobrequeslist)).isDisplayed();
System.out.println("Element displayed is :"+Display);
Thread.sleep(2000);
}

@And("User verifies fields on the Job Request list page")
public void user_verifies_fields_on_the_job_request_list_page() throws InterruptedException {
driver.findElement(By.xpath(Objectlocators.jobrequessearch)).isEnabled();
driver.findElement(By.xpath(Objectlocators.newjobrequest)).isEnabled();
Thread.sleep(2000);
}

@Given("User is on Job Request page")
public void user_is_on_job_request_page() throws InterruptedException {
Boolean Display = driver.findElement(By.xpath(Objectlocators.jobrequeslist)).isDisplayed();
System.out.println("Element displayed is :"+Display);
Thread.sleep(2000);
}

@When("User clicks on New Job Request button")
public void user_clicks_on_new_job_request_button() throws InterruptedException {
driver.findElement(By.xpath(Objectlocators.newjobrequest)).click();
Thread.sleep(1000);
}

@Then("User will be redirected to Add job request page")
public void user_will_be_redirected_to_add_job_request_page() throws InterruptedException {
Boolean Display = driver.findElement(By.xpath(Objectlocators.addjobrequest)).isDisplayed();
System.out.println("Element displayed is :"+Display);
Thread.sleep(2000);
}

@And("User verifies fields on add job request page")
public void user_verifies_fields_on_add_job_request_page() throws InterruptedException {
Thread.sleep(2000);
driver.findElement(By.xpath(Objectlocators.customerfield)).isEnabled();
driver.findElement(By.xpath(Objectlocators.rrole)).isEnabled();
driver.findElement(By.xpath(Objectlocators.bunit)).isEnabled();
driver.findElement(By.xpath(Objectlocators.nop)).isEnabled();
driver.findElement(By.xpath(Objectlocators.location1)).isEnabled();
driver.findElement(By.xpath(Objectlocators.currencytype)).isEnabled();
driver.findElement(By.xpath(Objectlocators.payrange)).isEnabled();
driver.findElement(By.xpath(Objectlocators.payfreq)).isEnabled();
driver.findElement(By.xpath(Objectlocators.employeetype)).isEnabled();
driver.findElement(By.xpath(Objectlocators.contractduration)).isEnabled();
driver.findElement(By.xpath(Objectlocators.projectstartdate)).isEnabled();
driver.findElement(By.xpath(Objectlocators.placementfor)).isEnabled();
driver.findElement(By.xpath(Objectlocators.remoteworking)).isEnabled();
driver.findElement(By.xpath(Objectlocators.recruiter)).isEnabled();
driver.findElement(By.xpath(Objectlocators.jobdescription)).isEnabled();
driver.findElement(By.xpath(Objectlocators.mandatoryskills)).isEnabled();
driver.findElement(By.xpath(Objectlocators.optionalskills)).isEnabled();
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,1000)");
driver.findElement(By.xpath(Objectlocators.Savejobrequest)).isEnabled();
Thread.sleep(2000);
}

@And("User clicks on the Save button without entering the mandatory fields and verifies error meassage")
public void user_clicks_on_the_save_button_without_entering_the_mandatory_fields_and_verifies_error_meassage() throws InterruptedException {
driver.findElement(By.xpath(Objectlocators.Savejobrequest)).click();
Thread.sleep(2000);


String exp = "Job Description is required";
WebElement m = driver.findElement(By.xpath("//*[@id=\"bar-parent10\"]/form/div[5]/div/div/div/div"));
String act = m.getText();
System.out.println("Error message is: "+ act);
Assert.assertEquals(exp, act);
Thread.sleep(2000);


driver.findElement(By.xpath("//*[@class='btn btn-xs pull-right']")).click();
driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/div/div/div/div[3]/ul/li[5]/a")).click();
Thread.sleep(4000);
}
@Given("User navigate to the Recruitment page by logging in Hireprous page")
public void user_navigate_to_the_recruitment_page_by_logging_in_hireprous_page() throws InterruptedException, IOException {
Thread.sleep(3000);
int row = 1;
String s = Integer.toString(row);
Thread.sleep(2000);

driver.findElement(By.name(Objectlocators.UserName))
.sendKeys(ExcelUtils.getExcelData(Config.excelTestData, "Login", s, "2"));
Thread.sleep(1000);
driver.findElement(By.name(Objectlocators.Password))
.sendKeys(ExcelUtils.getExcelData(Config.excelTestData, "Login", s, "3"));
Thread.sleep(1000);

Thread.sleep(2000);
driver.findElement(By.xpath(Objectlocators.loginBtn)).click();
Thread.sleep(2000);
}

@When("User clicks on  Recruitment from top")
public void user_clicks_on_recruitment_from_top() throws InterruptedException {
Thread.sleep(2000);
driver.findElement(By.xpath(Objectlocators.Recbtn)).click();
Thread.sleep(1000);
}

@Then("User will redirected to Recruitment process page")
public void user_will_redirected_to_recruitment_process_page() throws InterruptedException {
driver.findElement(By.xpath(Objectlocators.dashboard)).isEnabled();
Boolean Display = driver.findElement(By.xpath(Objectlocators.recprocess)).isDisplayed();
System.out.println("Element displayed is :"+Display);
Thread.sleep(2000);
}

@And("User clicks on Job Request tab")
public void user_clicks_on_job_request_tab() throws InterruptedException {
Thread.sleep(2000);
driver.findElement(By.xpath(Objectlocators.jobrequest)).click();
Thread.sleep(1000);
}
@And("User clicks on the new Job Request button")
public void user_clicks_on_the_new_job_request_button() throws InterruptedException {
Thread.sleep(2000);
driver.findElement(By.xpath(Objectlocators.newjobrequest)).click();
Thread.sleep(1000);
}
@And("User has to fill the details of Customer Name, Recruitment Role, Business Unit, No. of Openings, Location,  Currency Type, Pay Range, Pay Frequency, Employment Type, Project Start Date, Placement For, Remote Working, Recruiter, Email, Firstname, Lastname, Location, Pay Range, Contract Duration,Job Description, Mandatory Skills, Optional Skills and save the Job request")
public void user_has_to_fill_the_details_of_customer_name_recruitment_role_business_unit_no_of_openings_location_currency_type_pay_range_pay_frequency_employment_type_project_start_date_placement_for_remote_working_recruiter_email_firstname_lastname_location_pay_range_contract_duration_job_description_mandatory_skills_optional_skills_and_save_the_job_request() throws InterruptedException, IOException, AWTException {
int row = 1;
String s = Integer.toString(row);
Thread.sleep(1000);

Thread.sleep(3000);
String cust = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "0");
Select customer = new Select(driver.findElement(By.xpath(Objectlocators.customerfield)));
customer.selectByVisibleText(cust);
Thread.sleep(3000);
String recruitment = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "1");
Select recruitmentRole = new Select(driver.findElement(By.xpath(Objectlocators.rrole)));
recruitmentRole.selectByVisibleText(recruitment);
Thread.sleep(3000);
String business = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "2");
Select businessUnit = new Select(driver.findElement(By.xpath(Objectlocators.bunit)));
businessUnit.selectByVisibleText(business);
Thread.sleep(1000);
String currency = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "5");
Select currencyType = new Select(driver.findElement(By.xpath(Objectlocators.currencytype)));
currencyType.selectByVisibleText(currency);
Thread.sleep(1000);
String payf = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "7");
Select payFrequency = new Select(driver.findElement(By.xpath(Objectlocators.payfreq)));
payFrequency.selectByVisibleText(payf);
Thread.sleep(1000);
String empt = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "8");
Select employmentType = new Select(driver.findElement(By.xpath(Objectlocators.employeetype)));
employmentType.selectByVisibleText(empt);
Thread.sleep(3000);

Point coordinates = driver.findElement(By.name("projectStartDate")).getLocation();
Thread.sleep(1000);
Robot robot = new Robot();
Thread.sleep(4000);
robot.mouseMove(coordinates.getX() + 230, coordinates.getY() + 130);
//155
Thread.sleep(3000);
robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
Thread.sleep(3000);
robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
Thread.sleep(3000);
driver.findElement(By.name("projectStartDate")).sendKeys(Keys.ENTER);

String pf = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "11");
Select placementFor = new Select(driver.findElement(By.xpath(Objectlocators.placementfor)));
placementFor.selectByVisibleText(pf);
Thread.sleep(1000);
String rw = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "12");
Select remoteworking = new Select(driver.findElement(By.xpath(Objectlocators.remoteworking)));
remoteworking.selectByVisibleText(rw);
Thread.sleep(1000);
String nop = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "3");
driver.findElement(By.xpath(Objectlocators.nop)).clear();
driver.findElement(By.xpath(Objectlocators.nop)).sendKeys(nop);
Thread.sleep(1000);
driver.findElement(By.xpath(Objectlocators.location1)).clear();
driver.findElement(By.xpath(Objectlocators.location1))
.sendKeys(ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "4"));
Thread.sleep(1000);
String Payrange = ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "6");
driver.findElement(By.xpath(Objectlocators.payrange)).clear();
driver.findElement(By.xpath(Objectlocators.payrange)).sendKeys(Payrange);
Thread.sleep(1000);
driver.findElement(By.xpath(Objectlocators.contractduration)).clear();
driver.findElement(By.xpath(Objectlocators.contractduration))
.sendKeys(ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "9"));
Thread.sleep(1000);
driver.findElement(By.xpath(Objectlocators.jobdescription)).clear();
driver.findElement(By.xpath(Objectlocators.jobdescription))
.sendKeys(ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "14"));
Thread.sleep(1000);
driver.findElement(By.xpath(Objectlocators.mandatoryskills)).clear();
driver.findElement(By.xpath(Objectlocators.mandatoryskills))
.sendKeys(ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "15"));
Thread.sleep(1000);
driver.findElement(By.xpath(Objectlocators.optionalskills)).clear();
driver.findElement(By.xpath(Objectlocators.optionalskills))
.sendKeys(ExcelUtils.getExcelData(Config.excelTestData, "Jobrequest", s, "16"));

JavascriptExecutor js1 = (JavascriptExecutor) driver;
js1.executeScript("window.scrollBy(0,1000)");
Thread.sleep(1000);

driver.findElement(By.xpath(Objectlocators.Savejobrequest)).click(); // clicking save button
Thread.sleep(5000);
driver.quit();

}
}


