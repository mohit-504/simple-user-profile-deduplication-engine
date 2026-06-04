//ProfilePrinter.java

package project.utils;

import project.model.UserProfile;

public class ProfilePrinter {
    public static void printProfiles(Iterable<UserProfile> profiles){
        for(UserProfile p:profiles){
            System.out.println(p);
        }
    }
}
