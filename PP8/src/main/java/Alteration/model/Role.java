package Alteration.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roleThymeleaf")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role",unique = true)
    private String name;


    public Role() {
    }

    public Role(long id) {
        this.id = id;
    }

    public Role(long id,String name) {
        this.id= id;
        this.name = name;
    }
    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return name;
    }

    public void setRole(String role) {
        this.name = role;
    }



    @Override
    public String toString() {
        return '{' + name +
                '}';
    }
}
