package SOA.Model.Services.ArtistServices;

import SOA.Model.Entities.Artist;
import SOA.Model.Entities.ArtistDetails;
import SOA.Model.Services.ArtistServices.ArtistDataServices.EcArtistsCachedService;
import SOA.Model.Services.ArtistServices.ArtistDataServices.EcArtistsWebService;
import SOA.Model.Services.ArtistServices.ArtistDataServices.IArtistsService;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Configuration
public class ArtistServiceImp implements ArtistService{

    private IArtistsService iArtistsService;

    public ArtistServiceImp()
    {
        iArtistsService = new EcArtistsCachedService(30);
        iArtistsService.setNextArtistDataService(new EcArtistsWebService());
    }

    @Override
    public List<String> getAllArtists()
    {
        return iArtistsService.getArtistData().stream()
                        .map(Artist::getArtistName)
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> getArtistsWithStage(String stageName)
    {
        return iArtistsService.getArtistData().stream()
                            .filter(p -> p.getStage().equals(stageName))
                            .map(Artist::getArtistName)
                            .collect(Collectors.toList());
    }

    @Override
    public List<String> getArtistsWithDataHour(int date, int hour)
    {
        return iArtistsService.getArtistData().stream()
                            .filter(p -> p.getDay() == date && p.getHour() == hour)
                            .map(Artist::getArtistName)
                            .collect(Collectors.toList());
    }

    @Override
    public ArtistDetails getDetailsForArtist(String artistName)
    {
        return iArtistsService.getArtistData().stream()
                            .filter(p -> p.getArtistName().equals(artistName))
                            .findFirst()
                            .map(p -> new ArtistDetails(p.getStage(), p.getDay(), p.getHour()))
                            .orElse(null);
    }


    public void setiArtistsService(IArtistsService iArtistsService)
    {
        this.iArtistsService = iArtistsService;
    }
}
