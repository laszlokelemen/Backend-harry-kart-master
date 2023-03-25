package se.atg.service.harrykart.java.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "harryKart")
public class HarryKart implements Serializable {
    @NotNull
    @Min(1)
    private int numberOfLoops;

    @Valid
    @Size(min = 4)
    @NotNull
    private List<Participant> startList;

    @Valid
    @NotNull
    private List<Loop> powerUps;

}
