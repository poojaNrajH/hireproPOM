package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMobject {
WebDriver driver;
By logo=By.xpath("//*[@id='hirepro'] | //*[@src='assets/img/Hireprous.png']");
By UserName=By.xpath("email");
By Password=By.xpath("password");
By loginBtn=By.xpath("//*[@class='btn btn-primary form-control']");

public POMobject(WebDriver driver)
{
	this.driver=driver;
}
//*****************************login field verify*********************************//
public void typeLogo() throws InterruptedException 
{
	driver.findElement(logo);
	Thread.sleep(2000);
}

public void typeUsernamefield() throws InterruptedException 
{
	driver.findElement(By.name(Objectlocators.UserName)).isEnabled();
	Thread.sleep(2000);
}
public void typePasswordfield() throws InterruptedException 
{
	driver.findElement(By.name(Objectlocators.Password)).isEnabled();
	Thread.sleep(2000);
}
public void typeloginBtnfield() throws InterruptedException 
{
	driver.findElement(By.xpath(Objectlocators.loginBtn)).isEnabled();
	Thread.sleep(2000);
}
//***********************************invalid credentials********************************//
public void typeinvalidusername() throws InterruptedException 
{
	driver.findElement(By.name(Objectlocators.UserName)).sendKeys(username);
	Thread.sleep(2000);
}
public void typeinvalidpassword() throws InterruptedException 
{
	driver.findElement(By.name(Objectlocators.Password)).sendKeys(password);
	Thread.sleep(2000);
}
public void typeloginbutton() throws InterruptedException 
{
	driver.findElement(By.xpath(Objectlocators.loginBtn)).click();
	Thread.sleep(2000);
}
//***************************************valid credentials*********************************//



	public void typeUsername() throws InterruptedException 
	{
		driver.findElement(username).sendKeys("sangeetha@promantus.com");
		Thread.sleep(2000);
	}
	public void typepassword() throws InterruptedException 
	{
		driver.findElement(password).sendKeys("hireprous@123");
		Thread.sleep(2000);
	}
	public void typeloginbutton() throws InterruptedException 
	{
		driver.findElement(loginbutton).click();
		Thread.sleep(2000);
	}
}}