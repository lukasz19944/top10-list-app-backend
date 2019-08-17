package pl.slusarski.top10listappbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListNotFoundException extends RuntimeException {

    public ListNotFoundException(String message) {
        super(message);
    }
}
