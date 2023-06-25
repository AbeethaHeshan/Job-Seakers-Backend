package lk.creativelabs.jobseekers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvertiesmentDTO {

    String title;
    String period;
    String workingType;
    double hourlyRate;
    String experienceLevel;
    String clarification;
    String jobType;
    String description;
    LocalDate startDate;
    LocalDate endDate;



}
