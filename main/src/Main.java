import controllers.GoogleScholarController;
import models.googlescholar.GoogleScholarModel;
import resources.Constants;
import views.GoogleScholarView;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String [] args){
        GoogleScholarModel result = new GoogleScholarModel();
        GoogleScholarView view = new GoogleScholarView();
        GoogleScholarController googleScholarController = new GoogleScholarController(view,result);
       CompletableFuture<Void> future= googleScholarController
               .fetchDataFromApiAsync(Constants.BASE_GOOGLE_SCHOLAR_URL);
       future.thenRun(()-> googleScholarController.updateView()).join();

    }
}
