package fun.reco

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
	 * @attr recommendedEntity REQUIRED
	 */
	def formatRecommendation = { attrs, body ->
		out << render(template: "/recommendationTemplate", model: [recommendedEntity: attrs.recommendedEntity])
	}

}
