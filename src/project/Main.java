//Main.java

package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import project.comparator.EmailComparator;
import project.comparator.LastUpdatedComparator;
import project.comparator.NameComparator;
import project.dedup.ProfileDedupEngine;
import project.merge.ProfileIdentityResolver;
import project.model.UserProfile;
import project.utils.ProfilePrinter;

public class Main {
    public static void main(String[] args) {
        // milestone1();
        // milestone2();
        // milestone3();
        // milestone4();
        // milestone5();
        // milestone6();
        milestone7();
    }

    public static void milestone1(){
        UserProfile u1 = new UserProfile("121ssd341", "alice@test.com");
        u1.setName("ggegegegeggee");
        System.out.println(u1.getUserId() + " " + u1.getName());

        UserProfile u2 = new UserProfile("sd3345tt56", "Bob Duncan", "bobd@test.com", "12133558", System.currentTimeMillis());
        System.out.println(u2.getUserId() + " " + u2.getName() + " " + u2.getEmail() + " " + u2.getPhone());
    }

    public static void milestone2(){
        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(new UserProfile("U1", "Alice", "alice@test.com", "1111", System.currentTimeMillis()));
        profiles.add(new UserProfile("U2", "Bob", "bob@test.com", "2222", System.currentTimeMillis()));
        profiles.add(new UserProfile("U3", "Alice Duplicate", "alice@test.com", "3333", System.currentTimeMillis()));

        ProfilePrinter.printProfiles(profiles);
    }

    public static void milestone3(){
        UserProfile u1 = new UserProfile("U1", "alice@test.com", "Alice", "1111", System.currentTimeMillis());
        UserProfile u2 = new UserProfile("U2", "aLIce@tEst.com", "Alice Duplicate", "1112", System.currentTimeMillis());

        System.out.println(u1.equals(u2));
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());

        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(u1);
        profiles.add(u2);

        ProfilePrinter.printProfiles(profiles);
    }

    public static void milestone4(){
        UserProfile u1 = new UserProfile("U1", "alice@test.com", "Alice", "1111", System.currentTimeMillis());
        UserProfile u2 = new UserProfile("U2", "alice@test.com", "Alice Duplicate", "1112", System.currentTimeMillis());
        UserProfile u3 = new UserProfile("U3", "bob@test.com", "Bob", "2222", System.currentTimeMillis());
        UserProfile u4 = new UserProfile("U4", "charlie@test.com", "Charlie", "3333", System.currentTimeMillis());

        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(u1);
        profiles.add(u2);
        profiles.add(u3);
        profiles.add(u4);

        System.out.println("before:");
        ProfilePrinter.printProfiles(profiles);

        List<UserProfile> uniqueProfiles = ProfileDedupEngine.deduplicate(profiles);

        System.out.println("\nafter:");
        ProfilePrinter.printProfiles(uniqueProfiles);
    }

    public static void milestone5(){
        UserProfile u1 = new UserProfile("U1", "alice@test.com", "Alice", "1111", System.currentTimeMillis());
        UserProfile u2 = new UserProfile("U2", "alice@test.com", "Alice Duplicate", "1112", System.currentTimeMillis());
        UserProfile u3 = new UserProfile("U3", "bob@test.com", "Bob", "2222", System.currentTimeMillis());
        UserProfile u4 = new UserProfile("U4", "charlie@test.com", "Charlie", "3333", System.currentTimeMillis());
        UserProfile u5 = new UserProfile("U5", "alice@test.com", "Alice Second Duplicate", "4444", System.currentTimeMillis());

        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(u1);
        profiles.add(u2);
        profiles.add(u3);
        profiles.add(u4);
        profiles.add(u5);

        System.out.println("before:");
        ProfilePrinter.printProfiles(profiles);

        List<UserProfile> afterMergeProfiles = ProfileIdentityResolver.resolve(profiles);

        System.out.println("\nafter:");
        ProfilePrinter.printProfiles(afterMergeProfiles);
    }

    public static void milestone6(){
        UserProfile u1 = new UserProfile("U5", "alice@test.com", "Alice", "1111", System.currentTimeMillis());
        UserProfile u2 = new UserProfile("U1", "ruth@test.com", "Ruth", "1112", System.currentTimeMillis());
        UserProfile u3 = new UserProfile("U3", "bob@test.com", "Bob", "2222", System.currentTimeMillis());
        UserProfile u4 = new UserProfile("U2", "charlie@test.com", "Charlie", "3333", System.currentTimeMillis());
        UserProfile u5 = new UserProfile("U4", "fred@test.com", "Fred", "4444", System.currentTimeMillis());

        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(u1);
        profiles.add(u2);
        profiles.add(u3);
        profiles.add(u4);
        profiles.add(u5);

        System.out.println("before sorting:");
        ProfilePrinter.printProfiles(profiles);

        Collections.sort(profiles);
        System.out.println("\nafter ascending sorting:");
        ProfilePrinter.printProfiles(profiles);

        Collections.sort(profiles, Collections.reverseOrder());
        System.out.println("\nafter descending sorting:");
        ProfilePrinter.printProfiles(profiles);
    }

    public static void milestone7(){
        UserProfile u1 = new UserProfile("U5", "alice@test.com", "Alice", "1111", System.currentTimeMillis());
        UserProfile u2 = new UserProfile("U1", "ruth@test.com", "Ruth", "1112", System.currentTimeMillis());
        UserProfile u3 = new UserProfile("U3", "bob@test.com", "Bob", "2222", System.currentTimeMillis());
        UserProfile u4 = new UserProfile("U2", "charlie@test.com", "Charlie", "3333", System.currentTimeMillis());
        UserProfile u5 = new UserProfile("U4", "fred@test.com", "Fred", "4444", System.currentTimeMillis());

        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(u1);
        profiles.add(u2);
        profiles.add(u3);
        profiles.add(u4);
        profiles.add(u5);

        System.out.println("before sorting:");
        ProfilePrinter.printProfiles(profiles);

        Collections.sort(profiles, new NameComparator());
        System.out.println("\nafter sorting based on Name:");
        ProfilePrinter.printProfiles(profiles);

        Collections.sort(profiles, new EmailComparator());
        System.out.println("\nafter sorting based on Email:");
        ProfilePrinter.printProfiles(profiles);

        Collections.sort(profiles, new LastUpdatedComparator());
        System.out.println("\nafter sorting based on Last Updated Date (most recent first):");
        ProfilePrinter.printProfiles(profiles);

        System.out.println("\nsorting based on name using one line comparator");
        profiles.sort(Comparator.comparing(UserProfile::getName));
        ProfilePrinter.printProfiles(profiles);
    }
}
