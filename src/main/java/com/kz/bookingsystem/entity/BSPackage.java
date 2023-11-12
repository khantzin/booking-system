package com.kz.bookingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bs_package")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BSPackage {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "credit", nullable = false, length = 20)
    private Integer credit;

    @Column(name = "country_id", nullable = false, length = 20)
    private Integer countryId;

    @Column(name = "expired_date")
    private Date expiredDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;
}
