package com.github.funreco

import com.github.funreco.domain.FacebookProfile
import com.github.funreco.domain.OpenGraphAction
import com.github.funreco.domain.OpenGraphObject
import com.github.funreco.service.FacebookProfileService
import com.google.code.morphia.Datastore

class ActionsController {
    Datastore datastore

    FacebookProfileService facebookProfileService

    def index() {
        [
                'count': datastore.find(OpenGraphAction.class).countAll(),
                "items": datastore.find(OpenGraphAction.class).limit(100).asList()
        ]
    }

    def save() {
        FacebookProfile profile = buildProfile()
        OpenGraphObject object = new OpenGraphObject(id : params.id, properties : params.properties)

        OpenGraphAction action = new OpenGraphAction(profile, object)

        datastore.save(action)

        redirect(action: 'index')
    }

    private FacebookProfile buildProfile() {
        if (params.email) {
            return datastore.find(FacebookProfile.class).filter("email", params.email).get();
        } else {
            return facebookProfileService.randomProfile();
        }
    }
}
