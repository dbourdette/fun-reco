package com.github.funreco

import com.github.funreco.domain.FacebookProfile
import com.github.funreco.domain.OpenGraphAction
import com.github.funreco.domain.OpenGraphQuery
import com.google.code.morphia.Datastore

class IndexController {

    Datastore datastore

    def index() {
        render(view: "/index", model :
                [
                        "queries" : datastore.find(OpenGraphQuery.class),
                        'profileCount': datastore.find(FacebookProfile.class).countAll() ,
                        'actionCount': datastore.find(OpenGraphAction.class).countAll()
                ]
        )
    }
}
