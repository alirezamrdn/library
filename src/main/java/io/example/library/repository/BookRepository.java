package io.example.library.repository;

import io.example.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b JOIN Borrow br ON br.book = b.id JOIN User u ON br.borrower = u.id where u.firstName=:firstName and u.lastName= :lastName and br.from between :fromDate and :toDate")
    List<Book> findAllBorrowedBooks(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("fromDate") Instant fromDate, @Param("toDate") Instant toDate);

    @Query("SELECT b FROM Book b WHERE b.id not in (SELECT br.book.id FROM Borrow br)")
    List<Book> findAllNotBorrowed();
}
