package com.github.funreco.service

import com.github.funreco.domain.FacebookIdAndName
import com.github.funreco.domain.OpenGraphAction
import com.github.funreco.engine.OpenGraphActionStats
import com.google.code.morphia.Datastore
import com.google.code.morphia.query.Query
import org.joda.time.Interval

class OpenGraphActionService {
    Datastore datastore

    public void save(OpenGraphAction action) {
        datastore.save(action);
    }

    public OpenGraphActionStats findStats(Interval interval) {
        Query<OpenGraphAction> query = datastore.find(OpenGraphAction.class)
                .filter("date >=", interval.getStart().toDate())
                .filter("date <", interval.getEnd().toDate());

        return OpenGraphActionStats.fromActions(query);
    }

    public List<OpenGraphAction> findLatests(int recordCount) {
        return datastore.find(OpenGraphAction.class).limit(recordCount).order("-date").asList();
    }

    public List<OpenGraphAction> findLatestsByProfile(FacebookIdAndName profile) {
        return datastore.find(OpenGraphAction.class).limit(100)
                .filter("profile.facebookId", profile.getFacebookId()).order("-date").asList();
    }
}
