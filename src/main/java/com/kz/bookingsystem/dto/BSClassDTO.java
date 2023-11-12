package com.kz.bookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BSClassDTO {

    private Integer id;
    private String code;
    private String name;
    private Integer totalSlot;
    private Integer countryId;
}
