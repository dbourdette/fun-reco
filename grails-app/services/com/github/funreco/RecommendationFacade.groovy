package com.github.funreco

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
