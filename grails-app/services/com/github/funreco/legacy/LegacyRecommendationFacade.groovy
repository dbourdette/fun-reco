package com.github.funreco.legacy

import com.github.funreco.Action
import com.github.funreco.Object
import com.github.funreco.Friend
import com.github.funreco.Profile
import com.github.funreco.Recommendation
import com.github.funreco.RecommendationFacade
import com.github.funreco.Recommendations
import com.github.funreco.RecommendedObject
import com.github.funreco.legacy.domain.FacebookProfile
import com.github.funreco.legacy.domain.FacebookProfileRef
import com.github.funreco.legacy.domain.recommandation.OpenGraphRecommendation
import com.github.funreco.legacy.engine.RecommendationEngine
import com.github.funreco.legacy.service.FacebookFriendsService
import com.github.funreco.legacy.service.FacebookProfileService
import com.github.funreco.legacy.service.OpenGraphActionService
import org.apache.commons.lang.StringUtils

class LegacyRecommendationFacade implements RecommendationFacade {
    RecommendationEngine recommendationEngine

    OpenGraphActionService openGraphActionService

    FacebookProfileService facebookProfileService

    FacebookFriendsService facebookFriendsService

    def updateProfile(Profile profile) {
         throw new UnsupportedOperationException("Won't be implemented")
    }

    Profile findProfile(String email, String facebookId) {
        FacebookProfile facebookProfile = null

        if (StringUtils.isNotEmpty(email)) {
            facebookProfile = facebookProfileService.findByEmail(email);
        }

        if (StringUtils.isNotEmpty(facebookId)) {
            facebookProfile = facebookProfileService.findByFacebookId(facebookId);
        }

        if (facebookProfile) {
            return fromFacebookProfile(facebookProfile)
        } else {
            return null
        }
    }

    def updateFriends(String facebookId, List<Friend> friends) {
        throw new UnsupportedOperationException("Won't be implemented")
    }

    List<Friend> findFriends(String facebookId) {
        return facebookFriendsService.findFriends(new FacebookProfile(facebookId: facebookId)).collect {
            new Friend(facebookId: it.facebookId, name: it.name)
        }
    }

    def pushAction(Action action) {
        throw new UnsupportedOperationException("Won't be implemented")
    }

    List<Action> findActions(int offset, int limit) {
        return openGraphActionService.find(offset, limit).collect {
            new Action(profile: fromFacebookProfileRef(it.profile), object: new Object(id: it.object.id, properties: it.object.properties))
        }
    }

    List<Action> findActions(String facebookId, int offset, int limit) {
        return openGraphActionService.findByProfile(new FacebookProfile(facebookId: facebookId), offset, limit).collect {
            new Action(profile: fromFacebookProfileRef(it.profile), object: new Object(id: it.object.id, properties: it.object.properties))
        }
    }

    int countActions() {
        return openGraphActionService.count()
    }

    Recommendations findDefaultRecommendations() {
        return fromOpenGraphRecommendation(recommendationEngine.findGenericRecommendation())
    }

    Recommendations findRecommendations(String facebookId) {
        Recommendations recommendations = fromOpenGraphRecommendation(recommendationEngine.findRecommendation(new FacebookProfile(facebookId: facebookId)))
        recommendations.profile = new Profile(facebookId: facebookId)

        return recommendations
    }

    private Profile fromFacebookProfile(FacebookProfile profile) {
        return new Profile(facebookId: profile.facebookId, email: profile.email, name: profile.name)
    }

    private Profile fromFacebookProfileRef(FacebookProfileRef profile) {
        return new Profile(facebookId: profile.facebookId, name: profile.name)
    }

    private Recommendations fromOpenGraphRecommendation(OpenGraphRecommendation openGraphRecommendation) {
        Recommendations recommendations = new Recommendations()

        openGraphRecommendation.entries.each {
            Recommendation recommendation = new Recommendation(query: it.query)

            it.objects.each {
                List<Friend> by = it.by.collect { new Friend(facebookId: it.facebookId, name: it.name) }

                recommendation.addObject(new RecommendedObject(object: new Object(id: it.id), by: by))
            }

            recommendations.addRecommendation(recommendation)
        }

        return recommendations
    }
}
