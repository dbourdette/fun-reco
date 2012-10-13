package com.github.funreco;

import static org.fest.assertions.Assertions.assertThat
import org.junit.Test;
import org.junit.Before;

class StubRecommendationFacadeTests {

	private StubRecommendationFacade stub
	
	@Before
	void init(){
		stub = new StubRecommendationFacade()
	}
	
	@Test
	void test(){
		assertThat(stub.countActions()).isEqualTo(2);
	}
	
	@Test
	void testProfile(){
		def profile = new Profile(facebookId: "423BH5H342V3", email: "jdoo@mail.com", name: "John DOO")
		
		assertThat(stub.findProfile("", "").equals(profile) == true);
	}
	
	@Test
	void testProfileAttrs(){
		def profile = new Profile(facebookId: "423BH5H342V3", email: "jdoo@mail.com", name: "John DOO")
		
		assertThat(stub.findProfile("", "").facebookId).isEqualTo(profile.facebookId);
		assertThat(stub.findProfile("", "").email).isEqualTo(profile.email);
		assertThat(stub.findProfile("", "").name).isEqualTo(profile.name);
	}
	
	@Test
	void testProfileBis(){
		
		assertThat(stub.findProfile("", "")).isEqualTo(stub.profile);
	}
	
}
