package com.example.jaz27454nbp;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class Jaz27454NbpErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() == HttpStatusCode.valueOf(404))
            throw new NotFoundException();
        else if (response.getStatusCode() == HttpStatusCode.valueOf(400))
            throw new BadRequestException();
    }

}
