package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.db.DBConnection;

import java.sql.ResultSet;

@Service
public class ServiceDB {
    @Autowired
    private DBConnection dbConnection;

    /**
     *
     * tableName - name table
     */
    public String selectAllFrom(String tableName) {
//        String resultSet = dbConnection.execute(createQuery(tableName));
        return "Table noot found";
    }


    private String createQuery(String tableName) {
        return "SELECT * FROM " + tableName + ";";
    }

}
