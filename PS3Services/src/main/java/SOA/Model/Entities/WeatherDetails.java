package SOA.Model.Entities;

public class WeatherDetails {

    private ArtistDetails artistDetails;
    private String weather;

    public WeatherDetails(ArtistDetails artistDetails, int rainChance){

        this.artistDetails = artistDetails;
        this.weather = getWeather(rainChance);
    }

    private String getWeather(int rainChance)
    {
        if (rainChance < 0)
        {
            return "Unknown";
        }
        else if (rainChance < 40)
        {
            return "Sunny";
        }
        else if (rainChance < 70)
        {
            return "Cloudy";
        }
        else
        {
            return "Rainy";
        }
    }

    public ArtistDetails getArtistDetails() {
        return artistDetails;
    }

    public String getWeather() {
        return weather;
    }

    public void setArtistDetails(ArtistDetails artistDetails) {
        this.artistDetails = artistDetails;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "artistDetails=" + artistDetails +
                ", weather='" + weather + '\'' +
                '}';
    }
}
