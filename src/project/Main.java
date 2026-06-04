//Main.java

package project;

import java.util.ArrayList;
import java.util.List;

import project.model.UserProfile;
import project.utils.ProfilePrinter;

public class Main {
    public static void main(String[] args) {
        // milestone1();
        milestone2();
    }

    public static void milestone1(){
        UserProfile u1 = new UserProfile("ab121sf");
        u1.setName("ggegegegeggee");
        System.out.println(u1.getUserId() + " " + u1.getName());

        UserProfile u2 = new UserProfile("sd3345tt56", "Bob Duncan", "bobd@gmail.com", "12133558", System.currentTimeMillis());
        System.out.println(u2.getUserId() + " " + u2.getName() + " " + u2.getEmail() + " " + u2.getPhone());
    }

    public static void milestone2(){
        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(
            new UserProfile(
                "U1",
                "Alice",
                "alice@test.com",
                "1111",
                System.currentTimeMillis()
            )
        );

        profiles.add(
            new UserProfile(
                "U2",
                "Bob",
                "bob@test.com",
                "2222",
                System.currentTimeMillis()
            )
        );

        profiles.add(
            new UserProfile(
                "U3",
                "Alice Duplicate",
                "alice@test.com",
                "3333",
                System.currentTimeMillis()
            )
        );

        ProfilePrinter.printProfiles(profiles);
    }
}
