package io.example.library.repository;

import io.example.library.domain.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Integer> {
}
