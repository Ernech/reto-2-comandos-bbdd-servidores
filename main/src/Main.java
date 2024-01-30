import controllers.GoogleScholarController;
import models.googlescholar.GoogleScholarModel;
import resources.Constants;
import views.GoogleScholarView;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String [] args){
        GoogleScholarView view = new GoogleScholarView();
        GoogleScholarController googleScholarController = new GoogleScholarController(view);
       CompletableFuture<GoogleScholarModel> future= googleScholarController
               .fetchDataFromApiAsync();
       future.thenAccept(googleScholarModel-> googleScholarController.updateView(googleScholarModel)).join();

    }
}
