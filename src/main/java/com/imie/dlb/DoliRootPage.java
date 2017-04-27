package com.imie.dlb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

public class DoliRootPage extends RootSelenium{



	public DoliRootPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * rend le titre de la page courante
	 * @return
	 */
	public String getTitle()
	{
		return driver.getTitle();
	}

	public String getSubTitle()
	{
		if (isElementPresent(By.cssSelector("div.titre")))
		{
			return driver.findElement(By.cssSelector("div.titre")).getText();
		}
		else
		{
			return "";
		}
	}
	public Boolean isFichePresent()
	{
		return isElementPresent(By.id("card"));
	}

	/**
	 * Cr�ation d'une page de test en fonction du titre
	 * @return
	 */

	protected DoliRootPage createDoliPage()
	{
		DoliRootPage oReturn = this;
		Boolean bOk = false;
		if (!bOk && getTitle().equals(DoliLoginPage.TITLE))
		{	bOk = true;
			oReturn = new DoliLoginPage(driver);
		}
		if (!bOk && getTitle().equals(DoliMainPage.TITLE))
		{	bOk = true;
			oReturn = new DoliMainPage(driver);
		}
		if (!bOk && getTitle().equals(DoliUserPage.TITLE))
		{	bOk = true;
			oReturn = new DoliUserPage(driver);
		}
		if (!bOk && getTitle().equals(DoliUsersPage.TITLE))
		{	bOk = true;
			oReturn = new DoliUsersPage(driver);
		}
		if (!bOk && getTitle().equals(DoliUtilisateursEtGroupesPage.TITLE))
		{	bOk = true;
			oReturn = new DoliUtilisateursEtGroupesPage(driver);
		}
		if (!bOk && getTitle().equals(DoliTiersPage.TITLE)  && getSubTitle().equals(DoliEspaceTiersPage.TITLE))
		{	bOk = true;
			oReturn = new DoliEspaceTiersPage(driver);
		}
		if (!bOk && getTitle().equals(DoliTiersPage.TITLE) && getSubTitle().equals(DoliListeTiersPage.TITLE))
		{	bOk = true;
			oReturn = new DoliListeTiersPage(driver);
		}
		if (!bOk && getTitle().equals(DoliTiersPage.TITLE) && getSubTitle().equals(DoliNouveauTiersPage.TITLE))
		{	bOk = true;
			oReturn = new DoliNouveauTiersPage(driver);
		}
		if (!bOk && getTitle().equals(DoliTiersPage.TITLE) )
		{
				bOk = true;
			if ( isFichePresent())
			{
				oReturn = new DoliFicheTiersPage(driver);
			}
		}
		return oReturn;
	}//createDoliPage
	
}// DoliRootPage