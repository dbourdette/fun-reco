package com.github.funreco.legacy.domain;

import java.io.IOException;
import java.util.Date;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

/**
 * @author damien bourdette
 */
@Entity(value = FacebookProfile.COLLECTION_NAME, noClassnameStored = true)
public class FacebookProfile implements FacebookIdAndName {
    public static final String COLLECTION_NAME = "facebook.profiles";

    @Id
    private ObjectId id;

    @Property
    private String facebookId;

    /**
     * Email is used to find corresponding profile.
     */
    @Property
    private String email;

    @Property
    private String name;

    @Property
    private String firstname;

    @Property
    private String lastname;

    @Property
    private String gender;

    @Property
    private String username;

    @Property
    private String birthday;

    @Property
    private String location;

    @Embedded
    private AccessToken accessToken;

    /**
     * Last time list of friends has been updated
     */
    @Property
    private Date lastFriendsUpdate;

    /**
     * Last time list of likes has been updated
     */
    @Property
    private Date lastLikesUpdate;

    /**
     * Reads profile from json provided by facebook
     *
     * @return
     */
    public static FacebookProfile fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(json);

        FacebookProfile profile = new FacebookProfile();

        profile.facebookId = getString(rootNode, "id");
        profile.email = getString(rootNode, "email");
        profile.name = getString(rootNode, "name");
        profile.firstname = getString(rootNode, "first_name");
        profile.lastname = getString(rootNode, "last_name");
        profile.gender = getString(rootNode, "gender");
        profile.username = getString(rootNode, "username");
        profile.birthday = getString(rootNode, "birthday");
        profile.location = getString(rootNode, "location");

        return profile;

    }

    public FacebookProfileRef toRef() {
        return FacebookProfileRef.fromIdAndName(this);
    }

    public String getEmail() {
        return email;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLocation() {
        return location;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGender() {
        return gender;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastFriendsUpdate() {
        return lastFriendsUpdate;
    }

    public void setLastFriendsUpdate(Date lastFriendsUpdate) {
        this.lastFriendsUpdate = lastFriendsUpdate;
    }

    public Date getLastLikesUpdate() {
        return lastLikesUpdate;
    }

    public void setLastLikesUpdate(Date lastLikesUpdate) {
        this.lastLikesUpdate = lastLikesUpdate;
    }

    @Override
    public String toString() {
        return "FacebookProfile{" +
                "accessToken=" + accessToken +
                ", id=" + id +
                ", facebookId='" + facebookId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                ", location='" + location + '\'' +
                ", lastFriendsUpdate=" + lastFriendsUpdate +
                ", lastLikesUpdate=" + lastLikesUpdate +
                '}';
    }

    private static String getString(JsonNode rootNode, String name) {
        return rootNode.get(name) == null ? "" : rootNode.get(name).getValueAsText();
    }
}
