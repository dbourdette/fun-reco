package com.github.funreco.domain.stats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.github.funreco.domain.FacebookProfileRef;
import com.github.funreco.domain.OpenGraphAction;
import com.github.funreco.domain.OpenGraphObject;
import com.github.funreco.domain.query.Criterion;

/**
 * @author damien bourdette
 */
public class OpenGraphActionStats {
    private List<OpenGraphActionStat> stats = new ArrayList<OpenGraphActionStat>();

    public static OpenGraphActionStats fromActions(Iterable<OpenGraphAction> actions) {
        Map<OpenGraphObject, OpenGraphActionStat> map = new HashMap<OpenGraphObject, OpenGraphActionStat>();

        for (OpenGraphAction action : actions) {
            ensureExists(map, action.getObject()).increaseCount(action.getProfile());
        }

        return new OpenGraphActionStats(map.values());
    }

    public static OpenGraphActionStats fromStats(Collection<OpenGraphActionStat> stats) {
        Map<OpenGraphObject, OpenGraphActionStat> map = new HashMap<OpenGraphObject, OpenGraphActionStat>();

        for (OpenGraphActionStat stat : stats) {
            ensureExists(map, stat.getObject()).increaseCount(stat);
        }

        return new OpenGraphActionStats(map.values());
    }

    private OpenGraphActionStats(Collection<OpenGraphActionStat> stats) {
        this.stats = new ArrayList<OpenGraphActionStat>(stats);

        Collections.sort(this.stats, new OpenGraphActionStatComparator());
    }

    public int getObjectCount() {
        return stats.size();
    }

    public OpenGraphObject getObject(int i) {
        return stats.get(i).getObject();
    }

    public OpenGraphActionStats top(int count) {
        return new OpenGraphActionStats(stats.subList(0, Math.min(stats.size(), count)));
    }

    public OpenGraphActionStats filterByFriends(List<FacebookProfileRef> friends) {
        return filter(new FriendsPredicate(friends));
    }

    public OpenGraphActionStats filterByQuery(Criterion criterion) {
        return filter(new CriterionPredicate(criterion));
    }

    public Iterable<OpenGraphActionStat> iterate() {
        return stats;
    }

    @Override
    public String toString() {
        return "OpenGraphActionStats{" +
                "stats=" + stats +
                '}';
    }

    private OpenGraphActionStats filter(Predicate predicate) {
        List<OpenGraphActionStat> stats = new ArrayList<OpenGraphActionStat>(this.stats);

        CollectionUtils.filter(stats, predicate);

        return new OpenGraphActionStats(stats);
    }

    private static OpenGraphActionStat ensureExists(Map<OpenGraphObject, OpenGraphActionStat> stats, OpenGraphObject object) {
        OpenGraphActionStat stat = stats.get(object);

        if (stat == null) {
            stat = new OpenGraphActionStat(object);

            stats.put(object, stat);
        }

        return stat;
    }

    private class OpenGraphActionStatComparator implements Comparator<OpenGraphActionStat> {
        @Override
        public int compare(OpenGraphActionStat stat1, OpenGraphActionStat stat2) {
            return stat2.getCount() - stat1.getCount();
        }
    }

    private class FriendsPredicate implements Predicate {
        private List<FacebookProfileRef> friends;

        private FriendsPredicate(List<FacebookProfileRef> friends) {
            this.friends = friends;
        }

        @Override
        public boolean evaluate(Object object) {
            return ((OpenGraphActionStat) object).containsAnyFriend(friends);
        }
    }

    private class CriterionPredicate implements Predicate {
        private Criterion criterion;

        private CriterionPredicate(Criterion criterion) {
            this.criterion = criterion;
        }

        @Override
        public boolean evaluate(Object object) {
            return criterion.match(((OpenGraphActionStat) object).getObject());
        }
    }
}
