package io.example.library.service.mapper;

import io.example.library.domain.Gender;
import io.example.library.service.dto.GenderDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

/**
 * @author <a href="mailto:alirezamardani@gmail.com">Alireza Mardani</a>
 * @version 0.0.1
 */
@Mapper(componentModel = "spring")
public interface GenderMapper extends EntityMapper<GenderDTO, Gender> {
    @ValueMapping(source = "m", target = "MALE")
    @ValueMapping(source = "f", target = "FEMALE")
    @ValueMapping(source = "d", target = "DIVERSE")
    Gender toEntity(GenderDTO dto);

    @Override
    @InheritInverseConfiguration
    GenderDTO toDto(Gender entity);
}
