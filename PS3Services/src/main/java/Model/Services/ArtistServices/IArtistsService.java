package Model.Services.ArtistServices;

import Model.Entities.Artist;

import java.util.List;

public interface IArtistsService {

    List<Artist> getArtistData();

    void setNextArtistDataService(IArtistsService iArtistsService);
}
