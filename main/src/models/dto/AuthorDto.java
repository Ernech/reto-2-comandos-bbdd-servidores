package models.dto;

import java.math.BigInteger;

public class AuthorDto {

    private String authorName;
    private String email;
    private String carrer;
    private BigInteger citations;
    private String affiliations;

    public AuthorDto() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public BigInteger getCitations() {
        return citations;
    }

    public void setCitations(BigInteger citations) {
        this.citations = citations;
    }

    public String getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(String affiliations) {
        this.affiliations = affiliations;
    }
}
