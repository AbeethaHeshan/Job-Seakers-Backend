package lk.creativelabs.jobseekers.entity.emberded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEmployeeID  implements Serializable {
    @Column(name="client_Id")
    private String clientId;
    @Column(name="employee_Id")
    private String employeeId;
}
