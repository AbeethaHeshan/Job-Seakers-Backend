package lk.creativelabs.jobseekers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCredentialsDTO {
     private String id;
     private String username;
     private String password;
     private String role;
     private String userId;

     public UserCredentialsDTO(String username, String password, String role, String userId) {
          this.username = username;
          this.password = password;
          this.role = role;
          this.userId = userId;
     }

     public UserCredentialsDTO(String username, String password) {
          this.username = username;
          this.password = password;
     }


     public UserCredentialsDTO(String username, String userId, String role) {
          this.username = username;
          this.role = role;
          this.userId = userId;
     }
}
