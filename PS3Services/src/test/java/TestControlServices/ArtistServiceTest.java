package TestControlServices;

import SOA.Model.Entities.Artist;
import SOA.Model.Entities.ArtistDetails;
import SOA.Model.Services.ArtistServices.ArtistDataServices.IArtistsService;
import SOA.Model.Services.ArtistServices.ArtistServiceImp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArtistServiceTest {


    @Test
    public void testGetAllArtists()
    {
        ArtistServiceImp artistService = new ArtistServiceImp();
        artistService.setiArtistsService(new ArtistDataServiceMock());

        List<String> artistNames = artistService.getAllArtists();

        assert(artistNames.get(0).equals("Jessie J"));
        assert(artistNames.get(1).equals("Jp Cooper"));
        assert(artistNames.get(2).equals("Damian Marley"));
        assert(artistNames.get(3).equals("Mura Masa"));
    }


    @Test
    public void testGetArtistsWithStage()
    {
        ArtistServiceImp artistService = new ArtistServiceImp();
        artistService.setiArtistsService(new ArtistDataServiceMock());

        List<String> artistNames = artistService.getArtistsWithStage("Main");

        assert(artistNames.get(0).equals("Jessie J"));
        assert(artistNames.get(1).equals("Jp Cooper"));

        artistNames = artistService.getArtistsWithStage("BT");

        assert(artistNames.get(0).equals("Mura Masa"));
    }


    @Test
    public void testGetArtistsWithDataHour()
    {
        ArtistServiceImp artistService = new ArtistServiceImp();
        artistService.setiArtistsService(new ArtistDataServiceMock());

        List<String> artistNames = artistService.getArtistsWithDataHour(1, 5);

        assert(artistNames.get(0).equals("Jessie J"));
        assert(artistNames.get(1).equals("Mura Masa"));

        artistNames = artistService.getArtistsWithDataHour(1, 10);
        assert(artistNames.get(0).equals("Jp Cooper"));

    }


    @Test
    public void testGetWeatherForArtist()
    {
        ArtistServiceImp artistService = new ArtistServiceImp();
        artistService.setiArtistsService(new ArtistDataServiceMock());

        ArtistDetails artistDetails = artistService.getDetailsForArtist("Damian Marley");

        assert(artistDetails.getStage().equals("Red Bull"));
        assert(artistDetails.getDay() == 1);
        assert(artistDetails.getHour() == 6);
    }


    private class ArtistDataServiceMock implements IArtistsService
    {
        private List<Artist> artists;

        public ArtistDataServiceMock()
        {
            artists = new ArrayList<>();

            Artist artist1 = new Artist("Jessie J", "Main", 1, 5);
            Artist artist2 = new Artist("Jp Cooper", "Main", 1, 10);
            Artist artist3 = new Artist("Damian Marley", "Red Bull", 1, 6);
            Artist artist4 = new Artist("Mura Masa", "BT", 1, 5);

            artists.add(artist1);
            artists.add(artist2);
            artists.add(artist3);
            artists.add(artist4);
        }

        @Override
        public List<Artist> getArtistData() {
            return artists;
        }

        @Override
        public void setNextArtistDataService(IArtistsService iArtistsService) {

        }
    }
}
