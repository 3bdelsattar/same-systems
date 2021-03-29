package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class linkedinElements {
	public AppiumDriver<AndroidElement> driver = null;

	public linkedinElements(AppiumDriver<AndroidElement> driver2) 
	{
		this.driver = driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
	}
	
	//search bar 
	@AndroidFindBy(id = "com.linkedin.android:id/search_bar_text")
	public AndroidElement search_bar ;
	
	//search bar after clicking on it 
	@AndroidFindBy(id = "com.linkedin.android:id/search_bar_edit_text")
	public AndroidElement editSearchBar ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/search_typeahead_see_all_button")
	public AndroidElement seeAllResults ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/search_results_hero_entity_title")
	public AndroidElement NameOnFirstCard ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/search_results_hero_entity_container")
	public AndroidElement firstSearchCard ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/profile_view_recent_activity_redesign_see_all_activity")
	public AndroidElement SeeAllActivities ;
	
	// the posts tab 
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@index='2']")
	public AndroidElement postsTab ;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	public AndroidElement thePost ;
	
	//reations count
	@AndroidFindBy(id = "com.linkedin.android:id/feed_conversations_reactions_count")
	public AndroidElement reactionCount ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/feed_social_actions_like")
	public AndroidElement likebtn  ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/profile_view_about_card_title")
	public AndroidElement aboutTitle  ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/feed_render_item_text")
	public AndroidElement feedPostText  ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/feed_item_update_card")
	public AndroidElement postCard  ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/feed_render_item_text")
	public AndroidElement textInsidePost  ;
	
	@AndroidFindBy(id = "android:id/text1")
	public AndroidElement like  ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/reactions_rollup_items")
	public AndroidElement reactions ;
	
	@AndroidFindBy(id = "com.linkedin.android:id/conversations_reaction_row_actor_name")
	public AndroidElement myaccountname   ;
}
