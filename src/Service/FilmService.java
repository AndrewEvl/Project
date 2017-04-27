package Service;

import Dao.FilmDao;
import Entity.Film;
import Entity.Ganre;

import java.util.List;

/**
 * Created by User on 18.04.2017.
 */
public class FilmService {
    private static final Object LOCK = new Object();
    private static FilmService INSTANCE = null;

    public static FilmService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new FilmService();
                }
            }
        }
        return INSTANCE;
    }

    public Film addFilm (Film film, long ganreID){
        FilmDao.getInstance().save(film,ganreID);
        return film;
    }

    public Film yearFilm (Film film){
        FilmDao.getInstance().getByYear(film.getReleaseDay());
        return film;
    }

    public Film idFilm (Film film){
        FilmDao.getInstance().getById(film.getId());
        return film;
    }

    public Film nameFilm (Film film) {
        FilmDao.getInstance().getByName(film.getName());
        return film;
    }

    public List<Ganre> fullGenres() {
        return FilmDao.getInstance().findAllGenre();
    }

    public List<Film> fullInfiFilm(){
        return FilmDao.getInstance().fullInfo();
    }

}
