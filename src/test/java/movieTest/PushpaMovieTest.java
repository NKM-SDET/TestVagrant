package movieTest;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ImdbPage;
import pages.WikiPage;

public class PushpaMovieTest extends BaseTest {
	
	WikiPage wiki;
	ImdbPage imdb;
	public PushpaMovieTest() {
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() 
	{
		
		initialization();
		wiki=new WikiPage();
				
	}
	
	@Test(priority=1)
	public void releaseDateTest() {
		String ws=wiki.validateWikiReleaseDate();
		imdb=wiki.invokeImdbPage();
		String is=imdb.ValidateImdbReleaseDate();
		Assert.assertEquals(is,ws);
		
	}
	@Test(priority=2)
	public void CountryOfOriginTest() {
		String wc=wiki.validateWikiCountry();
	    imdb=wiki.invokeImdbPage();
		String ic=imdb.ValidateImdbCountry();
		Assert.assertEquals(wc,ic);
	}
	@AfterMethod
	public void closeTest() {
		BaseTest.tearDown();
	}

}
