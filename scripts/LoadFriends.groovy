import com.github.dbourdette.api.Profile
import groovy.json.JsonSlurper
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsArgParsing")

target(main: "Loads friends through HTTP REST API") {
    parseArguments()

    if (!argsMap.params) {
        event("StatusError", ["Please provide a file containing friends"])
    } else {
        def http = new HTTPBuilder('http://localhost:8080')
        http.auth.basic 'admin', 'admin'

        argsMap.params.each { String file ->
            new File(file).eachLine { line ->
                json = new JsonSlurper().parseText(line)

                println "updating ${json.profile.name}"

                http.request( Method.POST, ContentType.JSON) {
                    uri.path = "/api/profile/${json.profile.facebookId}/friends"
                    body = json.friends
                }
            }
        }
    }
}

setDefaultTarget(main)
