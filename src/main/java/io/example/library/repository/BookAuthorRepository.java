package io.example.library.repository;

import io.example.library.domain.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
}
