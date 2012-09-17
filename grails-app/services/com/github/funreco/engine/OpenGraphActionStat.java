package com.github.funreco.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.github.funreco.domain.FacebookIdAndName;
import com.github.funreco.domain.FacebookProfileRef;
import com.github.funreco.domain.OpenGraphObject;

public class OpenGraphActionStat {
    private OpenGraphObject object;

    private int count;

    private List<FacebookProfileRef> profiles = new ArrayList<FacebookProfileRef>();

    public OpenGraphActionStat(OpenGraphObject object) {
        this.object = object;
    }

    public OpenGraphObject getObject() {
        return object;
    }

    public int getCount() {
        return count;
    }

    public List<FacebookProfileRef> getProfiles() {
        return profiles;
    }

    public OpenGraphActionStat increaseCount(FacebookIdAndName profile) {
        count += 1;

        FacebookProfileRef profileRef = new FacebookProfileRef(profile);

        if (!profiles.contains(profileRef)) {
            profiles.add(profileRef);
        }

        return this;
    }

    public OpenGraphActionStat increaseCount(OpenGraphActionStat stat) {
        count += stat.count;

        for (FacebookProfileRef profile : stat.profiles) {
            if (!profiles.contains(profile)) {
                profiles.add(profile);
            }
        }

        return this;
    }

    public boolean containsAnyFriend(List<FacebookProfileRef> friends) {
        return CollectionUtils.containsAny(profiles, friends);
    }

    @Override
    public String toString() {
        return "OpenGraphActionStat{" +
                "object=" + object +
                ", count=" + count +
                '}';
    }
}
