package tutorial.javari.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Empty Zoo")
public class EmptyZooException extends RuntimeException {

}

