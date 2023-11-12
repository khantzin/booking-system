package com.kz.bookingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bs_class", uniqueConstraints = {@UniqueConstraint(columnNames = {"code"}, name = "bs_class_code")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BSClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "total_slot", nullable = false, length = 10)
    private Integer slot;

    @Column(name = "booked_slot", nullable = false, length = 10)
    private Integer bookedSlot;

    @Column(name = "country_id", nullable = false, length = 20)
    private Integer countryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", updatable = false, insertable = false)
    private Country country;


    public void addBookedSlot(){
        this.bookedSlot = this.bookedSlot + 1;
    }

    public void substractBookedSlot() {
        this.bookedSlot = this.bookedSlot - 1;
    }

    public Integer availabelSlot() {
        return this.slot - this.bookedSlot;
    }
}
