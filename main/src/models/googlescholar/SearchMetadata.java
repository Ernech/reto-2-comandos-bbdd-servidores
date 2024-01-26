package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchMetadata {
    private String id;
    private String status;
    @JsonProperty("json_endpoint")
    private String jsonEndpoint;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("processed_at")
    private String processedAt;
    @JsonProperty("google_scholar_url")
    private String googleScholarUrl;
    @JsonProperty("raw_html_file")
    private String rawHtmlFile;
    @JsonProperty("total_time_taken")
    private double totalTimeTaken;

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getJsonEndpoint() {
        return jsonEndpoint;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public String getGoogleScholarUrl() {
        return googleScholarUrl;
    }

    public String getRawHtmlFile() {
        return rawHtmlFile;
    }

    public double getTotalTimeTaken() {
        return totalTimeTaken;
    }
}
