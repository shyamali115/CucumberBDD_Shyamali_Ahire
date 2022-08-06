package com.BDD.automation.runners.pageobj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BDD.automation.core.WebDriverFactory;

import io.cucumber.java.Scenario;

public class LandingPageObj 
{
	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	 WebDriverWait webDriverWait;
	
	//String expcurrent_url= "http://automationpractice.com/index.php";
	String expsigninpage_Title = "Login - My Store";
	
	//private By SigninBtn= By.xpath("//a[@class='login']");
	private By TwitterAcc_name=By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wbh5a2']//preceding-sibling::div[1]/child::div[1]/child::div[1]/span/span");

	
	private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(WebDriverFactory.class);
	

	
	public LandingPageObj(WebDriver driver,Scenario scn)
	{
		this.driver=driver;
		this.scn=scn;
	}
	
//--------------------------------------------------------------------
	public void validate_pageurl(String expcurrent_url)
	{
		wait= new WebDriverWait(driver,20);
		boolean a = wait.until(ExpectedConditions.urlToBe(expcurrent_url));
		Assert.assertEquals(true,a);
	}
	
	
//--------------------------------------------------------------
	public void validate_pagetitle(String landingpage_title)
	{
		String actualpage_title=driver.getTitle();
		Assert.assertEquals(landingpage_title,actualpage_title);
				
	}
	
		
//----------------------------------------------------------------	
	public void display_ProdCatagory()
	{
		ArrayList<String> expectedprodcat_list=new ArrayList<>();
		expectedprodcat_list.add("WOMEN");
		expectedprodcat_list.add("DRESSES");
		expectedprodcat_list.add("T-SHIRTS");
		
	    List<WebElement> productcategorylist=driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li"));
	    
	    for(int i=0;i<productcategorylist.size();i++)
	    {
	    	
	    	Assert.assertEquals(expectedprodcat_list.get(i),productcategorylist.get(i).getText());
	    	scn.log((i+1)+ " Product catagories are displayed :"+ expectedprodcat_list.get(i));
	    	logger.info("All product catagories are displayed");
	    }
	    int actualCount = productcategorylist.size();
	    scn.log("Number of product list : " +actualCount);
	}
	
//------------------------------------------------------------------
	
	
	    public void display_logo()
	    {
	    	WebElement landingpage_logo =driver.findElement( By.xpath("//div[@id='header_logo']/a/img[@alt='My Store']"));
	    	Assert.assertEquals(true, landingpage_logo.isDisplayed());
	    	
	    }

//--------------------------------------------------------------
	    
	    
	    public void getatt_logoheight()
	    {
	    	WebElement logo =driver.findElement(By.xpath("//div[@id='header_logo']/a/img[@alt='My Store']"));
	    	String logoHeight= logo.getAttribute("height");
	    	logger.info("Height of logo is: "+ logoHeight);
	    	scn.log("Height of logo is: "+ logoHeight);
	    }
	    
	    public void validate_logoHeight(String logo_height)
	    {
	    	WebElement logo =driver.findElement(By.xpath("//div[@id='header_logo']/a/img[@alt='My Store']"));
	    	Assert.assertEquals(logo_height, logo.getAttribute("height"));
	    
	    }
	
//------------------------------------------------------------------	  
	    
	    
	    public void getatt_logowidth()
	    {
	    	WebElement logo =driver.findElement(By.xpath("//div[@id='header_logo']/a/img[@alt='My Store']"));
	    	String logoWidth= logo.getAttribute("width");
	    //	logger.info("Width of logo is: "+ logoWidth);
		   	scn.log("Width of logo is: "+ logoWidth);
	    }
	    
	    public void validate_logowidth(String logo_width)
	    {
	    	WebElement logo =driver.findElement(By.xpath("//div[@id='header_logo']/a/img[@alt='My Store']"));
	    	Assert.assertEquals(logo_width, logo.getAttribute("width"));
	    
	    }
	    
	    
//-------------------------Validate Sign in Page Title-----------------------------------------
	  
	    public void clickon_signinbtn()
	    {
	    	
	    	WebElement signIn = driver.findElement(By.xpath("//a[@class='login']")); 
	    	webDriverWait = new WebDriverWait(driver, 30);
	    	
	    	scn.log("Sign-in button: " + signIn.getText() );
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", signIn);
	    	try {
	    	Thread.sleep(4000);
	    	} catch (Exception e) {}
	    	scn.log("Clicked on sign in button");
	    //	log.info("Click on sign in button");
			
		}
		
	/*    public static void switchBrowserToTab()
	    {
	        WebDriverWait wait = new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	       
	        Set<String> handles = driver.getWindowHandles(); // get all the open windows
	        logger.info("List of windows found: "+handles.size());
	        logger.info("Windows handles: " + handles.toString());
	        Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
	        String original = it.next();//gives the parent window id
	        String nextTab = it.next();//gives the child window id
	        driver.switchTo().window(nextTab); // switch to product Descp
	        logger.info("Switched to the new window/tab");
	    }*/
	    
