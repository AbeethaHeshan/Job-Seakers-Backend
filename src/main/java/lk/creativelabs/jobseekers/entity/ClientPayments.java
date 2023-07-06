package lk.creativelabs.jobseekers.entity;

import lk.creativelabs.jobseekers.entity.emberded.ClientEmployeeID;
import lk.creativelabs.jobseekers.entity.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_payments")
public class ClientPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

}
