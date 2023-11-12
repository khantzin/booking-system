package com.kz.bookingsystem.service;

import com.kz.bookingsystem.common.GenericService;
import com.kz.bookingsystem.data.BSClassData;
import com.kz.bookingsystem.dto.BSClassDTO;

import java.util.List;

public interface BSClassService {

    GenericService<Integer> save(BSClassDTO bsClassDTO);

    GenericService<List<BSClassData>> getAllClasses();
}
