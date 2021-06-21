package comgetit.rating.dto;

import javax.validation.constraints.NotNull;

public class RatingDTO {

	@NotNull
    private Long ratedUser;

	@NotNull
    private Long raterUser;

	@NotNull
    private int score;
	
	public RatingDTO(Long ratedUser, Long raterUser, int score) {
        this.ratedUser = ratedUser;
        this.raterUser = raterUser;
        this.score = score;
    }
    
    public void setRatedUser(Long ratedUser) {
		this.ratedUser = ratedUser;
	}

	public void setRaterUser(Long raterUser) {
		this.raterUser = raterUser;
	}

	public void setScore(int score) {
		this.score = score;
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
