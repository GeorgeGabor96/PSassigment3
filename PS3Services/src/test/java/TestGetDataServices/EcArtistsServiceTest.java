package TestGetDataServices;

import Model.Entities.Artist;
import Model.Services.ArtistServices.EcArtistsCachedService;
import Model.Services.ArtistServices.EcArtistsWebService;
import Model.Services.ArtistServices.IArtistsService;
import org.junit.Test;

import java.util.List;

public class EcArtistsServiceTest
{
    @Test
    public void testGetArtistWebService()
    {
        EcArtistsWebService ecArtistsWebService = new EcArtistsWebService();

        List<Artist> artistList = ecArtistsWebService.getArtistData();

        assert(artistList != null);
        assert(artistList.size() != 0);

        for (Artist artist: artistList)
        {
            assert(false == artist.getArtistName().equals("Null"));
            assert(false == artist.getStage().equals("Null"));
            assert(null != artist.getDay());
            assert(null != artist.getHour());
            System.out.println(artist);
        }
    }

    @Test
    public void testCachedArtistService()
    {
        EcArtistsCachedService cachedArtistService = new EcArtistsCachedService(1);
        IArtistsService webArtistService = new EcArtistsWebService();
        cachedArtistService.setNextArtistDataService(webArtistService);

        assert(cachedArtistService.isExpired() == true);
        List<Artist> artistList = cachedArtistService.getArtistData();
        assert(artistList != null);
        assert(artistList.size() != 0);
        assert(cachedArtistService.isExpired() == false);

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert(cachedArtistService.isExpired() == true);
    }
}
