import geb.junit4.GebReportingTest
import pages.*
import org.junit.Test

class HomeTests extends GebReportingTest{

	@Test
	void recommandationAndActionTest() {
		to HomePage
		assert findRecommandation != 0
		assert findActions != 0
	}
	@Test
	void viewAllTest() {
		to HomePage
		viewAllButton.click()
		assert at(ActionsPage)
		assert findAllAction !=0
	}
	@Test
	void profileTest() {
	}
}
