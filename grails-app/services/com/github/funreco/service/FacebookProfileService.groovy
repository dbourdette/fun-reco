package com.github.funreco.service

import com.github.funreco.domain.FacebookProfile
import com.google.code.morphia.Datastore


class FacebookProfileService {
    Datastore datastore

    FacebookProfile randomProfile() {
        return datastore.find(FacebookProfile.class).skip(randomIndex()).limit(1).get();
    }

    int randomIndex() {
        return (int) new Random().nextInt((int) datastore.find(FacebookProfile.class).countAll());
    }
}
