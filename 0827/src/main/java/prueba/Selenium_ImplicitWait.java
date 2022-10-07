package prueba;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_ImplicitWait {

	public static void main(String[] args) {
		String exePath = "./src/test/resources/driver/chromedriver"; //En windows agregar .exe al final
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");
		driver.manage().window().maximize();
		
		
		//ImplicitWait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement searchbar = driver.findElement(By.id("search_query_top")); //Encuentra Elemento.
		WebElement searchbarNo = driver.findElement(By.id("search_query__top")); //Espera los sergundos hasta encontrar elemento, como elemento no existe manda NoSuchElementExeption
		
	}
}
