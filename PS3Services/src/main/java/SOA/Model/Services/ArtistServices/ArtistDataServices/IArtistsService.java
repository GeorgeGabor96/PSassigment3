package SOA.Model.Services.ArtistServices.ArtistDataServices;

import SOA.Model.Entities.Artist;

import java.util.List;

public interface IArtistsService {

    List<Artist> getArtistData();

    void setNextArtistDataService(IArtistsService iArtistsService);
}
