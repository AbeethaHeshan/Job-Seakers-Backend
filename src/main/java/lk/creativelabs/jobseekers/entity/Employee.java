package lk.creativelabs.jobseekers.entity;

import lk.creativelabs.jobseekers.entity.emberded.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import lk.creativelabs.jobseekers.util.RandomIdGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long  employeeId;
    private String name;
    @Embedded
    private Address address;
    private LocalDate dateOfBirth;
    private String email;
    private String tel;
    private String profileImageUri;
    private String workingType;
    private String jobType;
    private String userId;
    private String role;


    public Employee(String name, Address address, LocalDate dateOfBirth, String email, String tel, String profileImageUri, String workingType, String jobType, String userId, String role) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.tel = tel;
        this.profileImageUri = profileImageUri;
        this.workingType = workingType;
        this.jobType = jobType;
        this.userId = userId;
        this.role = role;
    }


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Application> applications = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "client_payments",
            joinColumns = @JoinColumn(name = "employee_Id"),
            inverseJoinColumns = @JoinColumn(name = "client_Id"))
    private Set<Client> clientset = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_client",
            joinColumns = @JoinColumn(name = "employee_Id"),
            inverseJoinColumns = @JoinColumn(name = "client_Id"))
    private Set<Client> clientEmp = new HashSet<>();

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rating rate;

}
