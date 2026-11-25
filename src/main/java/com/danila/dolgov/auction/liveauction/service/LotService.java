package com.danila.dolgov.auction.liveauction.service;

import com.danila.dolgov.auction.liveauction.entity.LotsEntity;
import com.danila.dolgov.auction.liveauction.mapper.LotsMapper;
import com.danila.dolgov.auction.liveauction.model.LotRequest;
import com.danila.dolgov.auction.liveauction.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.time.ZoneId;

/**
 * Сервис по работе с логами
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LotService {

    private final LotRepository lotRepository;
    private final LotsMapper lotsMapper;

    /**
     * Зарегистрировать лот.
     * @param lotRequest заявка на создание лота
     */
    public Mono<Void> createLot(LotRequest lotRequest) {
        Assert.isTrue(OffsetDateTime.now(ZoneId.systemDefault()).isBefore(lotRequest.endsAt()),
                "Время окончания лота должно быть в будущем");
        LotsEntity lotsEntity = lotsMapper.toEntity(lotRequest);
        lotRepository.save(lotsEntity);

        log.info("Успешно зарегистрировали лот: {} со сроком до: {}", lotRequest.title(), lotRequest.endsAt());
        return Mono.empty();
    }
}
