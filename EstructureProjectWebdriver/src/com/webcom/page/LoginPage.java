/**
 * 
 */
package com.webcom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Rubens de Medeiros lobo
 *
 *	Boas praticas Page Objects
 *
 *	Esta classe guardara todos os objetos e metodos da pagina de login da apliação
 */
public class LoginPage {

	WebDriver driver;
		
	By username=By.id("user_login");
	By password=By.id("user_password");
	By loginButton=By.xpath("html/body/div[1]/div/div/div/form/button");
	By linkSair=By.xpath(".//*[@id='bemvindo']/a");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void TypeUserName(String UserName)
	{
		driver.findElement(username).sendKeys(UserName);
	}
	public void TypePassword(String Pass)
	{
		driver.findElement(password).sendKeys(Pass);
	}
	public void ClickonLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	public void validAcessAplication()
	{
		Assert.assertTrue(linkSair.toString().contains("bemvindo"));
	}
	public void LogarPageLogin(String UserName, String Pass)
	{
		LoginPage login=new LoginPage(driver);
		login.TypeUserName(UserName);
		login.TypePassword(Pass);
		login.ClickonLoginButton();
		login.validAcessAplication();
	}	
}
