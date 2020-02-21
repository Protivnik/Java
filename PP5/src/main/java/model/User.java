package model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role ="user";

    public User() {

    }

    public User(String name,String password, String email, int age, boolean sex) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.sex = sex;
    }
    public User(String name,String password, String email, int age,String role, boolean sex) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.role = role;
    }

    public User(int id, String name,String password, String email, int age,String role, boolean sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


}
