package com.accenture.sirio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BaseController {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST) //<--- STATUS DA RESTITUIRE IN CASO DI VALIDAZIONE NON AVVENUTA CON SUCCESSO
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(final MethodArgumentNotValidException ex) {
		final List<String> errors = new ArrayList<>();
		//<--- lista degli errori dovuti alla validazione
		for(int i=0; i<ex.getBindingResult().getAllErrors().size(); i++) {
			errors.add(ex.getBindingResult().getAllErrors().get(i).getDefaultMessage());
		}
		return errors;
	}
}
