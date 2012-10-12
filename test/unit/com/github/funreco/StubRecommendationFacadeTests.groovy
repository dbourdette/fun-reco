package com.github.funreco;

import static org.fest.assertions.Assertions.assertThat;

class StubRecommendationFacadeTests {

	@Test
	void test(){
		StubRecommendationFacade stub = new StubRecommendationFacade()
		assertThat(stub.countActions()).isEqualTo(2);
	}
	
	
}
