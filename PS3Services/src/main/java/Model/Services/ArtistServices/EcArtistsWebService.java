package Model.Services.ArtistServices;

import Model.Entities.Artist;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class EcArtistsWebService implements IArtistsService{

    private static final String URL = "https://sheetsu.com/apis/v1.0bu/e6d3f4678850";

    @Override
    public List<Artist> getArtistData()
    {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Artist>> rateResponse = restTemplate.exchange(URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Artist>>() {
                });
        return rateResponse.getBody();
    }

    @Override
    public void setNextArtistDataService(IArtistsService iArtistsService) {
        return;
    }
}
