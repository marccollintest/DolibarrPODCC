package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliListeClientsPage extends DoliTiersPage {

	public static final String TITLE = "Liste des Clients";
	
	protected By ByListeDesClients = By.linkText("Liste des clients"); 
	
	
	public DoliListeClientsPage(WebDriver pDriver) {
		super( pDriver);
	}
	
	/**
	 * Mauvais développemeent
	 * La page n'a pas de titre particulier
	 */
	public String getTitle()
	{
		return driver.findElement(By.cssSelector("div.titre")).getText();
	}
	
	
	public DoliRootPage clickOnListeDesClients()
	{
		assertEquals(TITLE,getTitle());
	    driver.findElement(ByListeDesClients).click();
	    return createDoliPage();
	}
}
