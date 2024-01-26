package models.googlescholar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherPages {
    @JsonProperty("1")
    private String _1;
    @JsonProperty("2")
    private String _2;
    @JsonProperty("4")
    private String _4;
    @JsonProperty("5")
    private String _5;
    @JsonProperty("6")
    private String _6;
    @JsonProperty("7")
    private String _7;
    @JsonProperty("8")
    private String _8;
    @JsonProperty("9")
    private String _9;
    @JsonProperty("10")
    private String _10;

    public String get_1() {
        return _1;
    }

    public String get_2() {
        return _2;
    }

    public String get_4() {
        return _4;
    }

    public String get_5() {
        return _5;
    }

    public String get_6() {
        return _6;
    }

    public String get_7() {
        return _7;
    }

    public String get_8() {
        return _8;
    }

    public String get_9() {
        return _9;
    }

    public String get_10() {
        return _10;
    }
}
