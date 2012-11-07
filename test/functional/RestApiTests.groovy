import geb.junit4.GebReportingTest
import com.github.dbourdette.pages.api.*
import org.junit.Test

class RestApiTests extends GebReportingTest {

	
	@Test
	void ActionPageTest() {
		
		to ActionPage
		assert at(ActionPage)

	}
	
	@Test
	void ProfilePageTest() {
		to ProfilePage
		assert at(ProfilePage)	
	}
	
	@Test
	void FriendPageTest() {
		to FriendPage
		assert at(FriendPage)
	}
}
