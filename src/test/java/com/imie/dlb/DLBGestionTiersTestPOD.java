package com.imie.dlb;

import java.util.regex.Pattern;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.imie.dlb.DoliListeTiersPage;
import com.imie.dlb.DoliMainPage;
import com.imie.dlb.DoliNouveauTiersPage;
import com.imie.dlb.DoliTiersPage;

public class DLBGestionTiersTestPOD extends RootTest{

	private String nomclient ="CLIENT" + new Date().toString();

  @Test
  public void testGestionTiersCreation() throws Exception {
	  // Arrange
	dlbConnect("admin", "admin");
    
	assertEquals(DoliMainPage.TITLE, _currentPage.getTitle());
    clickOnTiers();
    assertEquals(DoliTiersPage.TITLE, _currentPage.getTitle());
    rechercherClient(nomclient);
    assertEquals(DoliListeTiersPage.TITLE, _currentPage.getSubTitle());
    int nbClientAvant = getNbreClients(nomclient);
    // Act
    // création d'un nouveau client
    clickOnNouveauClient();
    assertEquals(DoliNouveauTiersPage.TITLE, _currentPage.getSubTitle());
    setNomClient(nomclient);
    clickOnCreerClient();

    clickOnTiers();
    rechercherClient(nomclient);
    //assert
    assertEquals(nbClientAvant+1, getNbreClients(nomclient));
    
    // Silent
    dlbSupprimerClient(nomclient);
  }
  
  @Test
  public void testGestionTiersModification() throws Exception {
	dlbConnect("admin", "admin");
    clickOnTiers();
    clickOnNouveauClient();
    setNomClient(nomclient);
    clickOnCreerClient();

    clickOnTiers();
    rechercherClient(nomclient);
    // Selection
    selectionClient(nomclient);
    clickOnModifierClient();
    // initialisation de la Ville de départ
    setVilleClient("Ville1");
    clickOnSaveClient();

    clickOnTiers();
    rechercherClient(nomclient);
    selectionClient(nomclient);
    clickOnModifierClient();
    setVilleClient("Ville2");

    clickOnSaveClient();

    clickOnTiers();
    rechercherClient(nomclient);
    selectionClient(nomclient);
    assertTrue( getVilleClient().contains("Ville2"));
    
    // Silent
    dlbSupprimerClient(nomclient);

  }
  @Test
  public void testGestionTiersSuppression() throws Exception {
	dlbConnect("admin", "admin");
    clickOnTiers();
    clickOnNouveauClient();
    setNomClient(nomclient);
    clickOnCreerClient();
    clickOnTiers();
    rechercherClient(nomclient);
    int nbClientAvant = getNbreClients(nomclient);
    selectionClient(nomclient);
    clickOnDeleteClient();
    clickOnTiers();
    rechercherClient(nomclient);
    assertEquals(nbClientAvant-1, getNbreClients(nomclient));
    

  }
}
