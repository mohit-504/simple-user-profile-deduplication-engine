// EmailComparator.java

package project.comparator;

import java.util.Comparator;

import project.model.UserProfile;

public class EmailComparator implements Comparator<UserProfile> {

    @Override
    public int compare(UserProfile o1, UserProfile o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
    
}