	   public void  validate_signinpage_title(String exp_signinpage_Title)
	   {
		 //  scn.log("Expected Page Title: " + exp_signinpage_Title);
		   String act_pagetitle = driver.getTitle();
		   
		 //  scn.log("Actual Page Title: " + act_pagetitle );
		   
		   Assert.assertEquals(act_pagetitle,exp_signinpage_Title);
		   scn.log("Sign in page title is :" + exp_signinpage_Title);
	   }
	   
	   
//-------------------------------Search product----------------------------------------------	    
	 
	   public void user_searchprod(String Prod_name) throws InterruptedException
	   {
	   
	   WebElement search_textbox = driver.findElement(By.xpath("//input[@name='search_query']"));
	   	
		Assert.assertEquals(true, search_textbox.isEnabled());
		
		search_textbox.sendKeys(Prod_name);
		
		Thread.sleep(6000);

		System.out.println("Product list is  :");

		List<WebElement> SearchProd_list = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
		
		scn.log("Search list is :");
		int i;
		for ( i = 0; i < SearchProd_list.size(); i++)
		{
			if (SearchProd_list.get(i).getText().contains(Prod_name))
			{
				System.out.println((i+1) + " " + SearchProd_list.get(i).getText());
			}
			
		}
		scn.log("Actual product list count is : "+i);
	}
	    
	    
//-------------------------Validate The Twitter Acc Name-----------------------------------------------
	   
	   public void view_TwitterLink()
	    {
	    	//WebElement twitter_link_ele =driver.findElement(By.xpath("//li[@class='twitter']"));
	    
	    //	JavascriptExecutor js= (JavascriptExecutor)driver;
		//	js.executeScript("arguments[0].scrollIntoView(true);", twitter_link_ele);
			
	    	// twitter_link_ele.click();
	  	  //  scn.log("Validate the twitter logo");
	  	   	
	    	//logger.info("Validate the twitter link");
	    }
	   
	   public void click_OnTwitter()
	    {
	    	WebElement twitter_link = driver.findElement(By.xpath("//li[@class='twitter']"));
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView(true);", twitter_link);
	    	
	    	Assert.assertEquals(true, twitter_link.isDisplayed());
	    	
	    	scn.log("Twitter link is displayed successfully.");
	  //  	log.info("Twitter link is displayed successfully.");
	    	twitter_link.click();	
	    }
	   
	   public void validate_TwitAcc(String twitter_accname)
	    {
			
			 Set<String> handles = driver.getWindowHandles(); // get all the open windows
		     Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
		  //   String landingpage = it.next();//gives the parent window id
		     String twiterpage = it.next();
		     driver.switchTo().window(twiterpage);
		   // logger.info("Window switched to twitter page");
		    
		    WebElement TwitterAccountElement=driver.findElement(TwitterAcc_name);
		  //  logger.info("Created WebElement for Twitter Account name");
		    Assert.assertEquals("Selenium Framework", TwitterAccountElement.getText());
		    scn.log("Twitter Account name is :" + TwitterAccountElement.getText() );
		   // logger.info("Twitter Account name is :" + TwitterAccountElement.getText());
	    }
	    
	   
//--------------------------------- Subscribe_Newsletter Message------------------------------------------------------
	   
	   
	   public String randomStringGenerator()
		{
			Random rand = new Random();
			char s;
			String randomName ="";
			
			for(int i = 0; i < 10; i++) {
				s =  (char)(rand.nextInt(26)+97);
				randomName += s;
				}
			
			randomName=randomName+"@gmail.com";
			return randomName;
		}
	   
	   public void Validate_newsletterBox()
	   {
		   By newsIdEle = By.id("newsletter_block_left");
		   scn.log("Random String : "+randomStringGenerator());
		   
		   WebElement twitterId = driver.findElement(newsIdEle);
	       Assert.assertEquals(true, twitterId.isDisplayed());
			
			 WebElement emailId = driver.findElement(By.id("newsletter-input"));
		       emailId.sendKeys(randomStringGenerator());
		       scn.log("user is entered in subscription box successfully");
		}

	   public void clickProc()
	   {
		   By procBtnEle = By.name("submitNewsletter");
		   
		   WebElement proceedBtn = driver.findElement(procBtnEle);
	       proceedBtn.click();
	       scn.log("clicked on proceed button successful." + procBtnEle);
	       try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //   log.info("Click on proceed button successful.");       
	   }
	   
	   public void validationMessage(String ExpMsg)
	   {
		   By subscriSussMagEle = By.xpath("//div[@class='clearfix']/following-sibling::p[@class='alert alert-success']");
		   scn.log("Msg : " + subscriSussMagEle );
		   
		   try 
			{
				WebElement subscriSussMag = driver.findElement(subscriSussMagEle);
				scn.log("Validate Sucessfully message for subscription is: "+ subscriSussMag.getText());
				Assert.assertEquals("Success Massage Not Match",true, subscriSussMag.getText().contains(ExpMsg));
			
				//log.info("Validate Sucessfully message for subscription is: "+ subscriSussMag.getText());
				scn.log("Validate Sucessfully message for subscription is: "+ subscriSussMag.getText());
			} 
			catch(Exception e)
			{
				scn.log("failed : "+e);
			
			}
	   }
	}

