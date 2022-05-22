package io.example.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_book_author")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthor implements Serializable {
    String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;
}
