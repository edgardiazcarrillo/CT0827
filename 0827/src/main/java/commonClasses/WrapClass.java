package commonClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class WrapClass {
	
	public static void click(WebElement webE) {
		webE.click();	
	}
	
	public static void sendKeys(WebElement webSendKeys, String textTosend) {
		webSendKeys.sendKeys(textTosend);
	}

	public static String gettext(WebElement webE) {
		return webE.getText();
	}
	
	public static void takeScreenshoot(WebDriver webdriver, String testCaseName) {
		//Tomar Screenshot
		File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		
		//Establecer ruta donde se guarda el screenshot              ESTO HACE QUE SE CREE EL SCREENSHOT Con tiempo para que no se reemplazen los screenshots
		String screenshotPath = "./test-output/ExecutionResults" + System.currentTimeMillis();
		
		//crear el durectorio donde se guarda el screen en caso de que no exista
		FileHandler.createDir(new File(screenshotPath));
		try {
			FileHandler.copy(scrFile, new File(screenshotPath + File.separator + testCaseName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getJsonValue(String jsonFileObj,String jsonKey) {
		try {
		//JSON DATA
		InputStream inputStream = new FileInputStream(GlobalVariables.DATA_PATH + jsonFileObj + ".json");
		JSONObject jsonObject = new  JSONObject(new JSONTokener(inputStream));
		
		//Get Data
		String jsonValue= jsonObject.getJSONObject(jsonFileObj).getString(jsonKey);
		return jsonValue;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String getCellData(String excelName, int row, int column) {
		//Reading Data
		try {
			FileInputStream fis = new FileInputStream(GlobalVariables.DATA_PATH + excelName + ".xlsx");
			
			//Construir un objeto de excel
			
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
