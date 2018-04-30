package SOA.Model.Entities;

public class ArtistDetails {

    private String stage;
    private int day;
    private int hour;

    public ArtistDetails(String stage, int day, int hour) {
        this.stage = stage;
        this.day = day;
        this.hour = hour;
    }

    public String getStage() {
        return stage;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "ArtistDetails{" +
                "stage='" + stage + '\'' +
                ", day=" + day +
                ", hour=" + hour +
                '}';
    }
}
