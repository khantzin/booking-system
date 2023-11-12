package com.kz.bookingsystem.service;

import com.kz.bookingsystem.common.GenericService;
import com.kz.bookingsystem.entity.BSPackage;

import java.util.List;

public interface PackageService {

    GenericService<List<BSPackage>> getAvailablePackage();
}
