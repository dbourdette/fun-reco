package com.github.dbourdette.api

class Friend {
    String facebookId
    String name
	
	@Override
	public boolean equals(Friend friend) {
		return (this.facebookId == friend.facebookId && this.name == friend.name);
	}
}
