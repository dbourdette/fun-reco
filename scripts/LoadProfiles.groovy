import com.github.dbourdette.api.Profile
import groovy.json.JsonSlurper
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsArgParsing")

target(main: "Loads profiles through RecommendationFacade") {
    parseArguments()

    if (!argsMap.params) {
        event("StatusError", ["Please provide a file containing profiles"])
    } else {
        def http = new HTTPBuilder('http://localhost:8080')
        http.auth.basic 'admin', 'admin'

        argsMap.params.each { String file ->
            new File(file).eachLine { line ->
                json = new JsonSlurper().parseText(line)

                println "updating ${json.email}"

                http.request( Method.POST, ContentType.JSON) {
                    uri.path = '/api/profile'
                    body = [
                        email: json.email,
                        name: json.name,
                        facebookId: json.facebookId
                    ]
                }
            }
        }
    }
}

setDefaultTarget(main)
