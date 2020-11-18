package Server.Resource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Server.Database.ConnectionManager;
import Server.Pojo.Sex;


public class SexResource implements Server.Repository.SexRepository
{

    ConnectionManager con;

    public SexResource()
    {
        ConnectionManager.getConnection();

    }

    @Override
    public Sex createSex(Sex sex)
    {
        String sql = "insert into sex(DISCRIPTION) values (?)";
        try

        {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, sex.getDiscription());
            st.executeUpdate();

            ResultSet resultSet= st.getGeneratedKeys();
            int key = resultSet.getInt(1);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return sex;
    }

    public int createSexx(Sex sex)
    {


        String sql = "insert into sex(DISCRIPTION) values (?)";
        int test = 0;
        int last = 0;
        try
        {

            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, sex.getDiscription());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next())
            {
                last = rs.getInt(1);
            }



        }

        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return last;
    }


    @Override
    public Sex getSex(int id)
    {
        String sql = "select * from sex where id="+id;
        Sex sex = new Sex();

        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                sex.setId(rs.getInt(1));
                sex.setDiscription(rs.getString(2));
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return sex;
    }

    public List<Sex> getAllSex()
    {
        List<Sex> sexes = new ArrayList<>();
        String sql = "select * from sex";

        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Sex sex = new Sex();
                sex.setId(rs.getInt(1));
                sex.setDiscription(rs.getString(2));

                sexes.add(sex);
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return sexes;
    }

    public Sex getSexFromDiscription(String DISCRIPTION){
        String sql = "select * from sex where DISCRIPTION="+DISCRIPTION;
        Sex sex = new Sex();

        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                sex.setId(rs.getInt(1));
                sex.setDiscription(rs.getString(2));
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return sex;
    }


    @Override
    public void updateSex(Sex sex)
    {
        String sql = "update sex set DISCRIPTION=? where id=?";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
            st.setString(1, sex.getDiscription());
            st.setInt(2, sex.getId());
            st.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteSex(int id) {
        String sql = "delete from sex where id="+id;

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

