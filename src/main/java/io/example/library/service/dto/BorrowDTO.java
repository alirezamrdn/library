package io.example.library.service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BorrowDTO implements Serializable {
    BookDTO book;
    Instant from;
    Instant to;
}
