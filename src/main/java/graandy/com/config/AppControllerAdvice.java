package graandy.com.config;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graandy.com.error.ApplicationException;

@ControllerAdvice
public class AppControllerAdvice {

	@ExceptionHandler
	public void handleGenericError(ApplicationException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Something wrong in application: " + e.getMessage());
	}

}