import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Base;
import pages.HomePage;

@Listeners(utils.ExtentListener.class)
public class ProductSearchTest extends Base
{
	 @Test
	    public void testProductSearch() throws IOException, InterruptedException
	         {
	        test = extent.createTest("BlueSwiftTest");

	           HomePage home = new HomePage(driver);
	       home.verifyHomePage();
	       home.clickLogin();
	       home.doLogin();
	       home.searchProduct();
	       home.doLogout();
	       
	        }
}
