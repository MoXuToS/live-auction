package com.danila.dolgov.auction.liveauction.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Table("bids")
public class BidsEntity {

    @Id
    private Long id;

    private Long auctionId;

    private String bidder;

    private BigDecimal amount;

    private OffsetDateTime createdAt;
}
