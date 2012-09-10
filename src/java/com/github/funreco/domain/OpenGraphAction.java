package com.github.funreco.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

/**
 * Open graph actions are sent to facebook and also stored here.
 * This storage will allow us to easily query and build recommendations
 */
@Entity(value = OpenGraphAction.COLLECTION_NAME, noClassnameStored = true)
public class OpenGraphAction {
    public static final String COLLECTION_NAME = "facebook.opengraph.actions";

    @Id
    private ObjectId id;

    @Embedded
    private FacebookProfileRef profile;

    @Property
    private Date date;

    @Embedded
    private OpenGraphObject object;

    public OpenGraphAction() {
    }

    public OpenGraphAction(FacebookIdAndName profile, OpenGraphObject object) {
        this.date = new Date();
        this.profile = FacebookProfileRef.fromIdAndName(profile);
        this.object = object;
    }

    public Date getDate() {
        return date;
    }

    public OpenGraphObject getObject() {
        return object;
    }

    public FacebookProfileRef getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "OpenGraphAction{" +
                "date=" + date +
                ", id=" + id +
                ", profile=" + profile +
                ", object=" + object +
                '}';
    }
}
