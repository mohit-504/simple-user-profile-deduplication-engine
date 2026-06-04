// ProfileIdentityResolver.java

package project.merge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.model.UserProfile;

public class ProfileIdentityResolver {
    public static List<UserProfile> resolve(List<UserProfile> profiles){
        Map<String, UserProfile> emailMap = new HashMap<>();
        
        for(UserProfile p : profiles){
            UserProfile existing = emailMap.get(p.getEmail());
            if(emailMap.containsKey(existing.getEmail())){
                UserProfile mergedProfile = ProfileMergeEngine.mergeProfiles(existing, p);
                emailMap.put(p.getEmail(), mergedProfile);
            }
            else{
                emailMap.put(p.getEmail(), p);
            }
        }
        return new ArrayList<>(emailMap.values());
    }
}
