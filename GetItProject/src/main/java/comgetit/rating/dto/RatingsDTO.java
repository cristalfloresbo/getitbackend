package comgetit.rating.dto;

import javax.validation.constraints.NotNull;

import comgetit.rating.Rating;

public class RatingsDTO {
	
	private Long id;
	
	@NotNull
    private Long ratedUser;

	@NotNull
    private Long raterUser;

	@NotNull
    private int score;
    
    public RatingsDTO(final Rating rating) {
    	this.id = rating.getId();
        this.ratedUser = rating.getRatedUser();
        this.raterUser = rating.getRaterUser();
        this.score = rating.getScore();
    }

    public Long getId() {
    	return id;
    }
   
    public Long getRatedUser() {
        return ratedUser;
    }

    public Long getRaterUser() {
        return raterUser;
    }
    
    public int getScore() {
        return score;
    }
}
