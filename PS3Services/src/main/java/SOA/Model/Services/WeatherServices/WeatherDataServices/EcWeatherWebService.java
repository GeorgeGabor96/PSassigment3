package SOA.Model.Services.WeatherServices.WeatherDataServices;

import SOA.Model.Entities.Weather;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class EcWeatherWebService implements IWeatherService{

    private static final String URL = "https://sheetsu.com/apis/v1.0su/edf62bee9a33";

    @Override
    public List<Weather> getWeatherData()
    {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Weather>> rateResponse = restTemplate.exchange(URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Weather>>() {
                });
        return rateResponse.getBody();
    }

    @Override
    public void setNextWeatherDataService(IWeatherService iArtistsService) {
        return;
    }
}
