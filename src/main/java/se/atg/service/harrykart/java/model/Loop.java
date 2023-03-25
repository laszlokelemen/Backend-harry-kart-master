package se.atg.service.harrykart.java.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "loop")
public class Loop implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    private int number;

    @Valid
    @Size(min=4)
    @NotNull
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "lane")
    private List<Lane> lanes;
}
