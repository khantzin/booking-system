package com.kz.bookingsystem.repository;

import com.kz.bookingsystem.entity.BSUserPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPackageRepository extends JpaRepository<BSUserPackage, Integer> {

    List<BSUserPackage> getBSUserPackageByUserId(Integer userId);
}
