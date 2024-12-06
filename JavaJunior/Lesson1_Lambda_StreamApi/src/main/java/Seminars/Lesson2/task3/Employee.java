package Seminars.Lesson2.task3;

import java.util.UUID;

@Entity
@Table(name = "users")
public class Employee {

    @Column(name = "id", primaryKey = true)
    private UUID id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private  String emal;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

    public Employee(String username, String emal) {
        this.username = username;
        this.emal = emal;
    }
}
