package de.fiduciagad.backend.rating;

import de.fiduciagad.backend.group.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final String teamServiceUrl = "http://localhost:8080/api/v1/group";

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void addRating(Rating rating) {
        Team team = getByName(rating.getTeamName());

        Long teamID = getByName(rating.getTeamName()).getId();
        rating.setTeamid(teamID);
        ratingRepository.save(rating);
    }

    public Team getByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Team[] team = restTemplate.getForObject(teamServiceUrl + "/{name}", Team[].class, name);
        if (team.length == 0) {
            return null;
        }
        return team[0];
    }
}
