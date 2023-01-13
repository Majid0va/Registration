package com.atl.register.service;

import com.atl.register.dto.UserDto;

public interface UserService {
    void register(UserDto userDto);

    public boolean checkIfUserExist(String email);

//    void save(UserDto userDto);
}
