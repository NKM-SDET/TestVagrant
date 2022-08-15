package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class WikiPage extends BaseTest {
	
	
	@FindBy(xpath="//table[@class='infobox vevent']//div[text()='Release date']/../following-sibling::td")
	private WebElement releaseDateWiki;
	
	@FindBy(xpath="//table[@class='infobox vevent']//th[text()='Country']/following-sibling::td")
	private WebElement contryWiki;
	
	public WikiPage() {
		driver.get(prop.getProperty("urlWiki"));
		PageFactory.initElements(driver,this);
		
	}
	
	public String validateWikiReleaseDate() {
		
		return releaseDateWiki.getText();
	}
	
	public String validateWikiCountry() {
		
		return contryWiki.getText();
	}
	
	

	public ImdbPage invokeImdbPage() {
		// TODO Auto-generated method stub
		return new ImdbPage();
	}

}
