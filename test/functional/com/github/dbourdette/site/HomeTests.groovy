package com.github.dbourdette.site

import geb.junit4.GebReportingTest
import org.junit.Test

class HomeTests extends GebReportingTest {

	@Test
	void hasRecommandationsAndActionsOnHomePageTest() {
		to HomePage
		assert findRecommandations.size()
		assert findActions.size()
	}

	@Test
	void hasActionsOnActionsPageTest() {
		to HomePage
        viewAllActionsButton.click()
		assert at(ActionsPage)
		assert findAllActions.size()
	}

	@Test
	void checkProfileTest() {
		to HomePage
		findFirstProfileLink().click()
        println currentProfile()
        assert currentProfile().contains("Profile{email=")
	}
}
