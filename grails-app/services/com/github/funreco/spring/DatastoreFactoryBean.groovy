package com.github.funreco.spring

import com.github.funreco.legacy.domain.FacebookFriends
import com.github.funreco.legacy.domain.FacebookProfile
import com.github.funreco.legacy.domain.OpenGraphAction
import com.github.funreco.legacy.domain.OpenGraphQuery
import com.github.funreco.legacy.domain.recommandation.OpenGraphRecommendation
import com.google.code.morphia.Datastore
import com.google.code.morphia.Morphia
import com.mongodb.Mongo
import org.springframework.beans.factory.FactoryBean

class DatastoreFactoryBean implements FactoryBean<Datastore> {
    Datastore getObject() {
        Mongo mongo = new Mongo();

        Morphia morphia = new Morphia()
        morphia.map(FacebookProfile.class);
        morphia.map(FacebookFriends.class);
        morphia.map(OpenGraphQuery.class);
        morphia.map(OpenGraphAction.class);
        morphia.map(OpenGraphRecommendation.class);

        return morphia.createDatastore(mongo, "fun-reco");
    }

    Class<?> getObjectType() {
        return Datastore.class;
    }

    boolean isSingleton() {
        return true;
    }
}
