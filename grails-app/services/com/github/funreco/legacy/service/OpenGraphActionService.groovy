package com.github.funreco.legacy.service

import com.github.funreco.legacy.domain.FacebookIdAndName
import com.github.funreco.legacy.domain.OpenGraphAction
import com.github.funreco.legacy.engine.OpenGraphActionStats
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

    public int count() {
        return datastore.find(OpenGraphAction.class).countAll();
    }

    public List<OpenGraphAction> find(int offset, int recordCount) {
        return datastore.find(OpenGraphAction.class).skip(offset).limit(recordCount).order("-date").asList();
    }

    public List<OpenGraphAction> findByProfile(FacebookIdAndName profile, int offset, int limit) {
        return datastore.find(OpenGraphAction.class).skip(offset).limit(limit)
                .filter("profile.facebookId", profile.getFacebookId()).order("-date").asList();
    }
}
