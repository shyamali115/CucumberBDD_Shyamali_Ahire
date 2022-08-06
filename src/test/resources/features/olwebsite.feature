@ui @olwebsite
Feature: E-shopping Website

Background: Navigation to URL
Given Navigate to URL

@Redirect_URL
	Scenario: User able to see browser and redirect the URL
    When  Redirect the URL "http://automationpractice.com/index.php"
    Then  Result Page is displayed
    
    
 @Landingpage_title
		Scenario: User able to see browser ,Redirect the URL and Displayed the Landing Page Title     
		When 	Landing Page Title should be displayed 
		Then  Expected Landing Page Title should be "My Store" 
		
 @Validate_prodcategory
	Scenario: User able to see browser and displayed the product category with number
	 When User see the product category
	 Then Validate the product category and number of product to be dispalyed
	 
 @Display_logo
	Scenario: User able to see browser and landing page logo should be displayed
			When  User open the Landing page
			Then 	Landing page logo should be displayed
	
 @Validate_logoheight
	Scenario: User able to see browser and landing page logo height should be displayed
			When User open the landing page to validate logo height
			Then Landing page logo height should be "99"
	
@Validate_logowidth
	Scenario:  User able to see browser and landing page logo width should be displayed
	When User open the landing page to validate Logo width
	Then Landing page logo width should be "350" 
	
@Validate_signinpage_title
	Scenario: User is on landing page, click on signin button and validate the signin page with title
	When click on signin button
	Then Expected Signin page title should be "Login - My Store"   

@Search_product
	Scenario: User search for a product and number of product list should be displayed
	When User search for a product "Dress"
	Then Display the number of product list
	
@Validate_Twitter
	Scenario:  Validate Twitter Social Media Handle
	Given User click on Twitter link
  When Navigate to Twitter account
  Then Displayed the Twitter account name  "Selenium Framework"		
  
 @Subscribe_Newsletter
 Scenario: User enter the email id and validate the subscription message
   When User entered the Email Id and click on Submit button
   Then Validate the Subscritpion message "Newsletter : You have successfully subscribed to this newsletter"	 	 
	