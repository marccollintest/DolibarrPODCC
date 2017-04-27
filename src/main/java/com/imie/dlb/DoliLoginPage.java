package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliLoginPage extends DoliRootPage {

	public static final String TITLE = "Dolibarr - Login Dolibarr 3.6.1";
	
	By ByUserName = By.id("username");
	By ByPassword = By.id("password");
	By ByConnect = By.xpath("//input[@type=\"submit\"]");
	By ByMsgError = By.cssSelector("div.error");
	By ByVersion = By.xpath(".//*[@id='login']/table/tbody/tr/td");

	
	// Les �lements d'interface disponible sur la page
	private WebElement tbUserName;
	private WebElement tbPassword;
	private WebElement btnConnect;
	
	public DoliLoginPage(WebDriver pDriver) {
		super( pDriver);
		construct();
	}
	
	/**
	 * Methode de construction de la page : instanciation des attributs
	 */
	protected void construct()
	{
		assert(driver != null);
		// V�rification que l'on est bien sur la bonne page
	    String sTitle = driver.getTitle();
		if(!sTitle.equals(TITLE)) {
            throw new IllegalStateException("This is not Login Page, current page is: " +driver.getCurrentUrl());
		}		
		tbUserName = driver.findElement(ByUserName);
		tbPassword = driver.findElement(ByPassword);
		btnConnect = driver.findElement(ByConnect);
	}
	
	/**
	 * Accessor en ecriture du username
	 * @param pUser
	 */
	public void setUserName(String pUser)
	{
 	    tbUserName.clear();
	    tbUserName.sendKeys(pUser);
		
	}
	
	public void setPassword(String ppwd)
	{
		
	    tbPassword.clear();
	    tbPassword.sendKeys(ppwd);
	}
	
	public DoliRootPage clickOnConnect()
	{
		assert(driver != null);
	    btnConnect.click();
	    return createDoliPage();
	}
	
	public String getMessageError()
	{
		assert(driver != null);

		return driver.findElement(ByMsgError).getText();
	}

	public String getVersion()
	{
		assert(driver != null);

		return driver.findElement(ByVersion).getText();
	}
}
