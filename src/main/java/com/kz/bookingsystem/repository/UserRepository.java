package com.kz.bookingsystem.repository;

import com.kz.bookingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUseridAndPassword(String userid, String password);
    Optional<User> findUserByUserid(String userid);
}
