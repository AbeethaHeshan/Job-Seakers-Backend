package lk.creativelabs.jobseekers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advertisement {

     @Id
     String advertisementId;
     String title;
     String period;
     String workingType;
     double hourlyRate;
     String experienceLevel;
     String clarification;
     String description;
     LocalDate startDate;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "categoryId")
     AdvertisementCategory advertisementCategory;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "clientId")
     Client client;

}
