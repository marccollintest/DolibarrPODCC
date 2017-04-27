package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliUsersPage extends DoliMainPage {

	public static final String TITLE = "Dolibarr - Liste des utilisateurs";
	
	
	public DoliUsersPage(WebDriver pDriver) {
		super( pDriver);
	}
	
	public DoliRootPage clickOnUtilisateur(String pUser)
	{
		assertEquals(TITLE,getTitle());
	    driver.findElement(By.linkText(pUser)).click();
	    return createDoliPage();
	}
}
