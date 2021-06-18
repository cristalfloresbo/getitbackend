package comgetit.rating;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comgetit.rating.dto.RatingDTO;
import comgetit.rating.dto.RatingsDTO;

@Service
public class RatingService {
	
	private final RatingRepository ratingRepository;
	
	@Autowired
	public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
	
	public Rating rateUser(final RatingDTO ratingDTO) {
		Rating rating = new Rating(UUID.randomUUID().getMostSignificantBits(),
        		ratingDTO.getRatedUser(), ratingDTO.getRaterUser(),
        		ratingDTO.getScore());
        return ratingRepository.save(rating);
    }
	 
	 public List<RatingsDTO> getRatingOfUser(Long ratedUser) {
	        return ratingRepository.findRatingByRatedUser(ratedUser).stream()
	            .map(RatingsDTO::new)
	            .collect(Collectors.toList());
	 }
}
