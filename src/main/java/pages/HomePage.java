package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import utils.ConfigReader;

public class HomePage 
{
  WebDriver driver;
 ConfigReader config;
 Actions actions;
 WebDriverWait wait;
 
  
  @FindBy(xpath="//div[@class='header-logo']")
  private WebElement pageLogo;

  @FindBy(xpath="(//a[@href='/account/login'])[2]")
  private WebElement loginLink;
  
  @FindBy(id="CustomerEmail")
  private WebElement emailInputField;

  @FindBy(id="CustomerPassword")
  private WebElement passwordInputField;
  
  @FindBy(xpath="(//input[@type='submit'])[1]")
  private WebElement signinButton;
  
  @FindBy(linkText="Name Necklace")
  private WebElement nameNecklaceTab;
  
  @FindBy(xpath="//input[@placeholder='Search Our Store...']")
  private WebElement searchBar;

  @FindBy(linkText="Flower Name Necklace")
  private WebElement product;
  
  @FindBy(xpath="(//a[@href='/account/logout'])[2]")
  private WebElement logoutLink;
  
  public HomePage(WebDriver driver) throws IOException 
  {
	this.driver=driver;
      PageFactory.initElements(driver, this);
    config= new ConfigReader();
    actions = new Actions(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
  }
  
 public void verifyHomePage()
 {
	 Assert.assertTrue(pageLogo.isDisplayed());
	 System.out.println("Home page of the application is displayed");
 }

 public void clickLogin()
 {
	 wait.until((ExpectedConditions.visibilityOf(loginLink)));
	 Assert.assertTrue(loginLink.isDisplayed());
//	 JavascriptExecutor js = (JavascriptExecutor)driver;
//	 js.executeScript("arguments[0].scrollIntoView(true);",loginLink);
	
	 actions.moveToElement(loginLink).click().build().perform();
	
 }
 public void doLogin()
 {
	 wait.until((ExpectedConditions.visibilityOf(emailInputField)));
	 Assert.assertTrue(emailInputField.isDisplayed());
	 System.out.println("Email field is displayed");
	 String email = config.getProperty("username");
	emailInputField.sendKeys(email);
	System.out.println("Email address is entered in to the Email field");
	
	 wait.until((ExpectedConditions.visibilityOf(passwordInputField)));
	 Assert.assertTrue( passwordInputField.isDisplayed());
	 System.out.println("Password field is displayed");
	 String password= config.getProperty("password");
	 passwordInputField.sendKeys(password);
	 System.out.println("Password is entered in to the Password field");
	
	 Assert.assertTrue(signinButton.isDisplayed());
	 signinButton.click();
	 System.out.println("signin button is clicked");
	
 }
 
 public void searchProduct() throws InterruptedException
 {
	 wait.until((ExpectedConditions.visibilityOf(nameNecklaceTab)));
	 Assert.assertTrue( nameNecklaceTab.isDisplayed());
	 System.out.println("Name Necklace tab is displayed");
	 actions.moveToElement( nameNecklaceTab).click().build().perform();
	 System.out.println("Name Necklace tab is clicked");
	 
	 wait.until((ExpectedConditions.visibilityOf(searchBar)));
	 Assert.assertTrue( searchBar.isDisplayed());
	 System.out.println("search bar  is displayed");
	 
	 String input = "necklace";
	 searchBar.sendKeys(input);
	 searchBar.sendKeys(Keys.ENTER);
	 System.out.println(input+" is entered to the search bar");
	 
	 wait.until((ExpectedConditions.visibilityOf(product))); 
	 JavascriptExecutor js= (JavascriptExecutor)driver;
	 System.out.println("Name Necklace product is displayed");
	 js.executeScript("arguments[0].scrollIntoView(true);",product);
	 actions.moveToElement( product).click().build().perform();
	 System.out.println("Name Necklace product is clicked");
	 Thread.sleep(3000);
	}
 public void doLogout()
 {
	 wait.until((ExpectedConditions.visibilityOf(logoutLink)));
	 Assert.assertTrue( logoutLink.isDisplayed());
	 System.out.println("Logout link  is displayed");
	 logoutLink.click();
	 System.out.println("Logout link is clicked");
	 System.out.println("Successfully logged out from the application");
 }
}
