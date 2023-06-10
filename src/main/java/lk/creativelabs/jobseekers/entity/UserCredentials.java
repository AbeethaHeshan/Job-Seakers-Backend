package lk.creativelabs.jobseekers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserCredentials{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String username;
     private String password;
     private String userId;
     private String role;
     public UserCredentials(String username, String password, String userId, String role) {
          this.username = username;
          this.password = password;
          this.userId = userId;
          this.role = role;
     }


}
