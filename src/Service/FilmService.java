package Service;

import Dao.FilmDao;
import Entity.ActorDirector;
import Entity.Film;

import java.util.Optional;

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

    public Film addFilm (Film film){
        Optional<Film> save = FilmDao.getInstance().save(film);
        return film;
    }

    public Film yearFilm (Film film){
        Optional<Film> year = FilmDao.getInstance().getByYear(film.getReleaseDay());
        return film;
    }

    public Film idFilm (Film film){
        Optional<Film> id = FilmDao.getInstance().getById(film.getId());
        return film;
    }

}
