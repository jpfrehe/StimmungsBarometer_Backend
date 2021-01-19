package de.fiduciagad.backend.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
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
