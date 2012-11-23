package com.github.dbourdette.api

class Object {
    String id
    Map<String, ArrayList<String>> objectProperties
	
    @Override
    public String toString() {
        return "Object{" +
                "id='" + id + '\'' +
                ", properties=" + objectProperties +
                '}';
    }
	
	@Override
	public boolean equals(Object object) {
		return (this.id == object.id && this.objectProperties.equals(object.objectProperties));
	}
}
