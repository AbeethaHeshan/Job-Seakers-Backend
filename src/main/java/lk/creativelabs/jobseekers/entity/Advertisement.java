package lk.creativelabs.jobseekers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advertisement {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     long advertisementId;
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
     String clientUserId;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "categoryId")
     JobCategory jobCategory;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "clientId")
     Client client;

}
