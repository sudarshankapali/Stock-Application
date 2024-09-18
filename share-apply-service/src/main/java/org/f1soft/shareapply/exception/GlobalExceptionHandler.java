package org.f1soft.shareapply.exception;

import org.f1soft.shareapply.model.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


//    public GlobalExceptionHandler(ApiResponse apiResponse) {
//        this.apiResponse = apiResponse;
//    }
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setMessage(ex.getMessage().substring(0, ex.getMessage().indexOf(":")));
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundException(UserIdNotFoundException ex){
        String message= ex.getMessage();

        ApiResponse response= ApiResponse.builder().message(message).data(null).build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ApiResponse> handleIssueIdNotException(IdNotFoundException ex){
        String message=ex.getMessage();

        ApiResponse response =ApiResponse.builder().message(message).data(null).build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TableEmptyException.class)
    public ResponseEntity<ApiResponse> handleTableEmptyException(TableEmptyException ex){
        String message=ex.getMessage();

        ApiResponse response =ApiResponse.builder().message(message).data(null).build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
