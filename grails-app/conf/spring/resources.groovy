import grails.util.Environment

import com.github.dbourdette.stub.StubRecommendationFacade
import com.github.dbourdette.stub.StubRecommendationFacadeData
import com.github.dbourdette.ecm.RecommendationFacadeImpl

beans = {
	switch(Environment.current) {
		case Environment.TEST:
			recommendationFacade(StubRecommendationFacade) {
				stubRecommendationFacadeData = ref("stubRecommendationFacadeData")
			}
			
			stubRecommendationFacadeData(StubRecommendationFacadeData)
			break
		case Environment.DEVELOPMENT:
			recommendationFacade(RecommendationFacadeImpl)
			break
	}
	
}
