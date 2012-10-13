package com.github.funreco

import fun.reco.Profile
import org.junit.Test

class ProfileTests extends GroovyTestCase {

    @Test
	void save() {
		Profile profile = TestData.testProfile()

        profile.save()

		assert profile.id
		assert Profile.get(profile.id)
	}
}
