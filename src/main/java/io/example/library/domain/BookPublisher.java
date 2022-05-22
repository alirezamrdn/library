package io.example.library.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_book_publisher")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookPublisher implements Serializable {
    String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Integer id;
}
