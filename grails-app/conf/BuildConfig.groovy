grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {

	def gebVersion = "0.7.2"
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
      mavenRepo "http://morphia.googlecode.com/svn/mavenrepo/"
    }
    dependencies {

        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.20'

        runtime 'org.mongodb:mongo-java-driver:2.9.1'
        compile 'org.antlr:antlr:3.4'
        compile 'org.codehaus.jackson:jackson-core-asl:1.9.10'
        compile 'org.codehaus.jackson:jackson-mapper-asl:1.9.10'
        
        compile 'com.google.code.morphia:morphia:0.99'
	    compile 'joda-time:joda-time:2.1'
	
       
        compile 'org.easytesting:fest-assert:1.4'
        compile 'org.easytesting:fest-reflect:1.4'
        compile 'org.easytesting:fest-util:1.2.3'

        test "org.codehaus.geb:geb-junit4:0.7.2"
        test "org.seleniumhq.selenium:selenium-support:2.25.0"
        test "org.seleniumhq.selenium:selenium-firefox-driver:2.25.0"
        test "org.seleniumhq.selenium:selenium-chrome-driver:2.25.0"
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:2.25.0") {
            exclude "xml-apis"
        }
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.2"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

        runtime ":database-migration:1.1"

        compile ':cache:1.0.0'
        test ":geb:0.7.2"
       
    }
}
