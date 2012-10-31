import com.github.dbourdette.stub.StubRecommendationFacade
import com.github.dbourdette.stub.StubRecommendationFacadeData

beans = {
	
	recommendationFacade(StubRecommendationFacade) {
		stubRecommendationFacadeData = ref("stubRecommendationFacadeData")
	}
	
	stubRecommendationFacadeData(StubRecommendationFacadeData)
}
