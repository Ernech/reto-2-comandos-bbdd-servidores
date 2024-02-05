import controllers.GoogleScholarController;
import controllers.TopAuthorsController;
import models.dto.AuthorDto;
import models.googlescholar.GoogleScholarModel;
import resources.Constants;
import views.GoogleScholarView;
import views.TopAuthorsView;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String [] args){
      /*  GoogleScholarView view = new GoogleScholarView();
        GoogleScholarController googleScholarController = new GoogleScholarController(view);
       CompletableFuture<GoogleScholarModel> future= googleScholarController
               .fetchDataFromApiAsync();
       future.thenAccept(googleScholarModel-> googleScholarController.updateView(googleScholarModel)).join();*/
        TopAuthorsView topAuthorsView = new TopAuthorsView();
        TopAuthorsController topAuthorsController = new TopAuthorsController(topAuthorsView);
        List<AuthorDto> authors = topAuthorsController.getTopAuthorsList();
        topAuthorsController.updateView(authors);

    }
}
