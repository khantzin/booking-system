package com.kz.bookingsystem.service;

import com.kz.bookingsystem.common.GenericService;
import com.kz.bookingsystem.dto.ChangePasswordDTO;
import com.kz.bookingsystem.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    GenericService<Long> save(UserDTO request);

    GenericService<UserDTO> getUserByID(Integer id);

    GenericService<List<UserDTO>> getAllUsers();

    GenericService<Integer> updaetPassword(ChangePasswordDTO request);
}
