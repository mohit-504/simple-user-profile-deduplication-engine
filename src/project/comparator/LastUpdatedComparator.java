// LastUpdatedComparator.java

package project.comparator;

import java.util.Comparator;

import project.model.UserProfile;

public class LastUpdatedComparator implements Comparator<UserProfile> {

    @Override
    public int compare(UserProfile o1, UserProfile o2) {
        return Long.compare(o2.getLastUpdated(), o1.getLastUpdated());
    }
    
}