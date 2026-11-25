package com.danila.dolgov.auction.liveauction.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Сущность ставок.
 */
@Getter
@Setter
@Table("bids")
public class BidsEntity {

    /**
     * Уникальный идентификатор ставки
     */
    private Long id;

    /**
     * Идентификатор лота, к которому относится ставка
     */
    private Long lotId;

    /**
     * Участник, сделавший ставку
     */
    private String bidder;

    /**
     * Сумма ставки
     */
    private BigDecimal amount;

    /**
     * Время размещения ставки
     */
    private OffsetDateTime createdAt;
}