package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineLinks {
    @JsonProperty("serpapi_cite_link")
    private String serpapiCiteLink;
    @JsonProperty("cited_by")
    private CitedBy citedBy;
    @JsonProperty("related_pages_link")
    private String relatedPagesLink;
    @JsonProperty("serpapi_related_pages_link")
    private String serpapiRelatedPagesLink;
    private Versions versions;
    @JsonProperty("cached_page_link")
    private String cachedPageLink;

    public String getSerpapiCiteLink() {
        return serpapiCiteLink;
    }

    public void setSerpapiCiteLink(String serpapiCiteLink) {
        this.serpapiCiteLink = serpapiCiteLink;
    }

    public CitedBy getCitedBy() {
        return citedBy;
    }

    public void setCitedBy(CitedBy citedBy) {
        this.citedBy = citedBy;
    }

    public String getRelatedPagesLink() {
        return relatedPagesLink;
    }

    public void setRelatedPagesLink(String relatedPagesLink) {
        this.relatedPagesLink = relatedPagesLink;
    }

    public String getSerpapiRelatedPagesLink() {
        return serpapiRelatedPagesLink;
    }

    public void setSerpapiRelatedPagesLink(String serpapiRelatedPagesLink) {
        this.serpapiRelatedPagesLink = serpapiRelatedPagesLink;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    public String getCachedPageLink() {
        return cachedPageLink;
    }

    public void setCachedPageLink(String cachedPageLink) {
        this.cachedPageLink = cachedPageLink;
    }
}
