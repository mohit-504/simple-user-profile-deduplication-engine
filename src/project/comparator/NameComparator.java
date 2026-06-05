// NameComparator.java

package project.comparator;

import java.util.Comparator;

import project.model.UserProfile;

public class NameComparator implements Comparator<UserProfile> {

    @Override
    public int compare(UserProfile o1, UserProfile o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
