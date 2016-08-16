package getjson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {

    private Float Temperature;
    private Float dewPoint;

    public Current() {
    }

    public Float getTemperature() {
        return this.Temperature;
    }

    public Float getDewPoint() {
        return this.dewPoint;
    }

    public void setTemperature(Float t) {
        this.Temperature = t;
    }

    public void setDewPoint(Float dp) {
        this.dewPoint = dp;
    }

    @Override
    public String toString() {
        return "The current temperature is " + Temperature +
                " and the dewpoint is " + dewPoint + ".";
    }
}
