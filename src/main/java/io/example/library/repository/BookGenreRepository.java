package io.example.library.repository;

import io.example.library.domain.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenre, Integer> {
}
