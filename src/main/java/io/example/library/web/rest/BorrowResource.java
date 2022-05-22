package io.example.library.web.rest;

import io.example.library.service.UserService;
import io.example.library.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(GLOBAL_BORROW_URL)
@Slf4j
public class BorrowResource {
    @Autowired
    UserService userService;

    @GetMapping(BORROWER__AT_LEAST_ONE_BOOK_BORROWERS)
    public List<UserDTO> findAtLeastOneBookBorrowers() throws URISyntaxException {
        log.debug("REST request to get findAtLeastOneBookBorrowers");
        return userService.findAtLeastOneBookBorrowers();
    }

    @GetMapping(BORROWER__NON_TERMINATED_USERS_WITHOUT_BORROWING)
    public List<UserDTO> findAllBorrowNothingMembers() throws URISyntaxException {
        log.debug("REST request to get findAllBorrowNothingMembers");
        return userService.findAllBorrowNothingMembers();
    }

    @GetMapping(BORROWER__FIND_BY_DATE)
    public List<UserDTO> findBorrows(@RequestParam("fromDate") @DateTimeFormat(pattern = "MM/dd/yyyy") Date fromDate) throws URISyntaxException {
        log.debug("REST request to get findBorrowers");
        return userService.findBorrowers(fromDate.toInstant());
    }
}
