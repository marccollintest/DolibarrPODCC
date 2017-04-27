package com.imie.dlb;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.imie.dlb.DoliEspaceTiersPage;
import com.imie.dlb.DoliFicheTiersPage;
import com.imie.dlb.DoliListeTiersPage;
import com.imie.dlb.DoliLoginPage;
import com.imie.dlb.DoliMainPage;
import com.imie.dlb.DoliNouveauTiersPage;
import com.imie.dlb.DoliRootPage;
import com.imie.dlb.DoliTiersPage;
import com.imie.dlb.DoliUserPage;
import com.imie.dlb.DoliUsersPage;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
/**
 * Test l'accès à l'application
 * @author IMIE
 *
 */
public class RootTest {
  protected static WebDriver driver;
  protected static String baseUrl;
  protected boolean acceptNextAlert = true;
  
  protected boolean _bconnected = false;
  
  protected DoliRootPage _currentPage = null;

  @BeforeClass
  public static void setUpClass() throws Exception {
/*	  //Using PhantomJS
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setJavascriptEnabled(true);
	  caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
	  driver = new PhantomJSDriver(caps);
*/
	  // using firefox
	  driver = new FirefoxDriver();
	  
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @AfterClass
  public static void tearDownClass() throws Exception {
	  
	  driver.quit();
  }
  @Before
  public void setUp() throws Exception {
	  //Procédure de connexion
	    driver.get(baseUrl + "/dolibarr/htdocs/user/logout.php");
	    driver.get(baseUrl + "/dolibarr/htdocs/index.php");
	    _currentPage = new DoliLoginPage(driver);
	  }
  
  @After
  public void teardown() throws Exception {
	  // Procédure de déconnexion
	  if (isElementPresent(By.xpath("//img[@alt=\"Déconnexion\"]")))
			  {
		  		boolean bok = false;
		  		while (!bok)
		  		try
		  		{
		  			driver.findElement(By.xpath("//img[@alt=\"Déconnexion\"]")).click();
		  			bok = true;
		  		}
		  		catch (Exception ex)
		  		{
		  			Thread.sleep(1000);
		  			bok = false;
		  		}
			  }
	  }
  
  
  protected void setPassword(String pPassword) {
		//Pre-condition
		assertTrue("On devrait être sur la page de login ", _currentPage.getTitle().equals(DoliLoginPage.TITLE));

		((DoliLoginPage)_currentPage).setPassword(pPassword);
	}
	  
	protected void setUserName(String pUserName) {
		//Pre-condition
		assertTrue("On devrait être sur la page de login ", _currentPage.getTitle().equals(DoliLoginPage.TITLE));

		((DoliLoginPage)_currentPage).setUserName(pUserName);
	}
	
	protected void clickOnConnect() {
		//Pre-condition
		assertTrue("On devrait être sur la page de login ", _currentPage.getTitle().equals(DoliLoginPage.TITLE));

		_currentPage = ((DoliLoginPage)_currentPage).clickOnConnect();
	}
	protected void assertMsgerror() {
		//Pre-condition
		assertTrue("On devrait être sur la page de login ", _currentPage.getTitle().equals(DoliLoginPage.TITLE));
	    
		assertEquals("Identifiants login ou mot de passe incorrect", ((DoliLoginPage)_currentPage).getMessageError());
	}

	protected void assertPageAccueilTitle() {
		assertEquals("Dolibarr - Espace accueil - Dolibarr 3.6.1", _currentPage.getTitle());
	}

	protected void clickOndisconnect() {
		//PreCondition
		assertTrue("On doit être Connecté", _bconnected);
		_currentPage = ((DoliMainPage)_currentPage).Logout();
	    _bconnected = false;
	}


	protected void assertUtilisateurConnecte(String pUser ) {
		//Pre-condition
		assertTrue("On devrait être sur la page d'Accueil ", _currentPage.getTitle().equals(DoliMainPage.TITLE));

		//assertTrue(isElementPresent(By.linkText(pUser)));
		assertEquals(pUser, ((DoliMainPage)_currentPage).getUtilisateurConnecte());
	}
	
	 protected void assertGestionUtilisateursetGroupesPresent(Boolean pVerifelementPresent) {
		  assertEquals(pVerifelementPresent, ((DoliMainPage) _currentPage).isMenuActifUtilisateurEtGroupes());
	 }
	 
	 protected void assertGestionUtilisateursPresent(Boolean pVerifelementPresent) {
			  assertEquals(pVerifelementPresent, ((DoliMainPage) _currentPage).isMenuActifUtilisateurs());
	}

		protected void clickOnUtilisateursEtGroupes() {
			_currentPage = ((DoliMainPage)_currentPage).clickOnUtilisateursetGroupes();
		}

		protected void clickOnUtilisateurs() {
			_currentPage = ((DoliMainPage)_currentPage).clickOnUtilisateurs();
		}

		protected void clickOnUser(String pUser) {
			assertEquals (DoliUsersPage.TITLE, _currentPage.getTitle());
			_currentPage = ((DoliUsersPage)_currentPage).clickOnUtilisateur(pUser);
		}

		protected void assertUtilisateurActif() {
			// assertText | css=img[alt="Actif"] | 
		    assertTrue( ((DoliUserPage)_currentPage).isUtilisateurActif());
		}

		protected void assertUtilisateurDesactive() {
			// verifyElementPresent | css=img[alt="Désactivé"] | 
		    assertTrue("Utilisateur non désactivé", ((DoliUserPage)_currentPage).isUtilisateurDesactive());
		}

		protected void clickOnTiers() {
			_currentPage = ((DoliMainPage)_currentPage).ClickOnTiers();
		}

		
		protected void rechercherClient(String pNomclient) {
			((DoliEspaceTiersPage)_currentPage).setNomTiers(pNomclient);
			_currentPage = ((DoliEspaceTiersPage)_currentPage).clickOnRechercher();
		}

		protected int getNbreClients(String pNomclient) {
			int nbre = ((DoliListeTiersPage)_currentPage).getnbreClient(pNomclient);
			return nbre;
		}

		protected void clickOnNouveauClient() {
			// click | link=Nouveau client | 
			_currentPage = ((DoliTiersPage)_currentPage).clickOnNouveauClient();
		}

		
		protected void setNomClient(String pNomclient) {
			((DoliNouveauTiersPage)_currentPage).setNomClient(pNomclient);
			}

		protected void clickOnCreerClient() {
			// click | css=center > input.button | 
			_currentPage = ((DoliNouveauTiersPage)_currentPage).clickOnCreerClient();
		}
		
		protected void selectionClient(String pNomclient) {
			_currentPage = ((DoliListeTiersPage)_currentPage).SelecttionClient(pNomclient);
		}
		
		protected String getVilleClient() {
			return ((DoliFicheTiersPage)_currentPage).getVille();
		}
		protected void setVilleClient(String pVille) {
			((DoliFicheTiersPage)_currentPage).setVille(pVille);
		}
		protected void clickOnSaveClient() {
			_currentPage = ((DoliFicheTiersPage)_currentPage).clickOnSaveClient();
		}
		
		  protected void clickOnDeleteClient() {
				_currentPage = ((DoliFicheTiersPage)_currentPage).clickOnDeleteClient();
				
			}
		  protected void clickOnModifierClient() {
				_currentPage = ((DoliFicheTiersPage)_currentPage).clickOnModifierClient();
				
			}

		
	 /*==========
		Méthodes à transcrire en POD
		========*/	 
	 


//  protected void clickOnCreerClient() {
//		// click | css=center > input.button | 
//	    driver.findElement(By.cssSelector("center > input.button")).click();
//	}
//	protected void setNomClient(String pNomclient) {
//		// type | name=nom | ${nomclient}
//	    driver.findElement(By.name("nom")).clear();
//	    driver.findElement(By.name("nom")).sendKeys(pNomclient);
//	}
//	protected void clickOnNouveauClient() {
//		// click | link=Nouveau client | 
//	    driver.findElement(By.linkText("Nouveau client")).click();
//	}
//	protected int getNbreClients(String pNomclient) {
//		return driver.findElements(By.xpath("//a[contains(text(),'" + pNomclient + "')]")).size();
//	}
//	protected void rechercherClient(String pNomclient) {
//		((DoliTiersPage)_currentPage).
//		driver.findElement(By.name("search_nom_only")).clear();
//	    driver.findElement(By.name("search_nom_only")).sendKeys(pNomclient);
//	    driver.findElement(By.xpath("//input[@value='Rechercher']")).click();
//	}
//	protected void clickOnTiers() {
//		driver.findElement(By.cssSelector("div.mainmenu.companies")).click();
//	}
//	protected String getVilleClient() {
//		return driver.findElement(By.xpath("//div[@id='id-right']/div/div[2]/table/tbody/tr[5]/td[2]")).getText();
//	}
//	protected void clickOnSaveClient() {
//		// click | name=save | 
//	    driver.findElement(By.name("save")).click();
//	}
//	protected void setVilleClient(String pVille) {
//		// click | link=Modifier | 
//	    driver.findElement(By.id("town")).clear();
//	    driver.findElement(By.id("town")).sendKeys(pVille);
//	}
//	protected void selectionClient(String pNomclient) {
//	    driver.findElement(By.linkText(pNomclient)).click();
//	}
	//===========================================
	  // Procédures fonctionnelles de l'application
	//===========================================

	/**
	 * Connexion à l'application dolibarr
	 * @param pUser
	 * @param pPassword
	 */
		protected void dlbConnect(String pUser, String pPassword) {
			// Préconditions (Exemple de prog par contrat)
			assertTrue("on ne devrait pas être connecté", !_bconnected );

		    _currentPage = new DoliLoginPage(driver);
		    
		    ((DoliLoginPage)_currentPage).setUserName(pUser);
		    ((DoliLoginPage)_currentPage).setPassword(pPassword);
		    _currentPage= ((DoliLoginPage)_currentPage).clickOnConnect();

		    _bconnected = !(_currentPage.getTitle().equals(DoliLoginPage.TITLE));
			
			//on peut être connecté ou pas en fonction des params
		}//dlbConnect

		protected void dlbVisuUtilisateur(String pUser) {
			// Préconditions (Exemple de prog par contrat)
			assertTrue("on devrait être connecté", _bconnected );

		    clickOnUtilisateursEtGroupes();
		    clickOnUtilisateurs();
		    clickOnUser(pUser);
		}//dlbVisuUtilisateur
		
		protected void dlbDisconnect() {
			// Préconditions (Exemple de prog par contrat)
			assertTrue("on devrait être connecté", _bconnected );
			clickOndisconnect();

		}//dlbDisconnect
		/**
		 * Création d'un client
		 * @param pNomclient
		 */
		protected void dlbCreerClient(String pNomclient)
		{
			assertTrue("La session doit être connectée", _bconnected );
		    clickOnTiers();
		    clickOnNouveauClient();
		    setNomClient(pNomclient);
		    clickOnCreerClient();
		}
		
		/**
		 * Suppression d'un client
		 * @param pNomclient
		 */
		protected void dlbSupprimerClient(String pNomclient)
		{
			assertTrue("La session doit être connectée", _bconnected );
		    clickOnTiers();
		    rechercherClient(pNomclient);
		    selectionClient(pNomclient);
		    clickOnDeleteClient();
		}


protected boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  protected boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
