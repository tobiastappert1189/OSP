package Server.Resource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Server.Database.ConnectionManager;
import Server.Pojo.User;

public class UserRepositorie implements Server.Repository.UserRepository
{

    ConnectionManager con;

    public UserRepositorie()
    {
        ConnectionManager.getConnection();

    }

    @Override
    public User createUser(User user)
    {
        String sql = "insert into user values (?,?,?,?,?)";
        try
        {  PreparedStatement preparedStatement = ConnectionManager.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);

            // autoincrement id;
            st.setInt(1, user.getId());
            st.setString(2, user.getUserName());
            st.setString(3, user.getMail());
            st.setString(4, user.getPassword());
            st.setBoolean(5, user.isManager());
            st.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUser(int id)
    {
        String sql = "select * from user where id="+id;
        User user = new User();

        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setMail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setManager(rs.getBoolean(5));
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getUsers()
    {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";

        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setMail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setManager(rs.getBoolean(5));

                users.add(user);
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return users;
    }

    @Override
    public void updateUser(User user)
    {
        String sql = "update user set userName=?,mail=?,password=?,isManager=? where id=?";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
            st.setString(1, user.getUserName());
            st.setString(2, user.getMail());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.isManager());
            st.setInt(5, user.getId());
            st.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    


}

