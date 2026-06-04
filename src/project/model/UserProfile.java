//UserProfile.java

package project.model;

import lombok.AllArgsConstructor;
// import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class UserProfile {
    private final String userId;
    private String name;
    private String email;
    private String phone;
    private long lastUpdated;
}