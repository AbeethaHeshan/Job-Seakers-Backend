package lk.creativelabs.jobseekers.entity.emberded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
        private String street;
        private String city;
        private String state;
        private String zipCode;
}
