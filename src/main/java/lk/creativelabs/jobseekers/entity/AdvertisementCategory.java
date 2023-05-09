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
public class AdvertisementCategory {
    @Id
    String categoryId;
    String advertisementType;
    String title;

    @OneToMany(mappedBy = "advertisementCategory", cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

}
