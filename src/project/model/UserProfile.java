//UserProfile.java

package project.model;

import lombok.AllArgsConstructor;
// import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class UserProfile {
    private String userId;
    private final String email;
    private String name;
    private String phone;
    private long lastUpdated;

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj==null || getClass() != obj.getClass()){
            return false;
        }

        UserProfile other = (UserProfile) obj;
        return Objects.equals(email, other.email);
    }

    @Override
    public int hashCode(){
        return Objects.hash(email);
    }
}