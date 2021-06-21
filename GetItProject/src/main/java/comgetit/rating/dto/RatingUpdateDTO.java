package comgetit.rating.dto;

import javax.validation.constraints.NotNull;

public class RatingUpdateDTO {
	@NotNull
	private int score;
    
    public RatingUpdateDTO(int score) {
        this.score = score;
    }

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
