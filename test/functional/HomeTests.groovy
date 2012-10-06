import geb.junit4.GebReportingTest
import pages.*
import org.junit.Test

class HomeTests extends GebReportingTest{
	
	@Test
	void recommandationAndActionTest()
	{
		To HomePage
		assert  findRecommandation.size() != 0
		assert findAction.size()!= 0 
	}
	@Test
	void viewAllTest()
	{
		
	}
	@Test
	void profileTest()
	{
		
	}

}
