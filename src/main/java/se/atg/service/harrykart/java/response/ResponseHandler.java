package se.atg.service.harrykart.java.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(Object responseObj, HttpStatus httpStatus) {
        return new ResponseEntity<>(new HashMap<String, Object>() {{
            put("ranking", responseObj);
        }}, httpStatus);
    }
}
