package com.kz.bookingsystem.repository;

import com.kz.bookingsystem.entity.BSPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<BSPackage, Integer> {

}
