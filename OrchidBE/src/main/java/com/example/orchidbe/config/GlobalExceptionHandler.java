package com.example.orchidbe.config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.security.SignatureException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception  exception)
    {
        ProblemDetail erroDetail = null;
        exception.printStackTrace();
        if(exception instanceof BadCredentialsException)
        {
            erroDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
            erroDetail.setProperty("description","The username or password you entered is incorrect.");
            return erroDetail;
        }
        if(exception instanceof AccountStatusException)
        {
            erroDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            erroDetail.setProperty("description","Account is locked.");
        }
        if(exception instanceof AccessDeniedException)
        {
            erroDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            erroDetail.setProperty("description","You do not have permission to access this resource.");
        }
        if(exception instanceof SignatureException)
        {
            erroDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
            erroDetail.setProperty("description","Invalid JWT signature.");
        }
        if(exception instanceof ExpiredJwtException)
        {
            erroDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
            erroDetail.setProperty("description","JWT token has expired.");
        }
        if(erroDetail != null)
        {
            erroDetail= ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
            erroDetail.setProperty("description","An error occured.");
        }
        return erroDetail;
    }
}
