package SOA.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("Day")
    private Integer day;

    @JsonProperty("Hour")
    private Integer hour;

    @JsonProperty("RainChance")
    private Integer rainChance;

    public Weather(){

    }

    public Weather(Integer day, Integer hour, Integer rainChance) {
        this.day = day;
        this.hour = hour;
        this.rainChance = rainChance;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getRainChance() {
        return rainChance;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public void setRainChance(Integer rainChance) {
        this.rainChance = rainChance;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day=" + day +
                ", hour=" + hour +
                ", rainChance=" + rainChance +
                '}';
    }
}
