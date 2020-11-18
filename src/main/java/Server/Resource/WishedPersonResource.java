package Server.Resource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Server.Database.ConnectionManager;
import Server.Pojo.WishedPerson;
import Server.Repository.WishedPersonRepository;

public class WishedPersonResource implements WishedPersonRepository
{
    ConnectionManager con;

    public WishedPersonResource()
    {
        ConnectionManager.getConnection();

    }

    @Override
    public WishedPerson createWishedPerson(WishedPerson wishedPerson)
    {
        String sql = "insert into WISHEDPERSON(DISCRIPTION) values (?)";
        try

        {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, wishedPerson.getDiscription());
            st.executeUpdate();

            ResultSet resultSet= st.getGeneratedKeys();
            int key = resultSet.getInt(1);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return wishedPerson;
    }


    public int createWishedPersonReturnInt(WishedPerson wishedPerson)
    {


        String sql = "insert into WISHEDPERSON(DISCRIPTION) values (?)";
        int test = 0;
        int last = 0;
        try
        {

            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, wishedPerson.getDiscription());

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
    public WishedPerson getWishedPerson(int id)
    {
        String sql = "select * from WISHEDPERSON where id="+id;
        WishedPerson wishedPerson = new WishedPerson();

        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                wishedPerson.setId(rs.getInt(1));
                wishedPerson.setDiscription(rs.getString(2));
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return wishedPerson;
    }

    @Override
    public List<WishedPerson> getAllWishedPerson()
    {
            List<WishedPerson> wishedPersons = new ArrayList<>();
            String sql = "select * from WISHEDPERSON";

            try {
                Statement st = ConnectionManager.getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    WishedPerson wishedPerson = new WishedPerson();
                    wishedPerson.setId(rs.getInt(1));
                    wishedPerson.setDiscription(rs.getString(2));

                    wishedPersons.add(wishedPerson);
                }

            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

            return wishedPersons;
    }

    public WishedPerson getWishedPersonFromDiscription(String DISCRIPTION){
        String sql = "select * from WISHEDPERSON where DISCRIPTION="+DISCRIPTION;
        WishedPerson wishedPerson = new WishedPerson();

        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                wishedPerson.setId(rs.getInt(1));
                wishedPerson.setDiscription(rs.getString(2));
            }

        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return wishedPerson;
    }

    @Override
    public void updateWishedPerson(WishedPerson sex)
    {
        String sql = "update WISHEDPERSON set DISCRIPTION=? where id=?";
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
    public void deleteWishedPerson(int id)
    {
        String sql = "delete from WISHEDPERSON where id="+id;

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

