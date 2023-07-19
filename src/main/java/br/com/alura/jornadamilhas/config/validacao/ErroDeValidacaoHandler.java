package br.com.alura.jornadamilhas.config.validacao;

import br.com.alura.jornadamilhas.exception.DatabaseException;
import br.com.alura.jornadamilhas.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    private final MessageSource messageSource;

    public ErroDeValidacaoHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroJsonDto> handle(MethodArgumentNotValidException exception) {
        List<ErroJsonDto> erroJsonDtoList = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroJsonDto erro = new ErroJsonDto(0L, e.getField(), mensagem);
            erroJsonDtoList.add(erro);
        });
        return erroJsonDtoList;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroPadraoDto> recursoNaoEncontrado(ResourceNotFoundException e, HttpServletRequest request) {
        ErroPadraoDto err = new ErroPadraoDto();
        HttpStatus status = HttpStatus.NOT_FOUND;
        err.setDataHora(Instant.now());
        err.setStatus(status.value());
        err.setErro("Resource not found");
        err.setMensagem(e.getMessage());
        err.setCaminho(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErroPadraoDto> database(DatabaseException e, HttpServletRequest request) {
        ErroPadraoDto err = new ErroPadraoDto();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        err.setDataHora(Instant.now());
        err.setStatus(status.value());
        err.setErro("Database exception");
        err.setMensagem(e.getMessage());
        err.setCaminho(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}

