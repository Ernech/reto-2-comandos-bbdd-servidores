package models.googlescholar.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Graph {
    private int year;
    private int citations;

    public int getYear() {
        return year;
    }

    public int getCitations() {
        return citations;
    }
}
