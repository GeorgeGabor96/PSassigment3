package SOA.Model.Services.ArtistServices;

import SOA.Model.Entities.Artist;
import SOA.Model.Entities.ArtistDetails;
import SOA.Model.Services.ArtistServices.ArtistDataServices.EcArtistsCachedService;
import SOA.Model.Services.ArtistServices.ArtistDataServices.EcArtistsWebService;
import SOA.Model.Services.ArtistServices.ArtistDataServices.IArtistsService;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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
        List<String> artistNames = new ArrayList<>();
        List<Artist> artists = iArtistsService.getArtistData();
        for (Artist artist: artists)
        {
            artistNames.add(artist.getArtistName());
        }

        return artistNames;
    }

    @Override
    public List<String> getArtistsWithStage(String stageName)
    {
        List<String> artistsNames = new ArrayList<>();
        List<Artist> artists = iArtistsService.getArtistData();

        for (Artist artist: artists)
        {
            if (artist.getStage().equals(stageName))
            {
                artistsNames.add(artist.getArtistName());
            }
        }

        return artistsNames;
    }

    @Override
    public List<String> getArtistsWithDataHour(int date, int hour)
    {

        List<String> artistsNames = new ArrayList<>();
        List<Artist> artists = iArtistsService.getArtistData();

        for (Artist artist: artists)
        {
            if (artist.getDay() == date && artist.getHour() == hour)
            {
                artistsNames.add(artist.getArtistName());
            }
        }

        return artistsNames;
    }

    @Override
    public ArtistDetails getDetailsForArtist(String artistName)
    {
        List<Artist> artists = iArtistsService.getArtistData();
        ArtistDetails artistDetails = null;

        for (Artist artist: artists)
        {
            if (artist.getArtistName().equals(artistName))
            {
                artistDetails = new ArtistDetails(artist.getStage(), artist.getDay(), artist.getHour());
            }
        }

        return artistDetails;
    }


    public void setiArtistsService(IArtistsService iArtistsService)
    {
        this.iArtistsService = iArtistsService;
    }
}
