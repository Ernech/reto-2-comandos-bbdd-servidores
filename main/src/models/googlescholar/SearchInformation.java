package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchInformation {
    @JsonProperty("organic_results_state")
    private String organicResultsState;
    @JsonProperty("total_results")
    private int totalResults;
    @JsonProperty("page_number")
    private int pageNumber;
    @JsonProperty("time_taken_displayed")
    private double timeTakenDisplayed;
    @JsonProperty("query_displayed")
    private String queryDisplayed;

    public String getOrganicResultsState() {
        return organicResultsState;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public double getTimeTakenDisplayed() {
        return timeTakenDisplayed;
    }

    public String getQueryDisplayed() {
        return queryDisplayed;
    }
}
