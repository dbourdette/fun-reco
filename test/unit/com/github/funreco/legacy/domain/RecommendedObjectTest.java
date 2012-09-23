package com.github.funreco.legacy.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.funreco.legacy.domain.recommandation.RecommendedObject;

import static org.fest.assertions.Assertions.assertThat;

public class RecommendedObjectTest {
    @Test
    public void object() {
        RecommendedObject object = RecommendedObject.object("10").by(generateProfiles(5));

        assertThat(object.getBy().size()).isEqualTo(5);
        assertThat(object.getBy()).contains(FacebookTestProfiles.profileForId(2).toRef());
    }

    @Test
    public void pickSomeRandomProfiles() {
        List<FacebookProfileRef> profiles = generateProfiles(RecommendedObject.MAX_PROFILES);

        List<FacebookProfileRef> picks = RecommendedObject.pickSomeRandomProfiles(profiles);

        assertThat(picks.size()).isEqualTo(profiles.size());
        assertThat(picks).containsOnly(profiles.toArray());
    }

    @Test
    public void pickSomeRandomProfilesWithTooManyProfiles() {
        List<FacebookProfileRef> profiles = generateProfiles(RecommendedObject.MAX_PROFILES + 2);

        List<FacebookProfileRef> picks = RecommendedObject.pickSomeRandomProfiles(profiles);

        assertThat(picks.size()).isEqualTo(RecommendedObject.MAX_PROFILES);
    }

    public List<FacebookProfileRef> generateProfiles(int count) {
        List<FacebookProfileRef> profiles = new ArrayList<FacebookProfileRef>();

        for (int i = 0; i < count; i++) {
            profiles.add(FacebookTestProfiles.profileForId(i).toRef());
        }

        return profiles;
    }
}
