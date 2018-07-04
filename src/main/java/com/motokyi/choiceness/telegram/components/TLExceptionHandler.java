package com.motokyi.choiceness.telegram.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TLExceptionHandler extends DefaultResponseErrorHandler {

    private final ObjectMapper mapper;

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        String s = IOUtils.toString(response.getBody(), "UTF-8");
        log.error("Telegram API {} {} : {}", response.getStatusText(), response, s);
    }

}
