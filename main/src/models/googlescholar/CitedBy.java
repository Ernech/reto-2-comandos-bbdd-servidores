package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CitedBy {
    private int total;
    private String link;
    @JsonProperty("cites_id")
    private String citesId;
    @JsonProperty("serpapi_scholar_link")
    private String serpapiScholarLink;

    public CitedBy() {
    }

    public CitedBy(int total, String link, String citesId, String serpapiScholarLink) {
        this.total = total;
        this.link = link;
        this.citesId = citesId;
        this.serpapiScholarLink = serpapiScholarLink;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCitesId() {
        return citesId;
    }

    public void setCitesId(String citesId) {
        this.citesId = citesId;
    }

    public String getSerpapiScholarLink() {
        return serpapiScholarLink;
    }

    public void setSerpapiScholarLink(String serpapiScholarLink) {
        this.serpapiScholarLink = serpapiScholarLink;
    }
}
