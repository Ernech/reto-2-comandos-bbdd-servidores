package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Table {
    private Citations citations;
    @JsonProperty("hIndex")
    private HIndex h_index;
    @JsonProperty("i10Index")
    private I10Index i10_index;

    public Citations getCitations() {
        return citations;
    }

    public HIndex getH_index() {
        return h_index;
    }

    public I10Index getI10_index() {
        return i10_index;
    }
}
