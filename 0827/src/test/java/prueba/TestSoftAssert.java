package prueba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssert {
	
	SoftAssert softAssert = new SoftAssert();
	
  @Test
  public void test1() {
	  
	  String exePath = "./src/test/resources/driver/chromedriver"; //En windows agregar .exe al final
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");
		driver.manage().window().maximize();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "My Store";
		String badTitle = "mystore";
		
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertEquals(actualTitle, badTitle);
		
		softAssert.assertAll();
		
  }
}
