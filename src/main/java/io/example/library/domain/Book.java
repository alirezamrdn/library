package io.example.library.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    @NonNull
    String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;
    @NonNull
    @ManyToOne
    BookAuthor bookAuthor;
    @NonNull
    @ManyToOne
    BookGenre bookGenre;
    @NonNull
    @ManyToOne
    BookPublisher bookPublisher;
}
