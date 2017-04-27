package com.imie.dlb;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.imie.dlb.DoliLoginPage;
import com.imie.dlb.DoliUserPage;
/**
 * Test l'accès à l'application
 * @author IMIE
 *
 */
public class DLBAccessAppliTestPOD extends RootTest{

	  /**
	   * Test de Connexion avec un utilisateur inconnu
	   * @throws Exception
	   */
	  @Test
	  public void testVersion() throws Exception {
		  assertEquals("V2.5", ((DoliLoginPage)_currentPage).getVersion());
	  }//testCnxUtiInconnu

	  /**
   * Test de Connexion avec un utilisateur inconnu
   * @throws Exception
   */
  @Test
  public void testCnxUtiInconnu() throws Exception {
	  dlbConnect("UtilisateurInconnu", "PasswordInconnu");
	  assertMsgerror();
  }//testCnxUtiInconnu
  
  /**
   * Test de connexion avec un administrateur
   * @throws Exception
   */
  @Test
  public void testConnexionAdminOK() throws Exception {
 
	  dlbConnect("admin", "admin");
	  assertPageAccueilTitle();
	  assertUtilisateurConnecte("admin");
  }//testConnexionAdminOK
  
  /**
   * Test de connexion avec un utilisateur nonAdmin
   * @throws Exception
   */
  @Test
  public void testConnexionTestOK() throws Exception {
	    dlbConnect("test", "test");
	    assertPageAccueilTitle();
	    assertUtilisateurConnecte("test");
  }//testConnexionTestOK


  
  /**
   * Test de désactivation automatique d'un utilisateur au bout de trios tentatives de connexion
   * @throws Exception
   */
  @Test
  public void testDesactivationUtilisateurAuboutDeTroisTentatives() throws Exception {

	  // Première tentative
	    dlbConnect("test", "MauvaisMdp");

	    dlbConnect("admin", "admin");

	    clickOnUtilisateursEtGroupes();
	    clickOnUtilisateurs();
	    clickOnUser("test");
	    assertUtilisateurActif();

	    dlbDisconnect();

    // tentative 2
	    dlbConnect("test", "MauvaisMdp");

	    dlbConnect("admin", "admin");
	    dlbVisuUtilisateur("test");
	    assertUtilisateurActif();

	    dlbDisconnect();
    
    // tentative 3
	    dlbConnect("test", "MauvaisMdp");
	    dlbConnect("admin", "admin");
	    dlbVisuUtilisateur("test");
	    assertUtilisateurDesactive();
  }

  @Test
  public void testGestUtTestNOK() throws Exception {
	 dlbConnect("test","test");

    clickOnUtilisateursEtGroupes();
    assertGestionUtilisateursPresent(false);
    
    assertEquals(DoliUserPage.TITLE, _currentPage.getTitle());
  }

  @Test
  public void testGestUtAdminOK() throws Exception 
  {
	  //MEI
	  dlbConnect("admin", "admin");
    //Actions
    clickOnUtilisateursEtGroupes();
    
    // Vérification
    clickOnUtilisateursEtGroupes();
    assertGestionUtilisateursPresent(true);
    clickOnUtilisateurs();
  }//testGestUtAdminOK




}
