package com.github.funreco.legacy.service

import com.github.funreco.legacy.domain.OpenGraphQuery
import com.google.code.morphia.Datastore
import org.bson.types.ObjectId
import com.google.code.morphia.query.Query
import com.google.code.morphia.query.UpdateOperations

class OpenGraphQueryService {
    private Datastore communityDatastore

    public List<OpenGraphQuery> findAll() {
        return communityDatastore.find(OpenGraphQuery.class).asList();
    }

    public void save(com.github.funreco.legacy.domain.query.Query query) {
        Query<OpenGraphQuery> dbQuery = communityDatastore.find(OpenGraphQuery.class).filter("queryLiteral", query.toString());
        UpdateOperations<OpenGraphQuery> ops = communityDatastore.createUpdateOperations(OpenGraphQuery.class).set("query", query).set("lastUsage", new Date());

        communityDatastore.update(dbQuery, ops, true);
    }

    public void delete(String id) {
        communityDatastore.delete(OpenGraphQuery.class, new ObjectId(id));
    }

    void setCommunityDatastore(Datastore communityDatastore) {
        this.communityDatastore = communityDatastore
    }
}
