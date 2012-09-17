package com.github.funreco.service

import com.github.funreco.domain.OpenGraphQuery
import com.google.code.morphia.Datastore
import org.bson.types.ObjectId

class OpenGraphQueryService {
    private Datastore communityDatastore

    public List<OpenGraphQuery> findAll() {
        return communityDatastore.find(OpenGraphQuery.class).asList()
    }

    public void save(com.github.funreco.domain.query.Query query) {
        OpenGraphQuery openGraphQuery = communityDatastore.find(OpenGraphQuery.class).filter("queryLiteral", query.toString()).get();

        if (openGraphQuery == null) {
            openGraphQuery = new OpenGraphQuery();
            openGraphQuery.setQuery(query);
        }

        openGraphQuery.setLastUsage(new Date());

        communityDatastore.save(openGraphQuery)
    }

    public void delete(String id) {
        communityDatastore.delete(OpenGraphQuery.class, new ObjectId(id));
    }

    void setCommunityDatastore(Datastore communityDatastore) {
        this.communityDatastore = communityDatastore
    }
}
