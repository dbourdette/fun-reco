package com.github.funreco.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

@Entity(value = "facebook.opengraph.queries", noClassnameStored = true)
public class OpenGraphQuery {
    @Id
    private ObjectId id;

    @Property
    private String query;

    @Property
    private Date lastUsage = new Date();

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getLastUsage() {
        return lastUsage;
    }

    public void setLastUsage(Date lastUsage) {
        this.lastUsage = lastUsage;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "OpenGraphQuery{" +
                "id=" + id +
                ", query='" + query + '\'' +
                ", lastUsage=" + lastUsage +
                '}';
    }
}
