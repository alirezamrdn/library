package io.example.library.service;

import io.example.library.service.dto.UserDTO;

import java.time.Instant;
import java.util.List;

public interface UserService {
    void save(List<UserDTO> userDTOs);

    List<UserDTO> findAtLeastOneBookBorrowers();

    List<UserDTO> findAllBorrowNothingMembers();

    List<UserDTO> findBorrowers(Instant fromDate);
}
