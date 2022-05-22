package io.example.library.web.rest;

import io.example.library.service.UserService;
import io.example.library.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

import static io.example.library.web.util.UrlConstants.AT_LEAST_ONE_BOOK_BORROWERS;
import static io.example.library.web.util.UrlConstants.GLOBAL_URL;

@RestController
@RequestMapping(GLOBAL_URL)
@Slf4j
public class UserResource {
    @Autowired
    UserService membershipService;

    @GetMapping(AT_LEAST_ONE_BOOK_BORROWERS)
    public List<UserDTO> findAtLeastOneBookBorrowers() throws URISyntaxException {
        log.debug("REST request to get findAtLeastOneBookBorrowers");
        return membershipService.findAtLeastOneBookBorrowers();
    }
}
