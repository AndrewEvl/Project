package Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by entity.User on 28.03.2017.
 */
public class ActorDirector {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdayDay;
    private Set<Film> film = new HashSet<>();
    private Role role;

    public ActorDirector(String firstName, String lastName, LocalDate birthdayDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDay = birthdayDay;
    }

    public ActorDirector(String firstName, String lastName, LocalDate birthdayDay, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDay = birthdayDay;
        this.role = role;
    }

    public ActorDirector(String firstName, String lastName, LocalDate birthdayDay, Set<Film> film) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDay = birthdayDay;
        this.film = film;
    }

    public ActorDirector(long id) {
        this.id = id;
    }

    public ActorDirector(long id, String firstName, String lastName, LocalDate birthdayDay, Set<Film> film) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDay = birthdayDay;
        this.film = film;
    }

    @Override
    public String toString() {
        return "ActorDirector{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdayDay=" + birthdayDay +
                ", film=" + film +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorDirector that = (ActorDirector) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(LocalDate birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public Set<Film> getFilm() {
        return film;
    }

    public void setFilm(Set<Film> film) {
        this.film = film;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
