package prueba;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		String exePath = "./src/test/resources/driver/chromedriver"; //En windows agregar .exe al final
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement searchBar = driver.findElement(By.id("search_query_top"));
		WebElement searchBtn = driver.findElement(By.xpath("(//*[@type = \"submit\"])[1]"));
		
		searchBar.sendKeys("Dress");
		searchBtn.click();
		
		//Metodos de explorador
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String urlsearch = driver.getCurrentUrl();
		System.out.println("La Url actual es: "+urlsearch);
		
		/*Metodos de navegacion
		Thread.sleep(2000);
		driver.navigate().back(); //da click en boton atras de navegador
		Thread.sleep(2000);
		driver.navigate().forward(); //da click en el boton adelante del navegador
		Thread.sleep(2000);
		driver.navigate().refresh(); //refresca la pagina
	    */
		
		//Verificar elemento desplegado en pagina
		boolean prodContainer = driver.findElement(By.className("product-container")).isDisplayed();
		if(prodContainer) {
			System.out.println("El articulo esta desplegado");
		}
		
		
		//Obtener Texto de webelement y comparar si es le correcto
		
		String prodName = driver.findElement(By.className("product-container")).getText();
		
		boolean prodNameContains = prodName.contains("Printed Summer Dress"); //El nativo de java compara 2 strings y regresa boleano
		if(prodNameContains) {
			System.out.println("El  nombre dle producto es correcto");
		}else {
			System.out.println("Error: el nombre del producto es incorrect");
		}
		
		//DropDown
		Select sortDrpDwn = new Select(driver.findElement(By.id("selectProductSort")));
		sortDrpDwn.selectByVisibleText("Price: Lowest first");
		//sortDrpDwn.selectByValue("price:asc");
		//sortDrpDwn.selectByIndex(2);
		
		//FindElements
		List<WebElement> prodList = driver.findElements(By.className("product-container"));
		System.out.println("Numero de elementos en productos" + prodList.size());
		
		String tercerProd = prodList.get(2).getText();
		System.out.println(tercerProd);
		
		for(int i = 0; i < prodList.size(); i++) {
			System.out.println("Los Productos son: " +prodList.get(i).getText());
			System.out.println();
			
			if(!prodList.get(i).getText().contains("Dress")) {
				System.out.println("El Producto no es un vestido");
			}
		}
		
		driver.quit();
	}

}
