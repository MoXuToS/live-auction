package com.danila.dolgov.auction.liveauction.handlers;

import com.danila.dolgov.auction.liveauction.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * Глобальный перехватчик ошибок.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param ex ошибка валидации или некорректный аргумент
     * @return сообщение об ошибке
     */
    @ExceptionHandler({IllegalArgumentException.class, WebExchangeBindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleBadRequest(Exception ex) {
        log.warn("Пользователь пытался ввести не корректные данные: {}", ex.getMessage());
        return new ErrorMessage(ex, "Введенные данные не корректны. Измените параметры запроса.");
    }
}
