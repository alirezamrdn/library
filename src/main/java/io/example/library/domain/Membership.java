package io.example.library.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbl_membership")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Membership implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Integer id;
    @OneToOne
    User user;
    @NonNull
    @Column(name = "membership_from")
    Instant from;
    @Column(name = "membership_to")
    Instant to;
}
