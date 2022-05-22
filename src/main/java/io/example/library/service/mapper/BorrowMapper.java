package io.example.library.service.mapper;

import io.example.library.domain.Borrow;
import io.example.library.service.dto.BorrowDTO;
import org.mapstruct.Mapper;

/**
 * @author <a href="mailto:alirezamardani@gmail.com">Alireza Mardani</a>
 * @version 0.0.1
 */
@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface BorrowMapper extends EntityMapper<BorrowDTO, Borrow> {
}
