package Service;

import Dao.ActorDirectorDao;
import Entity.ActorDirector;
import Entity.Ganre;
import Entity.Role;

import java.util.Optional;

/**
 * Created by User on 18.04.2017.
 */
public class ActorDirectorService {
    private static final Object LOCK = new Object();
    private static ActorDirectorService INSTANCE = null;

    public static ActorDirectorService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ActorDirectorService();
                }
            }
        }
        return INSTANCE;
    }
    public ActorDirector addActorDirector (ActorDirector actorDirector, Role role){
        ActorDirectorDao.getInstance().save(actorDirector, role);
        return actorDirector;
    }
}
