package se.atg.service.harrykart.java.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "participant")
public class Participant implements Serializable {
    @JacksonXmlProperty
    @NotNull
    private int lane;

    @JacksonXmlProperty
    @NotBlank
    private String name;

    @JacksonXmlProperty
    @NotNull
    @Min(1)
    private int baseSpeed;
}
