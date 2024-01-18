package com.motokyi.tg.bot_api.exception;

import com.motokyi.tg.bot_api.api.type.Response;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TooManyRequestsException extends RuntimeException {
    private final Response<Void> errorResponse;
}
