package com.github.funreco

import com.github.funreco.domain.FacebookProfile
import com.github.funreco.domain.OpenGraphAction
import com.github.funreco.domain.OpenGraphQuery
import com.github.funreco.service.OpenGraphQueryService
import com.google.code.morphia.Datastore
import com.github.funreco.domain.query.Queries

class IndexController {

    Datastore datastore

    OpenGraphQueryService openGraphQueryService

    def index() {
        bootstrapQueries();

        render(view: "/index", model :
                [
                        "queries" : datastore.find(OpenGraphQuery.class),
                        'profileCount': datastore.find(FacebookProfile.class).countAll() ,
                        'actionCount': datastore.find(OpenGraphAction.class).countAll()
                ]
        )
    }

    private void bootstrapQueries() {
        ['video', 'sound', 'image', 'news'].each {
            openGraphQueryService.save(Queries.property("type", it))
            openGraphQueryService.save(Queries.and(Queries.property("type", it), Queries.notNull("show")))
        }
    }
}
