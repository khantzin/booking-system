package com.kz.bookingsystem.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class BSClassData {
    private Integer id;
    private String code;
    private String name;
    private Integer totalSlot;
    private Integer bookedSlot;
    private Integer availabelSlot;
    private String countryName;
}
