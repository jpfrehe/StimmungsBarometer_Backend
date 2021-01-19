package de.fiduciagad.backend.rating;

import de.fiduciagad.backend.group.Team;
import de.fiduciagad.backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final String teamServiceUrl = "http://localhost:8080/api/v1/group";
    private final String userServiceUrl = "http://localhost:8080/api/v1/user";

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void addRating(Rating rating) {
        Team team = getTeamByName(rating.getTeamName());
        Long teamID = team.getId();
        User user = getUserByName(rating.getMitgliedName());
        Long userID = user.getId();
        rating.setTeamid(teamID);
        rating.setUserId(userID);
        ratingRepository.save(rating);
    }

    public Team getTeamByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Team[] team = restTemplate.getForObject(teamServiceUrl + "/{name}", Team[].class, name);
        if (team.length == 0) {
            return null;
        }
        return team[0];
    }

    public User getUserByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        User[] user = restTemplate.getForObject(userServiceUrl + "/{name}", User[].class, name);
        if (user.length == 0) {
            return null;
        }
        return user[0];
    }
}
