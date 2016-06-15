/**
 * 
 */
package com.webcom.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.util.Util;
import com.webcom.page.LoginPage;

/**
 * @author Rubens Medeiros Lobo
 *
 * 	Realiza o login na aplica��o
 *
 */
public class VerifyWebComLogin {
	
	public WebDriver driver;
	
	@BeforeTest
	public void start(){
		System.setProperty("webdriver.ie.driver",".\\Drivers\\IEDriverServer.exe");
	}
	
	@Test(priority=1)
	public void VerifyValidLogin() throws IOException
	{
		Util util=new Util();
		util.killProcess("iexplore.exe");
		util.killProcess("IEDriverServer.exe");
		String[] dados = util.GetDataTable(".\\DataTable\\DataTabe.xls",3);
				
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get(dados[0]);
		
		LoginPage login=new LoginPage(driver);
		login.LogarPageLogin(dados[1], dados[2]);		
	}
	
	
	@AfterTest
	public void CleanUp()
	{
		driver.close();
	}
	
}
