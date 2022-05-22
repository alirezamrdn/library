package io.example.library.service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDTO implements Serializable {
    Integer id;
    String name;
    String bookAuthor;
    String bookGenre;
    String bookPublisher;
}
