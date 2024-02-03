package models.dao;

import database.ConnectionDB;
import models.googlescholar.author.AuthorModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDao {

    public void insertAuthor(AuthorModel authorModel){

        String sql = "INSERT INTO `authors` (`author_id`, `author_name`, `carrer`,`citations`,`email`,`affiliations`) \n" +
                "VALUES (?,?,?,?,?,?)";
        ConnectionDB connectionDB =  new ConnectionDB();
        Connection connection = (Connection) connectionDB.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,authorModel.getSearchParameters().getAuthorId());
            statement.setString(2,authorModel.getAuthorInfo().getName());
            statement.setString(3,authorModel.getAuthorInfo().getInterests().get(0).getTitle());
            statement.setInt(4,authorModel.getCitedBy().getTable().get(0).getCitations().getAll());
            statement.setString(5,authorModel.getAuthorInfo().getEmail());
            statement.setString(6,authorModel.getAuthorInfo().getAffiliations());
            statement.executeUpdate();
            connection.close();
        }catch (SQLException exception){
            JOptionPane.showMessageDialog(null,"Error during author creation: ".concat(exception.getMessage()));
        }

    }

}
