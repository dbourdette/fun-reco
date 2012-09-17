package com.github.funreco.service

import com.github.funreco.domain.FacebookFriends
import com.github.funreco.domain.FacebookIdAndName
import com.github.funreco.domain.FacebookProfileRef
import com.google.code.morphia.query.Query
import com.google.code.morphia.Datastore

class FacebookFriendsService {
    Datastore datastore

    public List<FacebookProfileRef> findFriends(FacebookIdAndName profile) {
        FacebookFriends friends = queryForProfile(profile).get();

        return friends == null ? new ArrayList<FacebookProfileRef>() : friends.getFriends();
    }

    public void updateFriends(FacebookIdAndName profile, List<FacebookProfileRef> friends) {
        FacebookFriends dbFacebookFriends = queryForProfile(profile).get();
        FacebookFriends facebookFriends = FacebookFriends.fromProfileAndFriends(profile, friends);

        if (dbFacebookFriends != null) {
            facebookFriends.setId(dbFacebookFriends.getId());
        }

        datastore.save(facebookFriends);
    }

    private Query<FacebookFriends> queryForProfile(FacebookIdAndName profile) {
        return datastore.find(FacebookFriends.class).filter("profile.facebookId", profile.getFacebookId());
    }
}
