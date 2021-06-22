package comgetit.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import comgetit.publication.Publication;
import comgetit.role.Role;
import comgetit.workarea.WorkArea;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @Column
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String phone;

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @Column
    private String address;

    @ManyToMany(fetch = FetchType.LAZY,
    		cascade = {
    				CascadeType.ALL,
    				
    		})
    @JoinTable(name = "user_work_area",
               joinColumns = { @JoinColumn(name= "user_id", nullable = false)},
               inverseJoinColumns = { @JoinColumn(name = "work_area_id", nullable = false) })
    private List<WorkArea> workAreas;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;
    
    private byte[] image;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Publication> publicationList;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "User_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Role_id", referencedColumnName = "id"))
    private List<Role> authorities;

    public User(Long id, String firstname, String lastname, String phone,
        Date birthdate, String address, List<WorkArea> workAreas, String email,
        String password, String image, List<Role> authorities) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.address = address;
        this.workAreas =  workAreas;
        this.email = email;
        this.password = password;
        this.image = image.getBytes();
        this.authorities = authorities;
    }

    protected User() {
    }

    public String getId() {
        return id.toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public List<WorkArea> getWorkAreas() {
        return  workAreas;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<Role> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }
    
    public String getImage() {
    	return new String(image , StandardCharsets.UTF_8);
    }

    @Override
    public String getUsername() {
        return email;
    }

    public List<Publication> getList() {
        return publicationList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
