package lk.creativelabs.jobseekers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity



public class Rating {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long rateId;
   private int ratingStars;
   @Column(name = "rateFrom",nullable = true)
   private String from;
   @Column(name = "rateTo",nullable = true)
   private String to;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "employeeId")
   private Employee employee;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "clientId")
   private Client client;


}
