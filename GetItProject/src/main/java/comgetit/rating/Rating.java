package comgetit.rating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rating")
public class Rating {
	
	@Id
    @Column
    private Long id;

    @Column
    private Long ratedUser;

    @Column
    private Long raterUser;

    @Column
    private int score;
    
    public Rating(Long id, Long ratedUser, Long raterUser, int score) {
        super();
        this.id = id;
        this.ratedUser = ratedUser;
        this.raterUser = raterUser;
        this.score = score;
    }

    protected Rating(){}

    public String getId() {
        return id.toString();
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
    
    public void setRatedUser(Long ratedUser) {
		this.ratedUser = ratedUser;
	}

	public void setRaterUser(Long raterUser) {
		this.raterUser = raterUser;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
