package lk.creativelabs.jobseekers.entity;

import lk.creativelabs.jobseekers.entity.emberded.Address;
import lk.creativelabs.jobseekers.entity.enums.ApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  clientId;
    private String owner;
    private String businessName;
    private String businessType;
    @Embedded
    private Address address;
    private String businessRegistrationDocUri;
    private String businessRegistrationNo;
    private String email;
    private String tel;
    private String profileImageUri;
    private String userId;
    private String role;



    @Column(name = "approval_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    Employee employee;

    @ManyToMany(mappedBy = "clientset")
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany(mappedBy = "clientEmp")
    private Set<Employee> clientEmp = new HashSet<>();

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Rating rate;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Application> applications = new HashSet<>();
}
