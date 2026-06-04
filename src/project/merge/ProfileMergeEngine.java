// ProfileMergeEngine.java

package project.merge;

import project.model.UserProfile;

public class ProfileMergeEngine {
    public static UserProfile mergeProfiles(UserProfile existing, UserProfile incoming){
        UserProfile merged = new UserProfile(
            existing.getUserId(),
            existing.getEmail(),
            existing.getName(),
            existing.getPhone(),
            existing.getLastUpdated()
        );

        if(incoming.getName()!=null && !incoming.getName().isBlank()){
            merged.setName(incoming.getName());
        }

        if(incoming.getPhone()!=null && !incoming.getPhone().isBlank()){
            merged.setPhone(incoming.getPhone());
        }

        merged.setLastUpdated(Math.max(existing.getLastUpdated(), incoming.getLastUpdated()));

        return merged;
    }
}
