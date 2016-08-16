package getjson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeFrame {

    private String summary;

    public TimeFrame() {
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String s) {
        this.summary = s;
    }

    @Override
    public String toString() {
        return summary;
    }
}
