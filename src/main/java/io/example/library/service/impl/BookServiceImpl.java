package io.example.library.service.impl;

import io.example.library.domain.Book;
import io.example.library.domain.BookAuthor;
import io.example.library.domain.BookGenre;
import io.example.library.domain.BookPublisher;
import io.example.library.repository.BookAuthorRepository;
import io.example.library.repository.BookGenreRepository;
import io.example.library.repository.BookPublisherRepository;
import io.example.library.repository.BookRepository;
import io.example.library.service.dto.BookDTO;
import io.example.library.service.mapper.BookMapper;
import io.example.library.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final BookGenreRepository bookGenreRepository;
    private final BookPublisherRepository bookPublisherRepository;
    private final BookMapper bookMapper;
    @Override
    public void save(List<BookDTO> bookDTOs) {
        List<Book> bookList = bookMapper.toEntity(bookDTOs);
        for (Book b : bookList) {
            findOrSaveAuthor(b);
            findOrSavePublisher(b);
            findOrSaveGenre(b);
        }
        bookRepository.saveAll(bookList);
    }

    private void findOrSaveAuthor(Book b) {
        Optional<BookAuthor> result = bookAuthorRepository.findOne(Example.of(b.getBookAuthor()));
        result.ifPresent(b::setBookAuthor);
        if (result.isEmpty()) {
            b.setBookAuthor(bookAuthorRepository.save(b.getBookAuthor()));
        }
    }

    private void findOrSaveGenre(Book b) {
        Optional<BookGenre> result = bookGenreRepository.findOne(Example.of(b.getBookGenre()));
        result.ifPresent(b::setBookGenre);
        if (result.isEmpty()) {
            b.setBookGenre(bookGenreRepository.save(b.getBookGenre()));
        }
    }

    private void findOrSavePublisher(Book b) {
        Optional<BookPublisher> result = bookPublisherRepository.findOne(Example.of(b.getBookPublisher()));
        result.ifPresent(b::setBookPublisher);
        if (result.isEmpty()) {
            b.setBookPublisher(bookPublisherRepository.save(b.getBookPublisher()));
        }
    }

    @Override
    public Optional<BookDTO> find(BookDTO bookDTO) {
        return Optional.of(bookMapper.toDto(bookRepository.findOne(Example.of(bookMapper.toEntity(bookDTO))).orElse(null)));
    }
}
