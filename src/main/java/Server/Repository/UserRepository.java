package Server.Repository;

import java.util.List;

import Server.Pojo.User;

public interface UserRepository
{
    User createUser(User user);

    User getUser(int id);

     public List<User> getUsers();

     public void updateUser(User user);
}
