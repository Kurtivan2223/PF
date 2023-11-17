package FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/System";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection connect()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            return connection;
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void disconnect()
    {
        try {
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
