package com.github.funreco

import com.github.funreco.domain.FacebookFriends
import com.github.funreco.domain.FacebookProfile
import com.github.funreco.domain.FacebookProfileRef
import com.github.funreco.domain.OpenGraphAction
import com.github.funreco.service.FacebookFriendsService
import com.github.funreco.service.FacebookProfileService
import com.github.funreco.service.RecommendationService
import com.google.code.morphia.Datastore
import com.google.code.morphia.query.Query
import org.apache.commons.lang.StringUtils
import org.bson.types.ObjectId

class ProfilesController {
    Datastore datastore

    FacebookProfileService facebookProfileService

    FacebookFriendsService facebookFriendsService

    RecommendationService recommendationService

    def index() {
        Query<FacebookProfile> query = datastore.find(FacebookProfile.class)

        if (params.query) {
            query = query.filter("email", params.query)
        }

        [
                'query': params.query,
                'count': datastore.find(FacebookProfile.class).countAll(),
                'items': query.limit(100).asList()
        ]
    }

    def save() {
        datastore.save(aProfile(params.email))

        redirect(action: 'index')
    }

    def generateProfiles() {
        (1..1000).each {
            datastore.save(aProfile('johndoe-' + UUID.randomUUID().toString() + '@funreco.fr'));
        }

        redirect(action: 'index')
    }

    def profile() {
        FacebookProfile profile = datastore.get(FacebookProfile.class, new ObjectId(params.id))

        [
                'profile': profile,
                'actions': datastore.find(OpenGraphAction.class).filter("profile.facebookId", profile.getFacebookId()).asList(),
                'friends': datastore.find(FacebookFriends.class).filter("profile.facebookId", profile.getFacebookId()).get(),
                'recommendations': recommendationService.findRecommendation(profile)
        ]
    }

    def generateFriends() {
        FacebookProfile profile = datastore.get(FacebookProfile.class, new ObjectId(params.id))

        List<FacebookProfileRef> friends = new ArrayList<FacebookProfileRef>();

        (1..100).each {
            friends.add(facebookProfileService.randomProfile().toRef())
        }

        facebookFriendsService.updateFriends(profile, friends)

        redirect(action: 'profile', id: params.id)
    }

    def buildRecommendations() {
        FacebookProfile profile = datastore.get(FacebookProfile.class, new ObjectId(params.id))

        recommendationService.buildRecommendations(profile)

        redirect(action: 'profile', id: params.id)
    }

    private void deletePreviousFriends(String facebookId) {
        datastore.delete(datastore.find(FacebookFriends.class).filter("profile.facebookId", facebookId))
    }

    private FacebookProfile aProfile(String email) {
        String name = StringUtils.substringBefore(email, "@");
        String id = String.valueOf(email.hashCode());

        try {
            return FacebookProfile.fromJson("{" +
                    "\"id\" : \"" + id + "\"," +
                    "\"email\" : \"" + email + "\"," +
                    "\"name\" : \"" + name + "\"" +
                    "}");
        } catch (IOException e) {
            throw new RuntimeException("Failed to create profile", e);
        }
    }
}
