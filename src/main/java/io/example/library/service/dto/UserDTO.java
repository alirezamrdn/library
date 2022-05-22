package io.example.library.service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO implements Serializable {
    Integer id;
    String firstName;
    String lastName;
    List<BorrowDTO> borrows;
    Instant membershipFrom;
    Instant membershipTo;
    GenderDTO gender;
}
