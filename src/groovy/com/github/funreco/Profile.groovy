package com.github.funreco

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
}
