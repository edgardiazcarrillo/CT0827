package prueba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssert {
  @Test
  public void verificarTitutloDePagina() {
	  String exePath = "./src/test/resources/driver/chromedriver"; //En windows agregar .exe al final
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");
		driver.manage().window().maximize();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "My Store";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
}
