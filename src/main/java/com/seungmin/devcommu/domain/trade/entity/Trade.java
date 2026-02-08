package com.seungmin.devcommu.domain.trade.entity;

import com.seungmin.devcommu.common.entity.BaseEntity;
import com.seungmin.devcommu.domain.user.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class Trade extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    private String title;
    private String description;
    private BigDecimal price;

    @ManyToOne
    private User user;
}
