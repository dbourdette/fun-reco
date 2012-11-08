package com.github.dbourdette.rest

import geb.junit4.GebReportingTest
import org.junit.Test

class RestApiTests extends GebReportingTest {

	@Test
	void ActionPageTest() {
		to ActionPage
		assert at(ActionPage)
	}
	
	@Test
	void ProfilePageTest() {
        browser.drive {
            go "http://admin:admin@localhost:8080/api/profile/1"

            println driver.pageSource
        }
	}
	
	@Test
	void FriendPageTest() {
		to FriendPage
		assert at(FriendPage)
	}
}
