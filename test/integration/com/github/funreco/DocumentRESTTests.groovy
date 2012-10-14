package com.github.funreco
import static org.junit.Assert.*;

import fun.reco.Document

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType
import groovyx.net.http.Method
import groovyx.net.http.RESTClient

class DocumentRESTTests {
	
	void testShowAll() {
		def http = new HTTPBuilder("http://localhost:8080/document")
		http.request(Method.GET, ContentType.JSON) {
			//uri.path = '/'
			//uri.query
			response.success = { resp, json ->
				for (doc in json) {
					assert doc.title == "title"
				}
			}
		}
	}
	
	void testShowId() {
		def http = new HTTPBuilder("http://localhost:8080/document/507ab8c803644a195c086516")
		http.request(Method.GET, ContentType.JSON) {
			response.success = { resp, json ->
				assert json.title == "title"
			}
		}
	}
}
