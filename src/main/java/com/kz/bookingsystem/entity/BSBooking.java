package com.kz.bookingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bs_booking")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BSBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bs_class_id", nullable = false, length = 20)
    private Integer bsClassid;

    @Column(name = "user_package_id", nullable = false, length = 20)
    private Integer userPackageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bs_class_id", insertable = false, updatable = false)
    private BSClass bsClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_package_id", insertable = false, updatable = false)
    private BSUserPackage bsUserPackage;
}
