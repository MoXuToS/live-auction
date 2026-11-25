package com.danila.dolgov.auction.liveauction.controller;

import com.danila.dolgov.auction.liveauction.model.ErrorMessage;
import com.danila.dolgov.auction.liveauction.model.LotRequest;
import com.danila.dolgov.auction.liveauction.service.LotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Контроллер лотов.
 */
@Service
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lots")
@Tag(name = "Лоты", description = "Управление аукционными лотами")
public class LotController {

    private final LotService lotService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Создать лот",
            description = "Создаёт новый аукционный лот."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Лот успешно создан", content = @Content),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некорректные данные запроса или ошибка валидации",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorMessage.class)
                    )
            )
    })
    public Mono<Void> createLot(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Данные нового лота", required = true)
            @Valid @RequestBody LotRequest lotRequest) {
        return lotService.createLot(lotRequest);
    }

}
