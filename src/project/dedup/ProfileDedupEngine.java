// ProfileDedupEngine.java

package project.dedup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import project.model.UserProfile;

public class ProfileDedupEngine {
    public static List<UserProfile> deduplicate(List<UserProfile> profiles){
        Set<UserProfile> uniqueProfiles = new HashSet<>();
        uniqueProfiles.addAll(profiles);
        return new ArrayList<>(uniqueProfiles);
    }
}
