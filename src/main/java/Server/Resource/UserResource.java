package Server.Resource;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Server.Database.ConnectionManager;
import Server.Pojo.User;
import Server.Repository.UserRepository;

public class UserResource implements UserRepository
{

    ConnectionManager con;

    public UserResource(ConnectionManager con)
    {
        this.con = con;
    }

    @Override
    public User createUser(User user)
    {
        String sql = "insert into user values (?,?,?)";
        try
        {

            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);

            st.setInt(1,user.getId());
            st.setString(2,user.getMail());
            st.setString(3,user.getUserName());


        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return user;

    }

    }

