package Alteration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements GrantedAuthority {

    private long id;

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
        return name;
    }
}
