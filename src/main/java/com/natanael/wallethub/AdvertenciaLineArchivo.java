package com.natanael.wallethub;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdvertenciaLineArchivo {

	@ResponseBody
	@ExceptionHandler(LineaArchivoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(LineaArchivoNotFoundException ex) {
		return ex.getMessage();
	}
}
