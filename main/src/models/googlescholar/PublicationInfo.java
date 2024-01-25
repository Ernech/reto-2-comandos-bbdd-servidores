package models.googlescholar;

import java.util.List;

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
