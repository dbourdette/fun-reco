package com.github.funreco

import com.github.funreco.domain.OpenGraphAction
import com.google.code.morphia.Datastore
import com.google.code.morphia.query.Query

class ActionsController {
	
	Datastore datastore

    def index() {
        int offset = params.offset ? params.int("offset") : 0
        int limit = params.max ? params.int("max") : 10

        Query<OpenGraphAction> query = datastore.find(OpenGraphAction.class);

        [actions: query.skip(offset).limit(limit), total: query.countAll()]
    }
	
}