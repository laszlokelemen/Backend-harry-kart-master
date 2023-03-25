package se.atg.service.harrykart.java.exception;


import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class ExceptionDetails {
    private Date timestamp;
    private List<String> messages;
    private String path;
}