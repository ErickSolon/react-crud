package br.com.reactcrud.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Usuário não encontrado");
    }
}
