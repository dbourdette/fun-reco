import geb.junit4.GebReportingTest
import pages.*
import org.junit.Test

class AuthentificationTests extends GebReportingTest {

	
	@Test
	void ActionPageTest() {
		
		to ActionPage
		assert at(LoginPage)
		loginForm.j_username << 'admin'
		loginForm.j_password << 'admin'
		loginButton.click()
		assert at (ActionPage)

	}
	
	@Test
	void ProfilePageTest() {
		to ProfilePage
		assert at (LoginPage)
		loginForm.j_username << 'admin'
		loginForm.j_password << 'admin'
		loginButton.click()
		to ProfilePage
		at ProfilePage

	}
}
