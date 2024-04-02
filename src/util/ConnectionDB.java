package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/session07_jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    public static Connection openConnection(){
        Connection connection;
        try {
            // đăng ký driver
            Class.forName(DRIVER);
            // khởi tạo đối tượng connection thông qua Driver Manager
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
