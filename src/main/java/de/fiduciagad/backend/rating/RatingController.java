package de.fiduciagad.backend.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rating")
public class RatingController {
    private final RatingService ratingService;
    @Autowired
    public RatingController(RatingService ratingService){
        this.ratingService = ratingService;
    }
    @PostMapping
    public @ResponseBody boolean addRating(@RequestBody Rating rating){
        ratingService.addRating(rating);
        return true;

    }

}
