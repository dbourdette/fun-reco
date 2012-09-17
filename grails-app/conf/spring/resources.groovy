import com.github.funreco.engine.RecommendationEngine
import com.github.funreco.spring.DatastoreFactoryBean
import com.github.funreco.service.OpenGraphQueryService
import com.github.funreco.bootstrap.BootstrapDB

// Place your Spring DSL code here
beans = {
    datastore(DatastoreFactoryBean)

    recommendationEngine(RecommendationEngine) {
        communityDatastore = ref("datastore")
        openGraphQueryService = ref("openGraphQueryService")
        facebookFriendsService = ref("facebookFriendsService")
    }

    bootstrapDB(BootstrapDB)
}
