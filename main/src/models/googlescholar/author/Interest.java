package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Interest {
    private String title;
    private String link;
    @JsonProperty("serpapi_link")
    private String serpapiLink;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getSerpapiLink() {
        return serpapiLink;
    }
}
