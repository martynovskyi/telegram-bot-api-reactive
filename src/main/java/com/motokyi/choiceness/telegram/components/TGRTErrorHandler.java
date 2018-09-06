package com.motokyi.choiceness.telegram.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Slf4j
@Component
public class TGRTErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response)
            throws IOException {
        return response.getStatusCode() != HttpStatus.OK;
    }

    @Override
    public void handleError(ClientHttpResponse response)
            throws IOException {

//        log.info("Body:::{}",  IOUtils.toString(response.getBody(), Charset.defaultCharset()));


    }
}
