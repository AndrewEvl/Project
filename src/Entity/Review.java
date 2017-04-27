package Entity;

/**
 * Created by entity.User on 28.03.2017.
 */
public class Review {
    private long id;
    private Film film;
    private User user;
    private String text;
    private double mark;

    public Review(String text, double mark) {
        this.text = text;
        this.mark = mark;
    }

    public Review(Film film, User user, String text, double mark) {
        this.film = film;
        this.user = user;
        this.text = text;
        this.mark = mark;
    }

    public Review(long id, Film film, User user, String text, double mark) {
        this.id = id;
        this.film = film;
        this.user = user;
        this.text = text;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", film=" + film +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        return id == review.id;
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
