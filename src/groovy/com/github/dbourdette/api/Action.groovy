package com.github.dbourdette.api

class Action {
    Profile profile
    Object object
    Date date
	
	@Override
	public boolean equals(Action action) {
		return (this.profile.equals(action.profile) && this.object.equals(action.object) && this.date.toString() == action.date.toString());
	}
}
