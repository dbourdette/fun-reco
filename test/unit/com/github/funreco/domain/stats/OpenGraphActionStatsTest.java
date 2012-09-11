package com.github.funreco.domain.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.funreco.domain.FacebookProfile;
import com.github.funreco.domain.FacebookTestProfiles;
import com.github.funreco.domain.OpenGraphObject;

import static com.github.funreco.domain.query.Queries.*;
import static org.fest.assertions.Assertions.assertThat;

/**
 * @author damien bourdette
 */
public class OpenGraphActionStatsTest {
    private OpenGraphActionStats stats;

    private FacebookProfile profile1 = FacebookTestProfiles.aProfile("profile1@test.com");

    private FacebookProfile profile2 = FacebookTestProfiles.aProfile("profile2@test.com");

    @Before
    public void init() {
        List<OpenGraphActionStat> init = new ArrayList<OpenGraphActionStat>();

        init.add(new OpenGraphActionStat(new OpenGraphObject("1").put("type", "video"))
                .increaseCount(profile1));
        init.add(new OpenGraphActionStat(new OpenGraphObject("2").put("type", "photo"))
                .increaseCount(profile1)
                .increaseCount(profile2));
        init.add(new OpenGraphActionStat(new OpenGraphObject("3").put("type", "video"))
                .increaseCount(profile2));
        init.add(new OpenGraphActionStat(new OpenGraphObject("4").put("type", "video").put("show", "La grosse emission"))
                .increaseCount(profile2));

        stats = OpenGraphActionStats.fromStats(init);
    }

    @Test
    public void filterByFriends() {
        stats = stats.filterByFriends(Arrays.asList(profile1.toRef()));

        assertThat(stats.getObjectCount()).isEqualTo(2);
        assertThat(stats.getObject(0)).isEqualTo(new OpenGraphObject("2").put("type", "photo"));
        assertThat(stats.getObject(1)).isEqualTo(new OpenGraphObject("1").put("type", "video"));
    }

    @Test
    public void filterByTypeQuery() {
        stats = stats.filterByQuery(property("type", "photo"));

        assertThat(stats.getObjectCount()).isEqualTo(1);
        assertThat(stats.getObject(0)).isEqualTo(new OpenGraphObject("2").put("type", "photo"));
    }

    @Test
    public void filterByShowQuery() {
        stats = stats.filterByQuery(property("show", "La grosse emission"));

        assertThat(stats.getObjectCount()).isEqualTo(1);
        assertThat(stats.getObject(0)).isEqualTo(new OpenGraphObject("4").put("type", "video").put("show", "La grosse emission"));
    }

    @Test
    public void filterWithOrQuery() {
        stats = stats.filterByQuery(or(property("type", "photo"), property("type", "video")));

        assertThat(stats.getObjectCount()).isEqualTo(4);
    }

    @Test
    public void filterWithAndQuery() {
        stats = stats.filterByQuery(and(property("type", "video"), property("show", "La grosse emission")));

        assertThat(stats.getObjectCount()).isEqualTo(1);
        assertThat(stats.getObject(0)).isEqualTo(new OpenGraphObject("4").put("type", "video").put("show", "La grosse emission"));
    }

    @Test
    public void filterWithNotNullQuery() {
        stats = stats.filterByQuery(notNull("show"));

        assertThat(stats.getObjectCount()).isEqualTo(1);
        assertThat(stats.getObject(0)).isEqualTo(new OpenGraphObject("4").put("type", "video").put("show", "La grosse emission"));
    }

    @Test
    public void top() {
        stats = stats.top(1);

        assertThat(stats.getObjectCount()).isEqualTo(1);
        assertThat(stats.getObject(0)).isEqualTo(new OpenGraphObject("2").put("type", "photo"));
    }

    @Test
    public void topBoundaries() {
        assertThat(stats.top(0).getObjectCount()).isEqualTo(0);
        assertThat(stats.top(100).getObjectCount()).isEqualTo(4);
    }

    @Test
    public void iterate() {
        assertThat(stats.iterate().iterator().next().getObject()).isEqualTo(new OpenGraphObject("2").put("type", "photo"));
    }
}
