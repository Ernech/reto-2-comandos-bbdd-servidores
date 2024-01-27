package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CitedBy {
    private int value;
    private String link;
    @JsonProperty("serpapi_link")
    private String serpapiLink;
    @JsonProperty("cites_id")
    private String citesId;
    private List<Table> table;
    private List<Graph> graph;

    public int getValue() {
        return value;
    }

    public String getLink() {
        return link;
    }

    public String getSerpapiLink() {
        return serpapiLink;
    }

    public String getCitesId() {
        return citesId;
    }

    public List<Table> getTable() {
        return table;
    }

    public List<Graph> getGraph() {
        return graph;
    }
}
