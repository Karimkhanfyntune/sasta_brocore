package com.example.demo.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.Enum.Errortype;
import com.example.demo.ResponseRequest.ResponseHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandlers {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandlers.class);



	 @ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<ResponseHandler> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
	        LOGGER.error("Handling IllegalArgumentException: ", e);
	        String errorMessage = e.getMessage();

	        // Create and return a custom ResponseHandler
	        ResponseHandler response = new ResponseHandler();
	        response.setStatus(false);
	        response.setData(null);
	        response.setMessage(errorMessage);
	        response.setErrortype(Errortype.info);

	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ResponseHandler> handleGlobalException(Exception e, WebRequest request) {
	        LOGGER.error("Handling global exception: ", e);
	        String errorMessage = e.getMessage();

	        // Create and return a custom ResponseHandler
	        ResponseHandler response = new ResponseHandler();
	        response.setStatus(false);
	        response.setData(null);
	        response.setMessage(errorMessage);
	        response.setErrortype(Errortype.error);

	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
