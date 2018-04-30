package SOA.Model.Services.ArtistServices.ArtistDataServices;

import SOA.Model.Entities.Artist;

import java.util.List;

public class EcArtistsCachedService implements IArtistsService {

    private IArtistsService iArtistsService;
    private List<Artist> artistCache;
    private long lastTime;
    private long expirationTime;

    public EcArtistsCachedService(long expirationTime)
    {
        this.expirationTime = expirationTime * 1000;
    }

    @Override
    public List<Artist> getArtistData() {

        if (isExpired())
        {
            artistCache = iArtistsService.getArtistData();
            lastTime = System.currentTimeMillis();
        }

        return artistCache;

    }

    @Override
    public void setNextArtistDataService(IArtistsService iArtistsService) {
        this.iArtistsService = iArtistsService;
    }

    public boolean isExpired()
    {
        return (System.currentTimeMillis() - lastTime) > expirationTime || artistCache == null;
    }
}
