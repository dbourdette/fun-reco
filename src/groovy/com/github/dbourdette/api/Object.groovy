package com.github.dbourdette.api

class Object {
    String id
    Map<String, ArrayList<String>> properties
	
    @Override
    public String toString() {
        return "Object{" +
                "id='" + id + '\'' +
                ", properties=" + properties +
                '}';
    }
	
	@Override
	public boolean equals(Object object) {
		return (this.id == object.id && this.properties.equals(object.properties));
	}
}
