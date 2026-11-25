package com.danila.dolgov.auction.liveauction.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Value
@Schema(description = "Сообщение об ошибке")
public class ErrorMessage {

    @Schema(description = "Код ошибки")
    String errorCode;

    @Schema(description = "Подробное описание ошибки")
    String description;

    @Schema(description = "Сообщение для пользователя")
    String localizedMessage;

    @Schema(description = "Дата и время возникновения ошибки", example = "2026-11-25T12:00:00+03:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssxxx")
    OffsetDateTime timestamp;

    public ErrorMessage(Exception exception, String localizedMessage) {
        this.errorCode = exception.getClass().getSimpleName().replace("Exception", "Error");
        this.description = exception.getLocalizedMessage();
        this.localizedMessage = localizedMessage;
        this.timestamp = OffsetDateTime.now(ZoneId.systemDefault());
    }
}
