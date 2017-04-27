package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliEspaceTiersPage extends DoliTiersPage {

	public static final String TITLE = "Espace Tiers";
	
	protected By _ByNomTiers = By.name("search_nom_only");
	protected By _ByBtnRechercher = By.xpath("//input[@value='Rechercher']");
	
	public DoliEspaceTiersPage(WebDriver pDriver) {
		super( pDriver);
	}

	
	public void setNomTiers(String pNom)
	{
		driver.findElement(_ByNomTiers).clear();
	    driver.findElement(_ByNomTiers).sendKeys(pNom);
	}
	public DoliRootPage clickOnRechercher()
	{
		assertEquals(TITLE,getSubTitle());
	    driver.findElement(_ByBtnRechercher).click();
	    return createDoliPage();
	}
	

}
