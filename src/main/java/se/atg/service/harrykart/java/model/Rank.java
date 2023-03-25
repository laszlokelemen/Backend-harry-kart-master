package se.atg.service.harrykart.java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rank implements Comparable<Rank> {
    private int position;
    private String horse;
//    @JsonIgnore
    private double time;

    @Override
    public int compareTo(@NotNull Rank o) {
        if (this.getTime() > o.getTime()) {
            return 1;
        } else if (this.getTime() == o.getTime()) {
            return 0;
        }
        return -1;
    }
}
