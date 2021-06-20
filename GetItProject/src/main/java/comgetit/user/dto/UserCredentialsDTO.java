package comgetit.user.dto;

public class UserCredentialsDTO {

    private String email;

    private String password;

    private UserCredentialsDTO() {

    }

    public UserCredentialsDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
