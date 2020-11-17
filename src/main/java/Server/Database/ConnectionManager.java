package Server.Database;
import static utils.FileUtil.readFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectionManager {
    static String initialFill;
    static final String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "root";
    static final String urlstring = "jdbc:mysql://localhost:3306/db_example?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static Connection con;


    public static Connection getConnection() {
        initialFill = readFile("sql/initialFill.sql");
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
                update(initialFill);
                commit();
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }

        return con;
    }

    public boolean isConnected() {
        return con != null;
    }


    public static void update(String query, Object... parameters) throws SQLException {
        try (PreparedStatement ps = prepareStatement(query, parameters)) {
            ps.executeUpdate();
        }
    }

    public static PreparedStatement prepareStatement(String query,
            Object... parameters) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            ps.setObject(i + 1, parameters[i]);
        }
        return ps;
    }

 public void destroy() {
        try {
            if (isConnected()) {
                con.close();
            }
        } catch (SQLException e) {
            //log.error("Unable to close connection: {}", e.getMessage());
        }
    }
    public static void commit() throws SQLException {
        con.commit();
    }

}