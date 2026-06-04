//ProfilePrinter.java

package project.utils;

import java.util.List;

import project.model.UserProfile;

public class ProfilePrinter {
    public static void printProfiles(List<UserProfile> profiles){
        for(UserProfile p:profiles){
            System.out.println(p);
        }
    }
}
