package exceptions;

import org.springframework.http.HttpStatus;

public class ReponseException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ReponseException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
