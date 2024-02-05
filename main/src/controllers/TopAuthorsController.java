package controllers;

import models.dao.AuthorDao;
import models.dto.AuthorDto;
import views.TopAuthorsView;

import java.sql.SQLException;
import java.util.List;

public class TopAuthorsController {

    private TopAuthorsView topAuthorsView;
    private AuthorDao authorDao;
    public TopAuthorsController() {
    }

    public TopAuthorsController(TopAuthorsView topAuthorsView) {
        this.topAuthorsView = topAuthorsView;
        this.authorDao = new AuthorDao();
    }

    public List<AuthorDto> getTopAuthorsList(){
        try {
            return authorDao.getTopAuthorsByCitations();
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

    public void updateView(List<AuthorDto> authors){
            this.topAuthorsView.showAuthors(authors);
    }



}
