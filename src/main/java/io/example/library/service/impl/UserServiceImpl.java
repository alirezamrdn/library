package io.example.library.service.impl;

import io.example.library.domain.*;
import io.example.library.repository.*;
import io.example.library.service.UserService;
import io.example.library.service.dto.UserDTO;
import io.example.library.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(List<UserDTO> userDTOs) {
        List<User> entities = userMapper.toEntity(userDTOs);
        entities.forEach(e -> {
            e.getMembership().setUser(e);
            e.getBorrows().forEach(b -> {
                b.setBorrower(e);
            });
        });
        userRepository.saveAll(entities);
    }

    @Override
    public List<UserDTO> findAtLeastOneBookBorrowers() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public List<UserDTO> findAllBorrowNothingMembers() {
        return null;
    }

    @Override
    public List<UserDTO> findBorrowers(Instant fromDate) {
        return null;
    }

    @Override
    public List<UserDTO> findBorrowers(UserDTO user, Range<Instant> dateRange) {
        return null;
    }

    @Override
    public List<UserDTO> findAllNotBorrowedBooks() {
        return null;
    }
}
