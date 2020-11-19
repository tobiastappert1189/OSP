package Server.Resource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Server.Database.ConnectionManager;
import Server.Pojo.Tour;

public class TourResource implements Server.Repository.TourRepository
{

        ConnectionManager con;

        public TourResource()
        {
            ConnectionManager.getConnection();

        }

        @Override
        public Tour createTour(Tour tour)
        {
            String sql = "insert into tour(destinationPlz,startPlz,dateTime,arriveDrive,hasSize,isSmoker,isAnimal,isLuggage,wishedPerson,discription,provider) values (?,?,?,?,?,?,?,?,?,?,?)";
            try

            {
                PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                st.setInt(1, tour.getDestinationPlz());
                st.setInt(2, tour.getStartPlz());
                st.setTimestamp(3, java.sql.Timestamp.valueOf(tour.getDateTime()));
                st.setBoolean(4, tour.isArriveDrive());
                st.setInt(5, tour.getSize());
                st.setBoolean(6, tour.isSmoking());
                st.setBoolean(7, tour.isAnimal());
                st.setBoolean(8, tour.isLuggage());
                st.setInt(9,tour.getWishedPersonId());
                st.setString(10,tour.getDiscription());
                st.setInt(11,tour.getProvider());

                st.executeUpdate();

                ResultSet resultSet= st.getGeneratedKeys();
                int key = resultSet.getInt(1);
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
            return tour;
        }

        @Override
        public Tour getTour(int id)
        {
            String sql = "select * from tour where id="+id;
            Tour tour = new Tour();

            try {
                Statement st = ConnectionManager.getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    tour.setId(rs.getInt(1));
                    tour.setDestinationPlz(rs.getInt(2));
                    tour.setStartPlz(rs.getInt(3));
                    tour.setDateTime((rs.getTimestamp(4).toLocalDateTime()));
                    tour.setArriveDrive(rs.getBoolean(5));
                    tour.setSize(rs.getInt(6));
                    tour.setSmoking(rs.getBoolean(7));
                    tour.setAnimal(rs.getBoolean(8));
                    tour.setLuggage(rs.getBoolean(9));
                    tour.setWishedPersonId(rs.getInt(10));
                    tour.setDiscription(rs.getString(11));
                    tour.setProvider(rs.getInt(12));
                }
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
            return tour;
        }

        @Override
        public List<Tour> getTours()
        {
            List<Tour> tours = new ArrayList<>();
            String sql = "select * from tour where hasSize > 0";

            try {
                Statement st = ConnectionManager.getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);

                while(rs.next()){
                    Tour tour = new Tour();
                        tour.setId(rs.getInt(1));
                        tour.setDestinationPlz(rs.getInt(2));
                        tour.setStartPlz(rs.getInt(3));
                        tour.setDateTime((rs.getTimestamp(4).toLocalDateTime()));
                        tour.setArriveDrive(rs.getBoolean(5));
                        tour.setSize(rs.getInt(6));
                        tour.setSmoking(rs.getBoolean(7));
                        tour.setAnimal(rs.getBoolean(8));
                        tour.setLuggage(rs.getBoolean(9));
                        tour.setWishedPersonId(rs.getInt(10));
                        tour.setDiscription(rs.getString(11));
                        tour.setProvider(rs.getInt(12));

                    tours.add(tour);
                }

            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

            return tours;
        }

        public void teilnehmen(int tourId){
            Tour tour = getTour(tourId);

            if(tour.getSize() > 0)
            {

                int oldplätze = tour.getSize();
                int newPlätze = oldplätze - 1;
                tour.setSize(newPlätze);
                updateTour(tour);
            }

            System.out.println("falsch!");

            }


        @Override
        public void updateTour(Tour tour)
        {
            String sql = "update tour set destinationPlz=?,startPlz=?,dateTime=?,arriveDrive=?,hasSize=? ,isSmoker=?,isAnimal=?,isLuggage=? ,wishedPerson=?,discription=?,provider=? where id=?";
            try{
                PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
                st.setInt(1,tour.getDestinationPlz());
                st.setInt(2,tour.getStartPlz());
                st.setTimestamp(3,java.sql.Timestamp.valueOf(tour.getDateTime()));
                st.setBoolean(4,tour.isArriveDrive());
                st.setInt(5,tour.getSize());
                st.setBoolean(6,tour.isSmoking());
                st.setBoolean(7,tour.isAnimal());
                st.setBoolean(8,tour.isLuggage());
                st.setInt(9,tour.getWishedPersonId());
                st.setString(10,tour.getDiscription());
                st.setInt(11,tour.getProvider());
                st.setInt(12,tour.getId());
                st.executeUpdate();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        @Override
        public void deleteTour(int id) {
            String sql = "delete from user where tour="+id;

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
