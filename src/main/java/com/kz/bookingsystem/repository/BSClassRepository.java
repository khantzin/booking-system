package com.kz.bookingsystem.repository;

import com.kz.bookingsystem.entity.BSClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BSClassRepository extends JpaRepository<BSClass, Integer> {

    Optional<BSClass> findByCode(String code);
}
