package com.github.dbourdette.ecm

class FunRecoTagLib {
	
	/**
	 * Format an OpenGraphAction
	 *
	 * @attr action REQUIRED
	 */
	def formatAction = { attrs, body ->
		out << render(template: "/actionTemplate", model: [action: attrs.action])
	}
	
	/**
	 * Format an OpenGraphRecommendation
	 *
	 * @attr recommendedObject REQUIRED
	 */
	def formatRecommendation = { attrs, body ->
		out << render(template: "/recommendationTemplate", model: [recommendedObject: attrs.recommendedObject])
	}

}
