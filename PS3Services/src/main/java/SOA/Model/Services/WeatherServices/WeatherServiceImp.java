package SOA.Model.Services.WeatherServices;

import SOA.Model.Entities.Weather;
import SOA.Model.Services.WeatherServices.WeatherDataServices.EcWeatherCachedService;
import SOA.Model.Services.WeatherServices.WeatherDataServices.EcWeatherWebService;
import SOA.Model.Services.WeatherServices.WeatherDataServices.IWeatherService;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeatherServiceImp implements WeatherService {

    private IWeatherService iWeatherService;

    public WeatherServiceImp()
    {
        iWeatherService = new EcWeatherCachedService(30);
        iWeatherService.setNextWeatherDataService(new EcWeatherWebService());
    }

    @Override
    public int getRainChanceDayHour(int day, int hour)
    {
        List<Weather> weatherList = iWeatherService.getWeatherData();

        for (Weather weather: weatherList)
        {
            if (weather.getDay() == day && weather.getHour() == hour)
            {
                return weather.getRainChance();
            }
        }

        return -1;
    }

    public void setiWeatherService(IWeatherService iWeatherService)
    {
        this.iWeatherService = iWeatherService;
    }
}
