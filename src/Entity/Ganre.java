package Entity;

/**
 * Created by User on 26.04.2017.
 */
public class Ganre {
    private long id;
    private String name;

    public Ganre(long id) {
        this.id = id;
    }

    public Ganre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ganre(String name) {
        this.name = name;
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
}
