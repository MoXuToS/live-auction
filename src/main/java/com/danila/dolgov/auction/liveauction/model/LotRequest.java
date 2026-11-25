package com.danila.dolgov.auction.liveauction.model;

import com.danila.dolgov.auction.liveauction.enums.LotStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Schema(description = "Данные для создания аукционного лота")
public record LotRequest(
        @NotBlank
        @Schema(description = "Название лота", example = "Картина «Утро»", requiredMode = Schema.RequiredMode.REQUIRED)
        String title,
        @Schema(description = "Стартовая цена лота", example = "10000.00")
        BigDecimal startPrice,
        @Schema(description = "Минимальный шаг повышения ставки", example = "500.00")
        BigDecimal minStep,
        @Schema(description = "Текущая цена лота", example = "10000.00")
        BigDecimal currentPrice,
        @Schema(description = "Текущий лидер торгов; может отсутствовать у нового лота", example = "user123")
        String leader,
        @Schema(description = "Статус лота", example = "OPEN")
        LotStatus status,
        @Schema(description = "Дата и время окончания торгов", example = "2027-12-31T18:00:00+03:00")
        OffsetDateTime endsAt,
        @Schema(description = "Дата и время создания лота", example = "2026-11-25T12:00:00+03:00")
        OffsetDateTime createdAt,
        @Schema(description = "Версия записи для оптимистичной блокировки", example = "0")
        Long version) {
}
