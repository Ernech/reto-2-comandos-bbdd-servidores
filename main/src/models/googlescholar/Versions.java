package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Versions {
    private int total;
    private String link;
    @JsonProperty("cluster_id")
    private String clusterId;
    @JsonProperty("serpapi_scholar_link")
    private String serpapiScholarLink;

    public int getTotal() {
        return total;
    }

    public String getLink() {
        return link;
    }

    public String getClusterId() {
        return clusterId;
    }

    public String getSerpapiScholarLink() {
        return serpapiScholarLink;
    }
}
