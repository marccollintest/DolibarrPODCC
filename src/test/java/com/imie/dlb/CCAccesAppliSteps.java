package com.imie.dlb;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.imie.dlb.DoliLoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CCAccesAppliSteps extends RootTest{


	
//	  @BeforeClass
//	  public static void setUpClass() throws Exception {
//	    driver = new FirefoxDriver();
//	    baseUrl = "http://localhost/";
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  }
//	  @AfterClass
//	  public static void tearDownClass() throws Exception {
//		  
//		  driver.quit();
//	  }
//	  @Before
//	  public void setUp() throws Exception {
//		  //Procédure de connexion
//		    driver.get(baseUrl + "/dolibarr/htdocs/user/logout.php");
//		    driver.get(baseUrl + "/dolibarr/htdocs/index.php");
//		    assertEquals("V2.5", driver.findElement(By.xpath("//form[@id='login']/table/tbody/tr/td")).getText());
//		    _currentPage = new DoliLoginPage(driver);
//		  }
//	  
//	  @After
//	  public void teardown() throws Exception {
//		  // Procédure de déconnexion
//		  if (isElementPresent(By.xpath("//img[@alt=\"Déconnexion\"]")))
//				  {
//			  		boolean bok = false;
//			  		while (!bok)
//			  		try
//			  		{
//			  			driver.findElement(By.xpath("//img[@alt=\"Déconnexion\"]")).click();
//			  			bok = true;
//			  		}
//			  		catch (Exception ex)
//			  		{
//			  			Thread.sleep(1000);
//			  			bok = false;
//			  		}
//				  }
//		  }
//
//	

	@Given("^un navigateur est démaré$")
	public void un_navigateur_est_démaré() throws Throwable {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^Je suis sur la page de login$")
	public void je_suis_sur_la_page_de_login() throws Throwable {
	    driver.get(baseUrl + "/dolibarr/htdocs/user/logout.php");
	    driver.get(baseUrl + "/dolibarr/htdocs/index.php");
	    _currentPage = new DoliLoginPage(driver);
	    assertEquals("V2.5", driver.findElement(By.xpath("//form[@id='login']/table/tbody/tr/td")).getText());
	}

	@When("^Je connecte en \"([^\"]*)\" et \"([^\"]*)\"$")
	public void je_connecte_en_et(String arg1, String arg2) throws Throwable {
		dlbConnect(arg1, arg2);
		
	}

	@Then("^La page affichée est la page d'acccueil$")
	public void la_page_affichée_est_la_page_d_acccueil() throws Throwable {
		assertEquals(DoliMainPage.TITLE, _currentPage.getTitle());
	}

	@Then("^L'utilisateur connecté est \"([^\"]*)\"$")
	public void l_utilisateur_connecté_est(String arg1) throws Throwable {
		assertUtilisateurConnecte(arg1);
	}
	
	@Then("^je ferme le navigateur$")
	public void je_ferme_le_navigateur() throws Throwable {
		driver.quit();
	}

	@Then("^un message d'erreur est affiché$")
	public void un_message_d_erreur_est_affiché() throws Throwable {
		
		assertMsgerror();
	}
	

@Then("^La page affichée est la page de login$")
public void la_page_affichée_est_la_page_de_login() throws Throwable {
 assertEquals(DoliLoginPage.TITLE,_currentPage.getTitle());
}


@Given("^je cliclk sur Tiers$")
public void je_cliclk_sur_Tiers() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    clickOnTiers();
}

private int _nbClientAvant=0;
private String _NomClient;

@Given("^je lis le nbre de clients \"([^\"]*)\"$")
public void je_lis_le_nbre_de_clients(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	_nbClientAvant=  getNbreClients(arg1);
}

@When("^Je cree un client \"([^\"]*)\" , Ville \"([^\"]*)\"$")
public void je_cree_un_client_Ville(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    dlbCreerClient(arg1);
    _NomClient = arg1;
}

@Then("^le Nombre de clients est augmenté de (\\d+)$")
public void le_nombre_de_clients_est_augmenté_de(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   clickOnTiers();
   rechercherClient(_NomClient);
   int nbreApres = getNbreClients(_NomClient);
   assertEquals(1, nbreApres-_nbClientAvant);
}

//@Given("^je cliclk sur Tiers$")
//public void je_cliclk_sur_Tiers() throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    clickOnTiers();
//}

@Given("^je recherche \"([^\"]*)\"$")
public void je_recherche(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    rechercherClient(arg1);
}
}
