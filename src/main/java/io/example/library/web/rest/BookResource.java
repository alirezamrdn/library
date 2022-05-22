package io.example.library.web.rest;

import io.example.library.service.BookService;
import io.example.library.service.dto.BookDTO;
import io.example.library.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import static io.example.library.web.util.UrlConstants.*;

@RestController
@RequestMapping(GLOBAL_BOOK_URL)
@Slf4j
public class BookResource {
    @Autowired
    BookService BookService;

    @GetMapping(BOOK__FIND_BY_USER_DATE)
    public List<BookDTO> findByUserDate(@RequestParam("fromDate") @DateTimeFormat(pattern = "MM/dd/yyyy") Date fromDate,
                                        @RequestParam("toDate") @DateTimeFormat(pattern = "MM/dd/yyyy") Date toDate,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName) throws URISyntaxException {
        log.debug("REST request to get findByUserDate");
        return BookService.findBooks(UserDTO.builder().firstName(firstName).lastName(lastName).build(),
                Range.open(fromDate.toInstant(), toDate.toInstant()));
    }

    @GetMapping(BOOK__NOT_BORROWED)
    public List<BookDTO> findAllNotBorrowedBooks() throws URISyntaxException {
        log.debug("REST request to get findAllNotBorrowedBooks");
        return BookService.findAllNotBorrowedBooks();
    }

}
