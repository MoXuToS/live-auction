package com.danila.dolgov.auction.liveauction.mapper;

import com.danila.dolgov.auction.liveauction.entity.BidsEntity;
import com.danila.dolgov.auction.liveauction.model.BidsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BidsMapper {

    BidsEntity fromBidsRequest(BidsRequest bidsRequest);
}
