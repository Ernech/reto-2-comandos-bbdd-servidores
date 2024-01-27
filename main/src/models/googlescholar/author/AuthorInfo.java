package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorInfo {
    private String name;
    private String affiliations;
    private String email;
    private List<Interest> interests;
    private String thumbnail;

    public String getName() {
        return name;
    }

    public String getAffiliations() {
        return affiliations;
    }

    public String getEmail() {
        return email;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
