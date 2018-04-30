package SOA.Model.Services.WeatherServices.WeatherDataServices;

import SOA.Model.Entities.Weather;

import java.util.List;

public interface IWeatherService {

    List<Weather> getWeatherData();

    void setNextWeatherDataService(IWeatherService iArtistsService);
}
