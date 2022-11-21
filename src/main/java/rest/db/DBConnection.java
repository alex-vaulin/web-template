package rest.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

public abstract class DBConnection {
    @Value("${db.url}")
    private static String url;
    @Value("${db.user}")
    private static String user;

    @Value("${db.password}")
    private static String password;
    public ResultSet execute(String sql) {
        try (Connection connection = DriverManager.getConnection(url, user, password);) {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
