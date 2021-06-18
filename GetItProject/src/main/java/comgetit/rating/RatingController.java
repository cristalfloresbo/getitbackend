package comgetit.rating;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import comgetit.rating.dto.RatingDTO;
import comgetit.rating.dto.RatingsDTO;

@RestController
public class RatingController {
	private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/rate-user")
    public ResponseEntity<Long> rateUser(
        @RequestBody @Valid final RatingDTO ratingDTO
    ) {
        Rating rating = ratingService.rateUser(ratingDTO);
        return new ResponseEntity(rating.getId(), HttpStatus.CREATED);
    }
    
    /*@GetMapping("/user-rating")
    public List<RatingsDTO> getRatingOfUser() {
        return ratingService.getRatingOfUser();
    }*/
    
    @RequestMapping(method = RequestMethod.GET, value = "/user-rating/{id}")    
    public List<RatingsDTO> getRatingOfUser(@PathVariable Long id) {
        return ratingService.getRatingOfUser(id);
    }
}
