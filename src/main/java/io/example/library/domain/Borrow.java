package io.example.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbl_borrow")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Borrow implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    User borrower;
    @ManyToOne
    Book book;
    @Column(name = "borrow_from")
    Instant from;
    @Column(name = "borrow_to")
    Instant to;
}
