package com.github.funreco

class Entity {
    String id
    Map<String, Set<String>> properties

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", properties=" + properties +
                '}';
    }
}
