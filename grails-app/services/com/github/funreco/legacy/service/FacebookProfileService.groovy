package com.github.funreco.legacy.service

import com.github.funreco.legacy.domain.FacebookProfile
import com.google.code.morphia.Datastore


class FacebookProfileService {
    Datastore datastore

    public FacebookProfile findByEmail(String email) {
        return datastore.find(FacebookProfile.class).filter("email", email).get();
    }

    public FacebookProfile findByFacebookId(String facebookId) {
        return datastore.find(FacebookProfile.class).filter("facebookId", facebookId).get();
    }

    FacebookProfile randomProfile() {
        return datastore.find(FacebookProfile.class).skip(randomIndex()).limit(1).get();
    }

    int randomIndex() {
        return (int) new Random().nextInt((int) datastore.find(FacebookProfile.class).countAll());
    }
}
