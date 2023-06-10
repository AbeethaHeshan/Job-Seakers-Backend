package lk.creativelabs.jobseekers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  long categoryId;
   private  String jobType;  //hotel and services , IT
   private  String serviceType;    // waiter , associate engineer

    @OneToMany(mappedBy = "jobCategory", cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

}
