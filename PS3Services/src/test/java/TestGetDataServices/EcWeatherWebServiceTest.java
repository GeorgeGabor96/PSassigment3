package TestGetDataServices;

import SOA.Model.Entities.Weather;
import SOA.Model.Services.WeatherServices.WeatherDataServices.EcWeatherCachedService;
import SOA.Model.Services.WeatherServices.WeatherDataServices.EcWeatherWebService;
import SOA.Model.Services.WeatherServices.WeatherDataServices.IWeatherService;
import org.junit.Test;

import java.util.List;

public class EcWeatherWebServiceTest
{
    @Test
    public void testGetWeatherWebService()
    {
        EcWeatherWebService ecArtistsWebService = new EcWeatherWebService();

        List<Weather> weatherList = ecArtistsWebService.getWeatherData();

        assert(weatherList != null);
        assert(weatherList.size() != 0);

        for (Weather weather: weatherList)
        {
            assert(null != weather.getDay());
            assert(null != weather.getHour());
            assert(null != weather.getRainChance());
            System.out.println(weather);
        }
    }

    @Test
    public void testCachedWeatherService()
    {
        EcWeatherCachedService cachedWeatherService = new EcWeatherCachedService(1);
        IWeatherService webWeatherService = new EcWeatherWebService();
        cachedWeatherService.setNextWeatherDataService(webWeatherService);

        assert(cachedWeatherService.isExpired() == true);
        List<Weather> weatherList = cachedWeatherService.getWeatherData();
        assert(weatherList != null);
        assert(weatherList.size() != 0);
        assert(cachedWeatherService.isExpired() == false);

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert(cachedWeatherService.isExpired() == true);
    }
}
