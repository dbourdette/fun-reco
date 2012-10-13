environments {
	development {
		grails {
			mongo {
				databaseName = "fun-reco"
			}
		}
	}
	test {
		grails {
			mongo {
				databaseName = "fun-reco-test"
			}
		}
	}
}
