package com.kz.bookingsystem.repository;

import com.kz.bookingsystem.entity.BSBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BSBooking, Integer> {

    Optional<BSBooking> findByBsClassidAndUserPackageId(Integer bsClassId, Integer userPackageId);
}
