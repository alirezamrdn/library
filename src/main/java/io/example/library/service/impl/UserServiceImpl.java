package io.example.library.service.impl;

import io.example.library.domain.Borrow;
import io.example.library.domain.User;
import io.example.library.repository.UserRepository;
import io.example.library.service.UserService;
import io.example.library.service.dto.BookDTO;
import io.example.library.service.dto.UserDTO;
import io.example.library.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
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
        return userMapper.toDto(userRepository.findAtLeastOneBookBorrowers());
    }

    @Override
    public List<UserDTO> findAllBorrowNothingMembers() {
        return userMapper.toDto(userRepository.findAllBorrowNothingMembers());
    }

    @Override
    public List<UserDTO> findBorrowers(Instant fromDate) {
        return userMapper.toDto(userRepository.findBorrowsByDate(fromDate));
    }
}
