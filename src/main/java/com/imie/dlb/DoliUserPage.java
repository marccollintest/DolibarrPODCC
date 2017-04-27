package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliUserPage extends DoliMainPage {

	public static final String TITLE = "Dolibarr - Fiche utilisateur";
	
	By ByUtilisateurDesactive  = By.cssSelector("img[alt=\"Désactivé\"]");
	By ByUtilisateurActif  = By.cssSelector("img[alt=\"Actif\"]");
	
	public DoliUserPage(WebDriver pDriver) {
		super( pDriver);
	}
	
    public Boolean isUtilisateurActif()
    {
    	try
    	{
    		driver.findElement(ByUtilisateurActif);
    		return true;
    	}
    	catch (NoSuchElementException ex)
    	{
    		return false;
    	}
    }
    public Boolean isUtilisateurDesactive()
    {
    	try
    	{
    		driver.findElement(ByUtilisateurDesactive);
    		return true;
    	}
    	catch (NoSuchElementException ex)
    	{
    		return false;
    	}
    }
    
}
