package se.atg.service.harrykart.java.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lane implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    private int number;
    @JacksonXmlText
    private int powerValue;
}
