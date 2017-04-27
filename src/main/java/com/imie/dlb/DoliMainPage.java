package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliMainPage extends DoliRootPage{

	public static final String TITLE = "Dolibarr - Espace accueil - Dolibarr 3.6.1";
	
	By ByUtilisateurConnecte = By.xpath("//*[@id='mainbody']/div[2]/div[1]/div/div/a");
	By byMnuUtilisateurEtGroupes = By.linkText("Utilisateurs & Groupes");
	By byMnuUtilisateurs = By.linkText("Utilisateurs");
	By byTiers = By.id("mainmenua_companies");
	By byLogout = By.xpath("//img[@alt=\"Déconnexion\"]");
	
	
	public DoliMainPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	
	public DoliRootPage Logout()
	{
		assert(driver != null);
		
		driver.findElement(byLogout).click();
		return createDoliPage();
	}

	public DoliRootPage ClickOnTiers()
	{
		assert(driver != null);
		driver.findElement(byTiers).click();
		return createDoliPage();
	}
	
	public String getUtilisateurConnecte()
	{
		return driver.findElement(ByUtilisateurConnecte).getText();
	}
	
	
	public Boolean isMenuActifUtilisateurEtGroupes()
	{
		try
		{
			driver.findElement(byMnuUtilisateurEtGroupes);
			return true;
		}
		catch (NoSuchElementException ex)
		{
			return false;
		}
	}//isMenuActifUtilisateurEtGroupes
	
	public Boolean isMenuActifUtilisateurs()
	{
		try
		{
			WebElement oWE = driver.findElement(byMnuUtilisateurs);
			return oWE.isEnabled();
		}
		catch (NoSuchElementException ex)
		{
			return false;
		}
	}//isMenuActifUtilisateurEtGroupes
	
	public DoliRootPage clickOnUtilisateursetGroupes()
	{
	    driver.findElement(byMnuUtilisateurEtGroupes).click();
	    return createDoliPage();
	}
	
	public DoliRootPage clickOnUtilisateurs()
	{
	    driver.findElement(byMnuUtilisateurs).click();
	    return createDoliPage();
	}
	
	
/*	*//** 
	 * Rend Vrai sur le menu bank est inactif
	 * @return
	 *//*
	public Boolean isBanqueCaisseInActif()
	{
		  try {
			    driver.findElement(By.xpath("//a[@id='mainmenua_bank'] [@class='tmenudisabled']"));
			    return true;
			  } catch (NoSuchElementException e) {
			    return false;
			  }
	}
*/
}
