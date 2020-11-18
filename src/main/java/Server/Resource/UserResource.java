package Server.Resource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Server.Database.ConnectionManager;
import Server.Pojo.User;

public class UserResource implements Server.Repository.UserRepository
{

    ConnectionManager con;

    public UserResource()
    {
        ConnectionManager.getConnection();

    }

    @Override
    public User createUser(User user)
    {
        String sql = "insert into user(userName,mail,password,isManager,sex) values (?,?,?,?,?)";
        try
                
        {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            st.setString(1, user.getUserName());
            st.setString(2, user.getMail());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.isManager());
            st.setInt(5, user.getSex());
            st.executeUpdate();

            ResultSet resultSet= st.getGeneratedKeys();
            int key = resultSet.getInt(1);
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
                user.setSex(rs.getInt(6));
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
                user.setSex(rs.getInt(6));

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
        String sql = "update user set userName=?,mail=?,password=?,isManager=?,sex=? where id=?";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
            st.setString(1, user.getUserName());
            st.setString(2, user.getMail());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.isManager());
            st.setInt(5,user.getSex());
            st.setInt(6, user.getId());
            st.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id="+id;

        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
            st.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }


}

