package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerpapiPagination {
    private String next;

    public String getNext() {
        return next;
    }
}
