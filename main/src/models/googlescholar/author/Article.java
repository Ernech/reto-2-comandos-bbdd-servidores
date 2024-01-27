package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    private String title;
    private String link;
    @JsonProperty("citation_id")
    private String citationId;
    private String authors;
    private String publication;
    @JsonProperty("cited_by")
    private CitedBy citedBy;
    private String year;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getCitationId() {
        return citationId;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublication() {
        return publication;
    }

    public CitedBy getCitedBy() {
        return citedBy;
    }

    public String getYear() {
        return year;
    }
}
