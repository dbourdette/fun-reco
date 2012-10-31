package com.github.dbourdette.api

class Profile {
    String facebookId
    String email
    String name

    @Override
    public String toString() {
        return "Profile{" +
                "email='" + email + '\'' +
                ", facebookId='" + facebookId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
	
	@Override
	public boolean equals(Profile profile) {
		return (this.facebookId == profile.facebookId && this.email == profile.email && this.name == profile.name);
	}
}
