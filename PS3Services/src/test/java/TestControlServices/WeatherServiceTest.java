package TestControlServices;

import SOA.Model.Entities.ArtistDetails;
import SOA.Model.Entities.Weather;
import SOA.Model.Entities.WeatherDetails;
import SOA.Model.Services.WeatherServices.WeatherDataServices.IWeatherService;
import SOA.Model.Services.WeatherServices.WeatherServiceImp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WeatherServiceTest {

    @Test
    public void testGetRainChanceDayHour()
    {
        WeatherServiceImp weatherService = new WeatherServiceImp();
        weatherService.setiWeatherService(new WeatherDataServiceMock());

        ArtistDetails artistDetails = new ArtistDetails("Main", 1, 5);
        int rainChance = weatherService.getRainChanceDayHour(artistDetails.getDay(), artistDetails.getHour());
        WeatherDetails weatherDetails = new WeatherDetails(artistDetails, rainChance);

        assert(weatherDetails.getWeather().equals("Sunny"));

        artistDetails = new ArtistDetails("Main", 1, 8);
        rainChance = weatherService.getRainChanceDayHour(artistDetails.getDay(), artistDetails.getHour());
        weatherDetails = new WeatherDetails(artistDetails, rainChance);

        assert(weatherDetails.getWeather().equals("Cloudy"));

        artistDetails = new ArtistDetails("Main", 2, 10);
        rainChance = weatherService.getRainChanceDayHour(artistDetails.getDay(), artistDetails.getHour());
        weatherDetails = new WeatherDetails(artistDetails, rainChance);

        assert(weatherDetails.getWeather().equals("Rainy"));

    }

    private class WeatherDataServiceMock implements IWeatherService
    {
        List<Weather> weatherList;

        public WeatherDataServiceMock()
        {
            weatherList = new ArrayList<>();

            Weather weather1 = new Weather(1, 5, 3);
            Weather weather2 = new Weather(1, 8, 53);
            Weather weather3 = new Weather(2, 10, 85);

            weatherList.add(weather1);
            weatherList.add(weather2);
            weatherList.add(weather3);
        }

        @Override
        public List<Weather> getWeatherData() {
            return weatherList;
        }

        @Override
        public void setNextWeatherDataService(IWeatherService iArtistsService) {

        }
    }
}
