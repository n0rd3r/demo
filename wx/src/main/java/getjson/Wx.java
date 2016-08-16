package getjson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wx {

    private Current currently;
    private TimeFrame minutely;

    public Wx() {
    }

    public Current getCurrently() {
        return currently;
    }

    public void setCurrently(Current c) {
        this.currently = c;
    }

    public TimeFrame getMinutely() {
        return minutely;
    }

    public void setMinutely(TimeFrame m) {
        this.minutely = m;
    }

    @Override
    public String toString() {
        return "WEATHER: " + currently + " " + minutely;
    }
}
