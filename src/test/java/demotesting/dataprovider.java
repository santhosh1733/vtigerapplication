package demotesting;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutiity.ExecelSheetUtility;

public class dataprovider {

	@Test(dataProvider = "dataprovider")
	public  void getproductinfo(String brand, String productname) throws EncryptedDocumentException, IOException {
		WebDriver driver=null;
			 driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.findElement(By.className("Pke_EE")).sendKeys(brand,Keys.ENTER);
			String x = "//div[text()='"+productname+"']/../..//div[@class='Nx9bqj _4b5DiR']";
			WebElement text = driver.findElement(By.xpath(x));
			
			System.out.println(productname+"<====>"+text.getText());
			
			driver.quit();
	}
	
	
	
	@DataProvider
	public Object [][]  dataprovider() throws EncryptedDocumentException, IOException {
		ExecelSheetUtility excel=new ExecelSheetUtility();
	    int row = excel.getLastRow("productname");
	    int cell = excel.getLastCell("productname", row);
		return excel.readMultipleDataFromExcel("productname", row, cell);
		
	}
	
}
