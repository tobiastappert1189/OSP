package Server.Repository;

import java.util.List;

import Server.Pojo.User;

public interface UserRepository
{
    User createUser(User user);

    User getUser(int id);

     List<User> getUsers();

     void updateUser(User user);

     void deleteUser(int id);
}
