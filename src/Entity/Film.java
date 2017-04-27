package Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by entity.User on 28.03.2017.
 */
public class Film {
    private long id;
    private String name;
    private Set<ActorDirector> actors = new HashSet<>();
    private Set<ActorDirector> director = new HashSet<>();
    private LocalDate releaseDay;
    private String county;
    private Ganre ganre;
    private Set<Review> reviews = new HashSet<>();

    public Film(String name, LocalDate releaseDay, String county) {
        this.name = name;
        this.releaseDay = releaseDay;
        this.county = county;
    }

    public Film(long id) {
        this.id = id;
    }

    public Film (Ganre genre, long id) {
        this.id = id;
        this.ganre = genre;
    }

    public Film(String name) {
        this.name = name;
    }

    public Film(LocalDate releaseDay) {
        this.releaseDay = releaseDay;
    }

    public Film(String name, LocalDate releaseDay, String county, Ganre genre) {
        this.name = name;
        this.releaseDay = releaseDay;
        this.county = county;
        this.ganre = genre;
    }

    public Film(LocalDate releaseDay, String name) {
        this.name = name;
        this.releaseDay = releaseDay;
    }


    public Film(long id, String name) {
        this.id = id;
    }

    public Film(String name, Date date, String string, String resultSetString) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actors=" + actors +
                ", director=" + director +
                ", releaseDay=" + releaseDay +
                ", county='" + county + '\'' +
                ", genre='" + ganre + '\'' +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ActorDirector> getActors() {
        return actors;
    }

    public void setActors(Set<ActorDirector> actors) {
        this.actors = actors;
    }

    public Set<ActorDirector> getDirector() {
        return director;
    }

    public void setDirector(Set<ActorDirector> director) {
        this.director = director;
    }

    public LocalDate getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(LocalDate releaseDay) {
        this.releaseDay = releaseDay;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Ganre getGenre() {
        return ganre;
    }

    public void setGenre(Ganre genre) {
        this.ganre = genre;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}