package comgetit.rating.dto;

import javax.validation.constraints.NotNull;

import comgetit.rating.Rating;

public class RatingsDTO {
	
	private String id;
	
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

    public String getId() {
    	return id;
    }
   
    public String getRatedUser() {
        return ratedUser.toString();
    }

    public Long getRaterUser() {
        return raterUser;
    }
    
    public int getScore() {
        return score;
    }
}
