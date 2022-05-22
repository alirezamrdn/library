package io.example.library.service;

import io.example.library.service.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(List<BookDTO> bookDTOs);
    Optional<BookDTO> find(BookDTO bookDTO);
}
