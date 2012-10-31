package com.github.dbourdette.ecm

/**
 * @author damien bourdette
 */
class TestData {
    static Profile testProfile() {
        new Profile(facebookId: "testFB", email: "testEmail", name: "testName", friendsIds: testFriends())
    }

    static testFriends() {
        ["testId1", "testId2"]
    }

    static testObject(properties) {
        new Object(objectId: "testObjectId", properties: properties)
    }
	
	static testAction() {
		new Action(profile: testProfile(), object: testObject(['type':['video', 'show']]), date: new Date())
	}
}
