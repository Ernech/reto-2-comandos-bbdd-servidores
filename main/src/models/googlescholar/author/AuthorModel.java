package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorModel {
    @JsonProperty("search_metadata")
    private SearchMetadata searchMetadata;
    @JsonProperty("search_parameters")
    private SearchParameters searchParameters;
    @JsonProperty("author")
    private AuthorInfo authorInfo;
    private List<Article> articles;
    @JsonProperty("cited_by")
    private CitedBy citedBy;
    @JsonProperty("serpapi_pagination")
    private SerpapiPagination serpapiPagination;

    public AuthorModel() {
    }

    public AuthorModel(SearchMetadata searchMetadata, SearchParameters searchParameters, AuthorInfo authorInfo, List<Article> articles, CitedBy citedBy, SerpapiPagination serpapiPagination) {
        this.searchMetadata = searchMetadata;
        this.searchParameters = searchParameters;
        this.authorInfo = authorInfo;
        this.articles = articles;
        this.citedBy = citedBy;
        this.serpapiPagination = serpapiPagination;
    }

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

    public AuthorInfo getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(AuthorInfo authorInfo) {
        this.authorInfo = authorInfo;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public CitedBy getCitedBy() {
        return citedBy;
    }

    public void setCitedBy(CitedBy citedBy) {
        this.citedBy = citedBy;
    }

    public SerpapiPagination getSerpapiPagination() {
        return serpapiPagination;
    }

    public void setSerpapiPagination(SerpapiPagination serpapiPagination) {
        this.serpapiPagination = serpapiPagination;
    }
}

