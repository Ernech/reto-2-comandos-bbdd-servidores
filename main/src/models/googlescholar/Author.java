package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    private String name;
    private String link;
    @JsonProperty("serpapi_scholar_link")
    private String serpapiScholarLink;
    @JsonProperty("author_id")
    private String authorId;

    public Author() {
    }

    public Author(String name, String link, String serpapiScholarLink, String authorId) {
        this.name = name;
        this.link = link;
        this.serpapiScholarLink = serpapiScholarLink;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSerpapiScholarLink() {
        return serpapiScholarLink;
    }

    public void setSerpapiScholarLink(String serpapiScholarLink) {
        this.serpapiScholarLink = serpapiScholarLink;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
