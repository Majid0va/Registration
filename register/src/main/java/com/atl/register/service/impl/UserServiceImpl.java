package com.atl.register.service.impl;

import com.atl.register.dto.UserDto;
import com.atl.register.model.User;
import com.atl.register.mpper.UserMapper;
import com.atl.register.repository.UserRepository;
import com.atl.register.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void register(UserDto userDto) throws RuntimeException {

        if (checkIfUserExist(userDto.getEmail())) {
            throw new RuntimeException("User already exists for this email");
        }
        User user = UserMapper.MAPPER.dtoToModel(userDto);
        encodePassword(user, userDto);
        userRepository.save(user);
    }

//    @Override
//    public void save(UserDto userDto) {
//        User user = UserMapper.MAPPER.dtoToModel(userDto);
//        userRepository.save(user);
//    }


    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null ? true : false;
    }

    private void encodePassword(User userEntity, UserDto user) {
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}

