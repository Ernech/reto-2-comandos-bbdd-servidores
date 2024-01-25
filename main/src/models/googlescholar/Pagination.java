package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagination {
    private int current;
    private String previous;
    private String next;
    @JsonProperty("other_pages")
    private OtherPages otherPages;

    public int getCurrent() {
        return current;
    }

    public String getPrevious() {
        return previous;
    }

    public String getNext() {
        return next;
    }

    public OtherPages getOtherPages() {
        return otherPages;
    }
}
