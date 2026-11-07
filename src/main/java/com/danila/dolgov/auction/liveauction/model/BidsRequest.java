package com.danila.dolgov.auction.liveauction.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class BidsRequest {

    Long auctionId;

    String bidder;

    BigDecimal amount;

    String createdAt;
}
