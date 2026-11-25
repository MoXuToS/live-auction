package com.danila.dolgov.auction.liveauction.model;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Запрос на создание ставки
 * @param lotId Идентификатор лота, к которому относится ставка
 * @param bidder Участник, сделавший ставку
 * @param amount Сумма ставки
 * @param createdAt Время размещения ставки
 */
public record BidRequest(Long lotId, @NotBlank String bidder, BigDecimal amount, OffsetDateTime createdAt) {
}
