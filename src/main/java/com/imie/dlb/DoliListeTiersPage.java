package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliListeTiersPage extends DoliTiersPage {

	public static final String TITLE = "Liste des tiers";
	
	

	public DoliListeTiersPage(WebDriver pDriver) {
		super( pDriver);
	}
	
	/**
	 * Mauvais développemeent
	 * La page n'a pas de titre particulier
	 */

	public int getnbreClient (String pNomclient)
	{
		return driver.findElements(By.xpath("//a[contains(text(),'" + pNomclient + "')]")).size();
	}
	
	public DoliRootPage SelecttionClient(String pNomclient)
	{
	    driver.findElement(By.linkText(pNomclient)).click();
	    return createDoliPage();
	}

}
