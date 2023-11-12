package com.kz.bookingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bs_user_package")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BSUserPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "package_id", nullable = false, length = 20)
    private Integer packageId;

    @Column(name = "user_id", nullable = false, length = 20)
    private Integer userId;

    @Column(name = "credit", nullable = false, length = 10)
    private Integer credit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", insertable = false, updatable = false)
    private BSPackage bsPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public void reduceCredit() {
        this.credit = this.credit - 1;
    }

    public void increaseCredit(){
        this.credit =this.credit + 1;
    }
}
