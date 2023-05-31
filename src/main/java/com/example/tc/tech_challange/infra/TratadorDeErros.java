package com.example.tc.tech_challange.infra;

import com.example.tc.tech_challange.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;


//CONHECIDA COIMO GLOBAL EXCEPTION HANDLER


@RestControllerAdvice
public class TratadorDeErros extends ResponseEntityExceptionHandler {

        // tratar respostas erros - as veizz e bom criar as proprias excessoes que ja sabemos
        @ExceptionHandler(EntityNotFoundException.class)
         ProblemDetail handleNumeroNaoInformadoException(ValidacaoException e){

            //CRIAMOS UM  DETAIL E PODEMOS MANIPULAR - CRIAR VARIAVEIS EM CLASEES
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_ACCEPTABLE, e.getLocalizedMessage());
            problemDetail.setDetail("Erro detail");

            problemDetail.setProperty("Categoria", " tt");
            problemDetail.setProperty("TimeStamp", Instant.now());

            return problemDetail;


    // ja existiam

    //    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity tratarErro404() {
 //     ProblemDetail handleNumeroNaoInformadoException(NumeroNaoInformadoException e)
//            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_ACCEPTABLE, e.getLocalizedMessage())
//        return ResponseEntity.notFound().build();
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
//        var erros = ex.getFieldErrors();
//        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
//    }
//
//    @ExceptionHandler(ValidacaoException.class)
//    public ResponseEntity tratarErroRegraDeNegocio(ValidacaoException ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }
//
//    private record DadosErroValidacao(String campo, String mensagem) {
//        public DadosErroValidacao(FieldError erro) {
//            this(erro.getField(), erro.getDefaultMessage());
       }
    }


