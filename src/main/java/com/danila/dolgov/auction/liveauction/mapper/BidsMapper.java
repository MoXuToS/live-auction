package com.danila.dolgov.auction.liveauction.mapper;

import com.danila.dolgov.auction.liveauction.entity.BidsEntity;
import com.danila.dolgov.auction.liveauction.model.BidRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * Маппер ставок.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BidsMapper {

    /**
     * Преобразовать в сущность.
     * @param bidRequest запрос ставки.
     * @return сущность
     */
    @Mapping(target = "id", ignore = true)
    BidsEntity toEntity(BidRequest bidRequest);

    /**
     * Преобразовать в ДТО.
     * @param bidsEntity сущность
     * @return дто
     */
    BidRequest fromEntity(BidsEntity bidsEntity);

}
