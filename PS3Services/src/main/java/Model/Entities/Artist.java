package Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    @JsonProperty("ArtistName")
    private String artistName;

    @JsonProperty("Stage")
    private String stage;

    @JsonProperty("Day")
    private Integer day;

    @JsonProperty("Hour")
    private Integer hour;

    public Artist(){

    }

    public String getArtistName() {
        return artistName;
    }

    public String getStage() {
        return stage;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                ", stage='" + stage + '\'' +
                ", day=" + day +
                ", hour=" + hour +
                '}';
    }
}
