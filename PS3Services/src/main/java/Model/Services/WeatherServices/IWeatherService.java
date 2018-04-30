package Model.Services.WeatherServices;

import Model.Entities.Weather;

import java.util.List;

public interface IWeatherService {

    List<Weather> getWeatherData();

    void setNextWeatherDataService(IWeatherService iArtistsService);
}
