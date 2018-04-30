package SOA.Controllers;


import SOA.Model.Entities.ArtistDetails;
import SOA.Model.Entities.WeatherDetails;
import SOA.Model.Services.ArtistServices.ArtistService;
import SOA.Model.Services.WeatherServices.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private WeatherService weatherService;


    @RequestMapping("/api/artists")
    public List<String> getAllArtists() {
        return artistService.getAllArtists();
    }


    @RequestMapping(value = "/api/artists", params = "stage")
    public List<String> getArtistsWithStage(@RequestParam(value="stage") String stage)
    {
        return artistService.getArtistsWithStage(stage);
    }


    @RequestMapping(value = "/api/artists", params = {"day", "hour"})
    public List<String> getArtistsWithStage(@RequestParam(value="day") Integer day, @RequestParam(value="hour") Integer hour) {
        System.out.println(day);
        if (hour >= 5 && hour <= 10 && day > 0) {
            return artistService.getArtistsWithDataHour(day, hour);
        }
        else
        {
            List<String> res = new ArrayList<>();
            res.add("Invalid day or hour");
            return res;
        }
    }

    @RequestMapping(value = "/api/artists", params = "artistname")
    public WeatherDetails getWeatherForArtist(@RequestParam(value="artistname") String name)
    {
        ArtistDetails artistDetails = artistService.getDetailsForArtist(name);
        if (artistDetails == null)
        {
            return null;
        }

        int rainChance = weatherService.getRainChanceDayHour(artistDetails.getDay(), artistDetails.getHour());
        System.out.println(rainChance);
        System.out.println(name);
        System.out.println(artistDetails.getDay());
        System.out.println(artistDetails.getHour());
        return new WeatherDetails(artistDetails, rainChance);
    }
}
