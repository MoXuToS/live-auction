package com.danila.dolgov.auction.liveauction.repository;

import com.danila.dolgov.auction.liveauction.entity.LotsEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий лотов.
 */
@Repository
public interface LotRepository extends R2dbcRepository<LotsEntity, Long> {
}
