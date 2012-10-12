package com.github.funreco

import fun.reco.Profile
import fun.reco.Object

/**
 * @author damien bourdette
 */
class TestData {
    static Profile testProfile() {
        new Profile(facebookId: "testFB", email: "testEmail", name: "testName", friendsList: testFriends())
    }

    static testFriends() {
        ["testId1", "testId2"]
    }

    static testObject(properties) {
        new Object(objectId: "testObjectId", properties: properties)
    }
}
