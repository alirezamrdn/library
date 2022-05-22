package io.example.library.service.mapper;

import io.example.library.domain.Book;
import io.example.library.service.dto.BookDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author <a href="mailto:alirezamardani@gmail.com">Alireza Mardani</a>
 * @version 0.0.1
 */
@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<BookDTO, Book> {
    @Override
    @Mapping(source = "bookAuthor", target = "bookAuthor.name")
    @Mapping(source = "bookGenre", target = "bookGenre.name")
    @Mapping(source = "bookPublisher", target = "bookPublisher.name")
    Book toEntity(BookDTO dto);

    @Override
    @InheritInverseConfiguration
    BookDTO toDto(Book entity);
}
