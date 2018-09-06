package com.motokyi.choiceness.telegram.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Slf4j(topic = "RTI")
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        log.info("{}:::{}", request.getMethodValue(), request.getURI());
        log.info("Body:::{}", new String(body));
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}

