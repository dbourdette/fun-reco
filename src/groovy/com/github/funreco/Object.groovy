package com.github.funreco

class Object {
    String id
    Map<String, Set<String>> properties

    @Override
    public String toString() {
        return "Object{" +
                "id='" + id + '\'' +
                ", properties=" + properties +
                '}';
    }
}
