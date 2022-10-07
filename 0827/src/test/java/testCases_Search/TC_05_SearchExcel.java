package testCases_Search;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonClasses.DriverSetup;
import commonClasses.GlobalVariables;
import commonClasses.WrapClass;
import navigationPages.HomePage;
import navigationPages.SearchResultsPage;

public class TC_05_SearchExcel {

	//Declarar e inicializar el webdriver
		WebDriver driver = DriverSetup.setupDriver();
		
		//PageObjects
		HomePage homePage = new HomePage(driver);
		SearchResultsPage searchpage = new SearchResultsPage(driver);
		
		@BeforeTest
		public void startWebDriver() {
			driver.get(GlobalVariables.HOME_PAGE);
		}
		
		
		@Test
	  public void TC_05() {
			String searchCriteria = WrapClass.getCellData("TC_05", 1, 0);
			homePage.search(searchCriteria);
			boolean visibleText =  searchpage.getPrdText("Dress");
			Assert.assertTrue(visibleText,"El text DRESS no esta desplegado");
	  }
		
		
		@AfterTest
		public void closeDriver() {
			WrapClass.takeScreenshoot(driver, "TC_04");
			driver.quit();
		}
}
