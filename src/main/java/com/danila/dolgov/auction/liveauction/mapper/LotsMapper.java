package com.danila.dolgov.auction.liveauction.mapper;

import com.danila.dolgov.auction.liveauction.entity.LotsEntity;
import com.danila.dolgov.auction.liveauction.model.LotRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * Маппер лотов.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LotsMapper {

    /**
     * Преобразовать в сущность.
     * @param lotRequest запрос ставки
     * @return сущность
     */
    @Mapping(target = "id", ignore = true)
    LotsEntity toEntity(LotRequest lotRequest);

    /**
     * Преобразовать в ДТО.
     * @param lotsEntity сущность
     * @return лот
     */
    LotRequest fromEntity(LotsEntity lotsEntity);

}
