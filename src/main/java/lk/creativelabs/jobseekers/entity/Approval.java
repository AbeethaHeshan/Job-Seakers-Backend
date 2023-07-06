package lk.creativelabs.jobseekers.entity;

import lk.creativelabs.jobseekers.entity.enums.ApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long approvalId;

    @Enumerated(EnumType.STRING)
    @Column(name = "approvalStatus", columnDefinition = "varchar(30) default 'PENDING'")
    ApprovalStatus approvalStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicationId")
    private Application application;
}
