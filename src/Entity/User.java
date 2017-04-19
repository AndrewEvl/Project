package Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by entity.User on 28.03.2017.
 */
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private LocalDate birthdayDay;
    private String password;
    private String mail;
    private Set<Review> reviews = new HashSet<>();

    public User() {
    }



    public User(String firstName, String lastName, String nickName, String password, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.password = password;
        this.mail = mail;
    }

    public User(long id) {
        this.id = id;
    }

    public User(String firstName, String lastName, String nickName, LocalDate birthdayDay, String password, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthdayDay = birthdayDay;
        this.password = password;
        this.mail = mail;
    }

    public User(String firstName, String lastName, String nickName, LocalDate birthdayDay, String password, String mail, Set<Review> reviews) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthdayDay = birthdayDay;
        this.password = password;
        this.mail = mail;
        this.reviews = reviews;
    }

    public User(long id, String firstName, String lastName, String nickName, LocalDate birthdayDay, String password, String mail, Set<Review> reviews) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthdayDay = birthdayDay;
        this.password = password;
        this.mail = mail;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", birthdayDay=" + birthdayDay +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(LocalDate birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
