package com.github.funreco.service

import com.github.funreco.domain.OpenGraphQuery
import com.github.funreco.domain.query.Query
import com.google.code.morphia.Datastore
import org.bson.types.ObjectId

class OpenGraphQueryService {
    Datastore datastore

    public List<OpenGraphQuery> findAll() {
        return datastore.find(OpenGraphQuery.class).asList()
    }

    public void save(Query query) {
        OpenGraphQuery openGraphQuery = datastore.find(OpenGraphQuery.class).filter("queryLiteral", query.toString()).get();

        if (openGraphQuery == null) {
            openGraphQuery = new OpenGraphQuery();
            openGraphQuery.setQuery(query);
        }

        openGraphQuery.setLastUsage(new Date());

        datastore.save(openGraphQuery)
    }

    public void delete(String id) {
        datastore.delete(OpenGraphQuery.class, new ObjectId(id));
    }
}
