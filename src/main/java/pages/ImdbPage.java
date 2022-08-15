package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class ImdbPage extends BaseTest {
	
	@FindBy(xpath="//ul//a[text()='Release date']/..//div")
	private WebElement imdbReleaseDate;
	
	
	@FindBy(xpath="//ul//span[text()='Country of origin']/following-sibling::div")
	private WebElement imdbCountry;
	
	public ImdbPage() {
		driver.get(prop.getProperty("urlImdb"));
		PageFactory.initElements(driver, this);
		
	}
	
	public String ValidateImdbReleaseDate() {
	
		String releaseDateImdb=imdbReleaseDate.getText();
		String[] str=releaseDateImdb.split(" ");
	    String[] dates=str[1].split(",");
	    String releaseDate=dates[0]+" "+str[0]+" "+str[2] ;
	    return releaseDate;
						
	}
	
	public String ValidateImdbCountry() {
	
		return imdbCountry.getText();
	}
	

}
