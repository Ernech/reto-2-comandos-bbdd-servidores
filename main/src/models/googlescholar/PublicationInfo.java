package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicationInfo {
    private String summary;
    private List<Author> authors;

    public String getSummary() {
        return summary;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
