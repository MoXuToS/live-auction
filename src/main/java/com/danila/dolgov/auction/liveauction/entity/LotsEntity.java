package com.danila.dolgov.auction.liveauction.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.danila.dolgov.auction.liveauction.enums.LotStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("lots")
public class LotsEntity {

    /**
     * Уникальный идентификатор лота
     */
    @Id
    private Long id;

    /**
     * Название лота
     */
    private String title;

    /**
     * Стартовая цена лота
     */
    private BigDecimal startPrice;

    /**
     * Минимальный шаг повышения ставки
     */
    private BigDecimal minStep;

    /**
     * Текущая цена лота (NULL, пока нет ставок)
     */
    private BigDecimal currentPrice;

    /**
     * Текущий лидер торгов (NULL, пока нет ставок)
     */
    private String leader;

    /**
     * Статус лота: OPEN, CLOSED и т.д.
     */
    private LotStatus status;

    /**
     * Время окончания торгов по лоту
     */
    private OffsetDateTime endsAt;

    /**
     * Время создания лота
     */
    private OffsetDateTime createdAt;

    /**
     * Версия записи для оптимистичной блокировки
     */
    private Long version;
}