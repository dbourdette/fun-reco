package com.github.funreco.service

import com.github.funreco.domain.OpenGraphQuery
import com.google.code.morphia.Datastore
import com.google.code.morphia.query.Query
import com.google.code.morphia.query.UpdateOperations
import org.bson.types.ObjectId

class OpenGraphQueryService {
    Datastore datastore

    public List<OpenGraphQuery> findAll() {
        return datastore.find(OpenGraphQuery.class).asList()
    }

    public void add(String query) {
        Query<OpenGraphQuery> dbQuery = datastore.find(OpenGraphQuery.class).filter("query", query);
        UpdateOperations<OpenGraphQuery> ops = datastore.createUpdateOperations(OpenGraphQuery.class).set("lastUsage", new Date());

        datastore.update(dbQuery, ops, true)
    }

    public void delete(String id) {
        datastore.delete(OpenGraphQuery.class, new ObjectId(id));
    }
}
