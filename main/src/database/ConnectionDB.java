package database;

import resources.Constants;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    protected Connection connection=null;

    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/".concat(Constants.DB_NAME.trim()),
                    Constants.DB_USER.trim(),Constants.DB_PASSWORD.trim());
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Database connection Error: ".concat(ex.getMessage()));
        }
        return connection;
    }


}
