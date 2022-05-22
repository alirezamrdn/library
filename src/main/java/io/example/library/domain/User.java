package io.example.library.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;
    String firstName;
    String lastName;
    Gender gender;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Membership membership;
    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    List<Borrow> borrows;
}
