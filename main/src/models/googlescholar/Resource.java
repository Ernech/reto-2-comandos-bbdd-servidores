package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
    private String title;
    @JsonProperty("file_format")
    private String fileFormat;
    private String link;

    public String getTitle() {
        return title;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public String getLink() {
        return link;
    }
}
