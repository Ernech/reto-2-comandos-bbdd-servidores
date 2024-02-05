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
            statement.setString(1,this.getAuthorId(authorModel));
            statement.setString(2,this.getAuthorName(authorModel));
            statement.setString(3, this.getAuthorTitle(authorModel));
            statement.setInt(4, this.getAuthorCitations(authorModel));
            statement.setString(5,this.getAuthorEmail(authorModel));
            statement.setString(6, this.getAuthorAffiliation(authorModel));
            statement.executeUpdate();
            connection.close();
        }catch (SQLException exception){
            JOptionPane.showMessageDialog(null,"Error during author creation: ".concat(exception.getMessage()));
        }

    }

    private String getAuthorId(AuthorModel authorModel){
        try{
            return authorModel.getSearchParameters().getAuthorId();
        }catch (NullPointerException ex){
            return "--";
        }
    }

    private String getAuthorName(AuthorModel authorModel){
        try{
            return authorModel.getAuthorInfo().getName();
        }catch (NullPointerException ex){
            return "--";
        }
    }

    private String getAuthorTitle(AuthorModel authorModel){
        try {
            return authorModel.getAuthorInfo().getInterests().get(0).getTitle();
        }
        catch (NullPointerException ex){
            return "--";
        }
    }

    private int getAuthorCitations(AuthorModel authorModel){
        try {
            return authorModel.getCitedBy().getTable().get(0).getCitations().getAll();
        }
        catch (NullPointerException ex){
            return 0;
        }
    }

    private String getAuthorEmail(AuthorModel authorModel){
        try {
            return authorModel.getAuthorInfo().getEmail();
        }
        catch (NullPointerException ex){
            return "--";
        }
    }

    private String getAuthorAffiliation(AuthorModel authorModel){
        try{
            return authorModel.getAuthorInfo().getAffiliations();
        }catch (NullPointerException ex){
            return "--";
        }
    }


}
