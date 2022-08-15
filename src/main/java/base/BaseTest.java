package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static  WebDriver driver;
	public static  Properties prop;
	public  BaseTest() 
	{
		try 
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Nira\\eclipse-workspace\\TestVagrant1\\src\\main\\java\\config\\Properties");
			prop.load(ip);
		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void initialization() 
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.safaridriver().setup();
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitWait"))));
	
	}
	
	public static void tearDown() {
		driver.quit();
	}

}
