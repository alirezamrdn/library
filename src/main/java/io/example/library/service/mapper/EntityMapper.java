package io.example.library.service.mapper;

import java.util.List;

/**
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 * @author <a href="mailto:alirezamardani@gmail.com">Alireza Mardani</a>
 * @version 0.0.1
 * <p>
 * Contract for a generic dto to entity mapper.
 */

public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
