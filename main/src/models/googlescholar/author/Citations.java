package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Citations {
    private int all;
    @JsonProperty("since_2019")
    private int since2019;

    public int getAll() {
        return all;
    }

    public int getSince2019() {
        return since2019;
    }
}
