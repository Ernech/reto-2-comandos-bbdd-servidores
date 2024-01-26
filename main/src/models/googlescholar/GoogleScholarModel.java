package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleScholarModel{

    @JsonProperty("search_metadata")
    private SearchMetadata searchMetadata;

    @JsonProperty("search_parameters")
    private SearchParameters searchParameters;

    @JsonProperty("search_information")
    private SearchInformation searchInformation;

    @JsonProperty("organic_results")
    private List<OrganicResult> organicResults;

    @JsonProperty("pagination")
    private Pagination pagination;

    @JsonProperty("serpapi_pagination")
    private SerpapiPagination serpapiPagination;

    public SearchMetadata getSearchMetadata() {
        return searchMetadata;
    }

    public void setSearchMetadata(SearchMetadata searchMetadata) {
        this.searchMetadata = searchMetadata;
    }

    public SearchParameters getSearchParameters() {
        return searchParameters;
    }

    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    public SearchInformation getSearchInformation() {
        return searchInformation;
    }

    public void setSearchInformation(SearchInformation searchInformation) {
        this.searchInformation = searchInformation;
    }

    public List<OrganicResult> getOrganicResults() {
        return organicResults;
    }

    public void setOrganicResults(List<OrganicResult> organicResults) {
        this.organicResults = organicResults;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public SerpapiPagination getSerpapiPagination() {
        return serpapiPagination;
    }

    public void setSerpapiPagination(SerpapiPagination serpapiPagination) {
        this.serpapiPagination = serpapiPagination;
    }
}


