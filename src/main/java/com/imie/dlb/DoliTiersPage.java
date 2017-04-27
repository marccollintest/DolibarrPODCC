package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliTiersPage extends DoliMainPage {

	public static final String TITLE = "Dolibarr - Tiers";
	
	protected By _ByListeDesClients = By.linkText("Liste des clients"); 
	protected By _ByNomTiers = By.name("search_nom_only");
	protected By _ByBtnRechercher = By.xpath("//input[@value='Rechercher']");
	protected By _ByLnkNouveauclient = By.linkText("Nouveau client");
	
	public DoliTiersPage(WebDriver pDriver) {
		super( pDriver);
	}

	public DoliRootPage clickOnListeDesClients()
	{
		assertEquals(TITLE,getTitle());
	    driver.findElement(_ByListeDesClients).click();
	    return createDoliPage();
	}
	
	public void setNomTiers(String pNom)
	{
		driver.findElement(_ByNomTiers).clear();
	    driver.findElement(_ByNomTiers).sendKeys(pNom);
	}
	public DoliRootPage clickOnRechercher()
	{
		assertEquals(TITLE,getTitle());
	    driver.findElement(_ByBtnRechercher).click();
	    return createDoliPage();
	}
	
	public DoliRootPage clickOnNouveauClient()
	{
		driver.findElement(_ByLnkNouveauclient).click();
		return createDoliPage();
	}

}
