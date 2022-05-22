package io.example.library.repository;

import io.example.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.borrows.size > 1")
    List<User> findAtLeastOneBookBorrowers();
    @Query("SELECT u FROM User u WHERE u.borrows.size = 0 and (u.membership.to = null or u.membership.to >= CURRENT_DATE)")
    List<User> findAllBorrowNothingMembers();
    @Query("SELECT u FROM User u JOIN Borrow b ON u.id = b.borrower where b.from = :fromDate")
    List<User> findBorrowsByDate(@Param("fromDate") Instant fromDate);
}
