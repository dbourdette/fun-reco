import com.github.funreco.legacy.engine.RecommendationEngine
import com.github.funreco.spring.DatastoreFactoryBean
import com.github.funreco.legacy.service.OpenGraphQueryService
import com.github.funreco.legacy.bootstrap.BootstrapDB
import com.github.funreco.legacy.LegacyRecommendationFacade
import com.github.funreco.legacy.service.OpenGraphActionService
import com.github.funreco.legacy.service.FacebookProfileService
import com.github.funreco.legacy.service.FacebookFriendsService
import com.github.funreco.stub.StubRecommendationFacade
import com.github.funreco.stub.StubRecommendationFacadeData

// Place your Spring DSL code here
beans = {
    datastore(DatastoreFactoryBean)

    bootstrapDB(BootstrapDB)

    legacyRecommendationFacade(LegacyRecommendationFacade) {
        recommendationEngine = ref("recommendationEngine")
        openGraphActionService = ref("openGraphActionService")
        facebookProfileService = ref("facebookProfileService")
        facebookFriendsService = ref("facebookFriendsService")
    }
	
	recommendationFacade(StubRecommendationFacade) {
		stubRecommendationFacadeData = ref("stubRecommendationFacadeData")
	}
	
	stubRecommendationFacadeData(StubRecommendationFacadeData)

    openGraphQueryService(OpenGraphQueryService) {
        communityDatastore = ref("datastore")
    }

    recommendationEngine(RecommendationEngine) {
        communityDatastore = ref("datastore")
        openGraphQueryService = ref("openGraphQueryService")
        facebookFriendsService = ref("facebookFriendsService")
    }
}
