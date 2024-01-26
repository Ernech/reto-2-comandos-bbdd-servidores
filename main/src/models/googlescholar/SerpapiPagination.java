package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerpapiPagination {
    private int current;
    @JsonProperty("previous_link")
    private String previousLink;
    private String previous;
    @JsonProperty("next_link")
    private String nextLink;
    private String next;
    @JsonProperty("other_pages")
    private OtherPages otherPages;

    public int getCurrent() {
        return current;
    }

    public String getPreviousLink() {
        return previousLink;
    }

    public String getPrevious() {
        return previous;
    }

    public String getNextLink() {
        return nextLink;
    }

    public String getNext() {
        return next;
    }

    public OtherPages getOtherPages() {
        return otherPages;
    }
}
