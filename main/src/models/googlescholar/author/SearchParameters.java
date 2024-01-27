package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchParameters {
    private String engine;
    @JsonProperty("author_id")
    private String authorId;
    private String hl;

    public String getEngine() {
        return engine;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getHl() {
        return hl;
    }
}
