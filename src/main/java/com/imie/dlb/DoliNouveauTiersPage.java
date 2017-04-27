package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliNouveauTiersPage extends DoliTiersPage {

	public static final String TITLE = "Nouveau tiers (prospect, client, fournisseur)";
	
	protected By _ByNomClient = By.name("nom");
	protected By _ByBtnCreer = By.cssSelector("center > input.button");
	

	public DoliNouveauTiersPage(WebDriver pDriver) {
		super( pDriver);
	}
	
	protected void setNomClient(String pNomclient)
	{
		driver.findElement(_ByNomClient).clear();
		driver.findElement(_ByNomClient).sendKeys(pNomclient);
	}
	
	protected DoliRootPage clickOnCreerClient()
	{
	    driver.findElement(_ByBtnCreer).click();
	    return createDoliPage();
	}

}
