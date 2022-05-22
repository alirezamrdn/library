package io.example.library.service.mapper;

import io.example.library.domain.User;
import io.example.library.service.dto.UserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author <a href="mailto:alirezamardani@gmail.com">Alireza Mardani</a>
 * @version 0.0.1
 */
@Mapper(componentModel = "spring", uses = {BorrowMapper.class, GenderMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User> {
    @Override
    @Mapping(source = "membershipFrom", target = "membership.from")
    @Mapping(source = "membershipTo", target = "membership.to")
    User toEntity(UserDTO dto);

    @Override
    @InheritInverseConfiguration
    UserDTO toDto(User entity);
}
