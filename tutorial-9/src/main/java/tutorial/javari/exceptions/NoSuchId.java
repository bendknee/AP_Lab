package tutorial.javari.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No matching animal ID Found")
public class NoSuchId extends RuntimeException {}

