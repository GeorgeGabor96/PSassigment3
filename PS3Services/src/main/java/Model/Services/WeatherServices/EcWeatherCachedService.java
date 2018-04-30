package Model.Services.WeatherServices;

import Model.Entities.Weather;

import java.util.List;

public class EcWeatherCachedService implements IWeatherService {

    private IWeatherService iWeatherService;
    private List<Weather> weatherCache;
    private long lastTime;
    private long expirationTime;

    public EcWeatherCachedService(long expirationTime)
    {
        this.expirationTime = expirationTime;
    }

    @Override
    public List<Weather> getWeatherData() {

        if (isExpired() == true)
        {
            weatherCache = iWeatherService.getWeatherData();
            lastTime = System.currentTimeMillis();
        }
        return weatherCache;
    }

    @Override
    public void setNextWeatherDataService(IWeatherService iWeatherService) {
        this.iWeatherService = iWeatherService;
    }

    public boolean isExpired()
    {
        return (System.currentTimeMillis() - lastTime) > expirationTime || weatherCache == null;
    }
}
