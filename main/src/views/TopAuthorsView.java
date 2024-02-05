package views;

import models.dao.AuthorDao;
import models.dto.AuthorDto;

import java.sql.SQLException;
import java.util.List;

public class TopAuthorsView {

    private TopAuthorsView topAuthorsView;
    private AuthorDao authorDao;
    public TopAuthorsView() {
    }

    public TopAuthorsView(TopAuthorsView topAuthorsView) {
        this.topAuthorsView = topAuthorsView;
        this.authorDao = new AuthorDao();
    }

    public List<AuthorDto> getTopAuthorsView(){
        try {
            return authorDao.getTopAuthorsByCitations();
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }

    }

    public void updateView(List<AuthorDto> authors){

    }




}
