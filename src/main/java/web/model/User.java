// src/main/java/web/model/User.java
package web.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(name = "name")
    @NotEmpty(message = "Dont Empty!")
    @Size(min = 2, max = 35)
    private final String username;

    @Column(name = "age")
    private final Byte age;

    @Column(name = "city")
    @Size(max = 50)
    private final String city;

    public User() {
        this.id = null;
        this.username = null;
        this.age = null;
        this.city = null;
    }

    public User(final String username, final Byte age, final String city) {
        this.id = null;
        this.username = username;
        this.age = age;
        this.city = city;
    }

    public User(final Long id, final String username, final Byte age, final String city) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Byte getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}