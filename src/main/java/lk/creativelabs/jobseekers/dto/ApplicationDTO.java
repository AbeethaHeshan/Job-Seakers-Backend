package lk.creativelabs.jobseekers.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApplicationDTO {
    String name;
    String address;
    String dateOfBirth;
    String email;
    String telOne;
    String telTwo;
    String workingType;
    String cvUri;
    String additionalQualifications;
    String userId;
    String jobCatogary;
}
