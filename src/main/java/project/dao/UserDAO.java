package project.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.module.User;

import java.util.List;

@Repository("userRepository")
public interface UserDAO {
    public User getUser(long id);
    public long addUser(User usersEntity);
    public void removeUser(long id);
    @Query("select user from User user")
    public List<User> listUser();
    public void changeUser(User usersEntity);
    public void registrUser(User usersEntity);
    public User getUserWithLogin(String login);
}
