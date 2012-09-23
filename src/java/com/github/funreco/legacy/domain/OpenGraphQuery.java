package com.github.funreco.legacy.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.github.funreco.legacy.domain.query.Query;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PrePersist;
import com.google.code.morphia.annotations.Property;

@Entity(value = "facebook.opengraph.queries", noClassnameStored = true)
public class OpenGraphQuery {
    @Id
    private ObjectId id;

    @Embedded
    private Query query;

    @Property
    private String queryLiteral;

    @Property
    private Date lastUsage = new Date();

    @PrePersist
    public void buildQueryLiteral() {
        if (query != null) {
            queryLiteral = query.toString();
        } else {
            queryLiteral = "";
        }
    }

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

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getQueryLiteral() {
        return queryLiteral;
    }

    public void setQueryLiteral(String queryLiteral) {
        this.queryLiteral = queryLiteral;
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
