package com.github.funreco.legacy.bootstrap

import com.google.code.morphia.Datastore
import com.mongodb.BasicDBObject
import com.mongodb.Mongo

class BootstrapDB {
    Datastore datastore;

    def reset() {
        new File("scripts").eachFile {
           if (it.name.endsWith(".json")) {
               resetCollection(it.name.replaceAll('.json', ''))
           }
        }
    }

    def resetCollection(String name) {
        new Mongo().getDB("fun-reco").getCollection(name).remove(new BasicDBObject());

        File file = new File("scripts/${name}.json")

        "mongoimport -d fun-reco -c ${name} ${file.absolutePath}".execute()
    }
}
