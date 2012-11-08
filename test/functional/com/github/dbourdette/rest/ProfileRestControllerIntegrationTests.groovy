package com.github.dbourdette.rest

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType

class ProfileRestControllerIntegrationTests extends GroovyTestCase {
    def testGetProfile() {
        def http = new HTTPBuilder('http://localhost:8080')
        http.auth.basic 'admin', 'admin'

        def json = http.get(path: '/api/profile/1', contentType: ContentType.JSON)

        assert json.email == 'jdoo@mail.com'
    }
}
