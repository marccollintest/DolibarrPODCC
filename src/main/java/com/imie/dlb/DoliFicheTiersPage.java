package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliFicheTiersPage extends DoliTiersPage {

	public static final String TITLE = DoliTiersPage.TITLE;
	
	protected By _BtnModifier = By.linkText("Modifier"); 
	protected By _btnSupprimer = By.id("action-delete");
	protected By _btnConFirme = By.xpath("//body[@id='mainbody']/div[5]/div[3]/div/button");
	protected By _ByVilleEcr = By.id("town");
	protected By _ByVilleLect = By.xpath(".//*[@id='id-right']/div/div[2]/table/tbody/tr[5]/td[2]");
	protected By _ByBtnSave = By.name("save");
	

	public DoliFicheTiersPage(WebDriver pDriver) {
		super( pDriver);
	}
	
	
	protected DoliRootPage clickOnModifierClient() {
		driver.findElement(_BtnModifier).click();
		return createDoliPage();
	}

	protected DoliRootPage clickOnDeleteClient() {
		// click | id=action-delete | 
	    driver.findElement(_btnSupprimer).click();
	    driver.findElement(_btnConFirme).click();
	    return createDoliPage();
	}

	public void setVille(String pVille)
	{
	    driver.findElement(_ByVilleEcr).clear();
	    driver.findElement(_ByVilleEcr).sendKeys(pVille);

	}
	public String getVille()
	{
	    return driver.findElement(_ByVilleLect).getText();

	}
	
	protected DoliRootPage clickOnSaveClient() {
		// click | name=save | 
	    driver.findElement(_ByBtnSave).click();
	    return createDoliPage();
	}

}
