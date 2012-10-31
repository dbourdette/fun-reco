package com.github.dbourdette.api

import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.Friend;
import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.Recommendations;

interface RecommendationFacade {
    def updateProfile(Profile profile);

    Profile findProfile(String email, String facebookId);

    def updateFriends(String facebookId, List<Friend> friends);

    List<Friend> findFriends(String facebookId);

    def pushAction(Action action);

    List<Action> findActions(int offset, int limit);

    List<Action> findActions(String facebookId, int offset, int limit);

    int countActions();

    Recommendations findDefaultRecommendations();

    Recommendations findRecommendations(String facebookId);
}
