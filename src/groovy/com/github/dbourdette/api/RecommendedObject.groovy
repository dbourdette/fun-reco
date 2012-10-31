package com.github.dbourdette.api

class RecommendedObject {
    Object object
    List<Friend> by
	
	@Override
	public boolean equals(RecommendedObject recommendedObject) {
		return (this.object.equals(recommendedObject.object) && this.by.equals(recommendedObject.by));
	}
}
