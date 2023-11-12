package com.kz.bookingsystem.service;

import com.kz.bookingsystem.common.GenericService;
import com.kz.bookingsystem.dto.BuyPackageDTO;
import com.kz.bookingsystem.entity.BSUserPackage;

import java.util.List;

public interface UserPackageService  {

    GenericService<Integer> buyUserPackge(BuyPackageDTO buyPackageDTO);

    GenericService<List<BSUserPackage>> getUserPackageByUserId(Integer userId);
}
