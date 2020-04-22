package Alteration.model;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
@Table(name = "userThymeleaf")

public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fName",unique = true )
    private String firstName;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "lName")
    private String lastName;

    @Column(name = "password")
    @ReadOnlyProperty
    private String password;

    @Column(name = "age")
    private int age;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userT_rolesT",
            joinColumns =@JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    transient private String confirmPassword;

    public User() {
    }

    public User(long id,String firstName,String lastName,String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;

    }

    public User(String firstName,String lastName,String email,String password, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }
    public User(String firstName,String lastName,String email, int age,Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.roles=roles;
    }

    public User(Long id, String firstName,String lastName,String email, String password, int age) {
        this(firstName,lastName,email, password, age);
        this.id = id;
    }
    public User( String firstName,String lastName,String email, String password, int age,Set<Role> roles) {
        this(firstName,lastName,email, password, age);
        this.roles = roles;
    }
    public User(Long id, String firstName,String lastName,String email, String password, int age,Set<Role> roles) {
        this(firstName,lastName,email, password, age);
        this.id = id;
        this.roles = roles;
    }
    public boolean isAdmin(User user){
        boolean rezult =false;
        for (Role role:user.getRoles()){
            if (role.getRole().equals("ADMIN")){
                rezult = true;
            }
        }
        return rezult;
    }
    public boolean isUser(User user){
        boolean rezult =false;
        for (Role role:user.getRoles()){
            if (role.getRole().equals("USER")){
                rezult = true;
            }
        }
        return rezult;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRolesString(Set<Role> roles){
        String rezult = "";
        for (Role role: roles){
            rezult = rezult + role.toString().replace("{","").replace("}","")+" ";
        }
        return rezult;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return getRoles();
    }

    @Override
    public String getUsername() {
        return getFirstName();
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
