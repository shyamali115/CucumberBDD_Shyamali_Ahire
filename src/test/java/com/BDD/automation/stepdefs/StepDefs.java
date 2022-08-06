package com.BDD.automation.stepdefs;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.BDD.automation.core.WebDriverFactory;
import com.BDD.automation.runners.pageobj.LandingPageObj;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs
{
	
	WebDriver driver;
	int implicitWait_Timeout_sec = 20;
	Scenario scn;
	WebDriverWait wait;

  	String base_url = "http://automationpractice.com/index.php";
	
	String expected_Title = "My Store";
	String expected_prodcat="WOMEN DRESSES T-SHIRTS";
	
	LandingPageObj landingpageobj;	
	   
	   @Before
	    public void setUp(Scenario scn) throws Exception
	    {
	    	this.scn=scn;
	    	
	    	String browserName = WebDriverFactory.getBrowserName();
			driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		//	logger.info("Browser invoked.");
	        scn.log("Browser invoked");

	     //   logger.info("Browser invoked.");
	        driver.manage().window().maximize();
	       // logger.info("Browser maximised");
	        driver.manage().timeouts().implicitlyWait(implicitWait_Timeout_sec, TimeUnit.SECONDS);
	        
	        landingpageobj=new LandingPageObj(driver,scn);
	     
	    }
	    
	   @After(order=1)
		public void cleanUp(){

			WebDriverFactory.quitDriver();
			scn.log("Browser is quit");
		}

		@After(order=2)
		public void takeScreenShot(Scenario s)
		{
			if (s.isFailed())
			{
				TakesScreenshot scrnShot = (TakesScreenshot)driver;
				byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
				scn.attach(data, "image/png","Failed Step Name: " + s.getName());
			}
			else
			{
				scn.log("Test case is passed, no screen shot captured");
			}
		}
	 
//-------------Background-------------------------	
	
	@Given("Navigate to URL")
	public void navigate_to_url()
	{
		driver.get(base_url);
	//	logger.info("Browser navigated to URL: " + base_url);
		scn.log("Browser navigated to URL: " + base_url);
		Assert.assertEquals(base_url, driver.getCurrentUrl());
	    
	}
	
//----------------Redirection URL -----------------------	

	@When("Redirect the URL {string}")
	public void redirect_the_url(String page_url)
	{
		//landingpageobj = new LandingPageObj(driver, scn);
		//logger.info("User navigating from base URL to Landing Page");
			landingpageobj.validate_pageurl(page_url);
		  scn.log("User navigating from base URL to Landing Page");
	}
	
	@Then("Result Page is displayed")
	public void result_page_is_displayed()
	{		
		scn.log(" Actual URL: " +driver.getCurrentUrl() );
		//logger.info(" Actual URL: " + actual );
	}
	
//--------------------Landing Page Title------------------
	
	@When("Landing Page Title should be displayed")
	public void landing_page_title_should_be_displayed() 
	{
		
		scn.log("Landing page title is: " + driver.getTitle());
	   
	}


	@Then("Expected Landing Page Title should be {string}")
	public void expected_landing_page_title_should_be(String page_title)
	{
		landingpageobj.validate_pagetitle(page_title);
   //	logger.info("Landing page title is: " + driver.getTitle());
		
	}

	
//---------------------Validate Product Category-----------------------
	
	@When("User see the product category")
	public void user_see_the_product_category()
	
	{
		 landingpageobj.display_ProdCatagory();
    	
	}

	@Then("Validate the product category and number of product to be dispalyed")
	public void validate_the_product_category_and_number_of_product_to_be_dispalyed()
	{
		scn.log("All product catagories are displayed");
    	//logger.info("All product catagories are displayed");
	}

	
	
//--------------------------Display Landing Page Logo-------------------------------------

	@When("User open the Landing page")
	public void user_open_the_landing_page()
	{
		landingpageobj.display_logo();
	}

	@Then("Landing page logo should be displayed")
	public void landing_page_logo_should_be_displayed()
	{
		scn.log("Display the application logo on landing page");   
	}
	
	
	
//-----------------------------Validate Logo Height-------------------------
	
	
	@When("User open the landing page to validate logo height")
	public void user_open_the_landing_page_to_validate_logo_height()
	{
		
		landingpageobj.getatt_logoheight();
	}


	@Then("Landing page logo height should be {string}")
	public void landing_page_logo_height_should_be(String logo_height)
	{
	  landingpageobj.validate_logoHeight(logo_height);
	}


//---------------------Validate Logo Width----------------
	
	@When("User open the landing page to validate Logo width")
	public void user_open_the_landing_page_to_validate_logo_width() 
	{
			landingpageobj.getatt_logowidth();
	}


	@Then("Landing page logo width should be {string}")
	public void landing_page_logo_width_should_be(String logo_width)
	{
	   landingpageobj.validate_logowidth(logo_width);
	}

//---------------------Validate Signin Page with Title-----------------------------
	
	@When("click on signin button")
	public void click_on_signin_button() 
	{
	   landingpageobj.clickon_signinbtn();
	}


	@Then("Expected Signin page title should be {string}")
	public void expected_signin_page_title_should_be(String exp_signinpage_Title)
	{
	    landingpageobj.validate_signinpage_title(exp_signinpage_Title);
	  
	}

//-------------------------Search product and display number of Product list -------------------------
	
	@When("User search for a product {string}")
	public void user_search_for_a_product(String Prod_name) throws InterruptedException 
	{
		landingpageobj.user_searchprod(Prod_name);

	}
	

	@Then("Display the number of product list")
	public void display_the_number_of_product_list()
	{
	   scn.log("Display the number of product list");
	}


//---------------------------------Twitter Link--------------------------------------------	
	
	@Given("User click on Twitter link")
	public void user_click_on_twitter_link()
	{
	  // landingpageobj.view_TwitterLink();
		  scn.log("Validate the twitter logo");
	}


	@When("Navigate to Twitter account")
	public void navigate_to_twitter_account()
	{
	   landingpageobj.click_OnTwitter();
	}
	
	@Then("Displayed the Twitter account name  {string}")
	public void displayed_the_twitter_account_name(String twitter_acc_name)
	{
		landingpageobj.validate_TwitAcc(twitter_acc_name);
	}
	
	
//------------------------------Subscribe Newslettermessage-----------------------------------------------
	
	@When("User entered the Email Id and click on Submit button")
	public void user_entered_the_email_id_and_click_on_submit_button()
	{
		landingpageobj.Validate_newsletterBox();
		landingpageobj.clickProc();
	}

	@Then("Validate the Subscritpion message {string}")
	public void validate_the_subscritpion_message(String message) 
	{
	   landingpageobj.validationMessage(message);
	}

	
}