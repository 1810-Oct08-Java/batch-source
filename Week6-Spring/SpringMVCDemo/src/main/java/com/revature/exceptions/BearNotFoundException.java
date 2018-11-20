package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="That's a teapot and not a bear")
public class BearNotFoundException extends RuntimeException {
	
	public BearNotFoundException() {
		
	}

}
