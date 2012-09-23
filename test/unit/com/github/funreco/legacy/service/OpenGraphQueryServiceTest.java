package com.github.funreco.legacy.service;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.github.funreco.legacy.domain.OpenGraphQuery;
import com.github.funreco.legacy.domain.query.Queries;
import com.github.funreco.spring.DatastoreFactoryBean;
import com.google.code.morphia.Datastore;

import static org.fest.assertions.Assertions.assertThat;

public class OpenGraphQueryServiceTest {
    private OpenGraphQueryService openGraphQueryService;

    private Datastore communityDatastore = new DatastoreFactoryBean().getObject();

    @Before
    public void init() {
        openGraphQueryService = new OpenGraphQueryService();
        openGraphQueryService.setCommunityDatastore(communityDatastore);

        communityDatastore.delete(communityDatastore.find(OpenGraphQuery.class));
    }

    @Test
    public void save() throws IOException {
        openGraphQueryService.save(Queries.property("type", "news"));
        openGraphQueryService.save(Queries.property("type", "news"));

        assertThat(communityDatastore.find(OpenGraphQuery.class).countAll()).isEqualTo(1);
    }

    @Test
    public void findAll() throws IOException {
        openGraphQueryService.save(Queries.property("type", "news"));
        openGraphQueryService.save(Queries.or(Queries.property("type", "news"), Queries.property("type", "image")));

        assertThat(openGraphQueryService.findAll().size()).isEqualTo(2);
    }
}
