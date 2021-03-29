package testSuites;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.RealDevice;
import pages.linkedinElements;


public class openThePostTest extends BaseTest{
	int	count = 0; 

	@BeforeSuite
	public void setup() throws Throwable
	{
		driver = new RealDevice();
		linkeElement = new linkedinElements(driver.driver);


	}

	@Test( priority = 1)
	public void ClickOnSearchbar() {
		linkeElement.search_bar.click();


		//make sure search bar edit is opened 
		assertTrue(linkeElement.editSearchBar.isDisplayed());
	}


	@Test( priority = 2)
	public void searchForText() {
		linkeElement.editSearchBar.sendKeys("hossam youssof");
		linkeElement.seeAllResults.click();

		//make sure i found right account 
		assertEquals(linkeElement.NameOnFirstCard.getText(), "Hossam Youssof");
	}


	@Test( priority = 3)
	public void openProfile() {
		linkeElement.NameOnFirstCard.click();

		//make sure profile is opened 
		assertTrue(linkeElement.aboutTitle.isDisplayed());

	}


	@Test( priority = 4)
	public void seeAllActivities() {
		scrollDown();

		linkeElement.SeeAllActivities.click();
		//make sure see all activities is opened 
		assertTrue(linkeElement.postsTab.isDisplayed());

		linkeElement.postsTab.click();

	}

	@Test( priority = 5)
	public void chooseThePost() throws InterruptedException {

		waitForPresence(driver.driver, 2, linkeElement.postCard); 

		scroll(0, 2225, 0, 574);
		scrollDown();
		linkeElement.thePost.click();

		linkeElement.textInsidePost.click();

		//make sure see all activities is opened 
		assertTrue(linkeElement.feedPostText.isDisplayed());

	}

	@Test( priority = 6)
	public void checkLikedCount() {
		assertTrue(linkeElement.reactionCount.isDisplayed());
		count = Integer.parseInt(linkeElement.reactionCount.getText()); 

	}

	@Test( priority = 6)
	public void clickonLike() {
		linkeElement.likebtn.click();
		
		assertEquals(Integer.parseInt(linkeElement.reactionCount.getText()), count+1);
		
		scrollDown();
		linkeElement.reactions.click();
		
		assertEquals(linkeElement.myaccountname.getText(), "Mohamed Abdelsattar");
	}
	
	
}
