package io.example.library.service;

import io.example.library.service.dto.BookDTO;
import io.example.library.service.dto.UserDTO;
import org.springframework.data.domain.Range;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(List<BookDTO> bookDTOs);
    Optional<BookDTO> find(BookDTO bookDTO);
    List<BookDTO> findBooks(UserDTO user, Range<Instant> dateRange);
    List<BookDTO> findAllNotBorrowedBooks();
}
