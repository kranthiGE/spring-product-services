package ge.springfw.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public RestResponseEntityExceptionHandler() {
		super();
	}
	
	@ExceptionHandler(value = {MyResourceNotFoundException.class})
	public final ResponseEntity<Object> handleBadRequest(final MyResourceNotFoundException ex, final WebRequest request) {
		return handleExceptionInternal(ex, messageBody(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private ApiError messageBody(final HttpStatus status, final Exception ex) {
		String message = ex.getMessage();
		String devMessage = ExceptionUtils.getRootCauseMessage(ex);
		return new ApiError(status, message, devMessage);
	}
	
}
