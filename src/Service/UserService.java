package Service;

import Dao.UserDao;
import Entity.Role;
import Entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 15.04.2017.
 */
public class UserService {

    private static final Object LOCK = new Object();
    private static UserService INSTANCE = null;

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public User addUser(User user) {
        UserDao.getInstance().save(user);
        return user;
    }

    public User userInfo(User user) {
        UserDao.getInstance().info(user);
        return user;
    }

    public List<Role> allRole() {
        return UserDao.getInstance().findAllRole();

    }
}
