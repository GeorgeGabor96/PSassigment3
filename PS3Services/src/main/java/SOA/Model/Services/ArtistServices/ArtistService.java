package SOA.Model.Services.ArtistServices;

import SOA.Model.Entities.ArtistDetails;

import java.util.List;


public interface ArtistService {

    List<String> getAllArtists();

    List<String> getArtistsWithStage(String stageName);

    List<String> getArtistsWithDataHour(int date, int hour);

    ArtistDetails getDetailsForArtist(String artistName);
}
