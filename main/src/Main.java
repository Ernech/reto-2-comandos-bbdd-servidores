import controllers.GoogleScholarController;
import models.googlescholar.GoogleScholarModel;
import views.GoogleScholarView;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String [] args){
        GoogleScholarModel result = new GoogleScholarModel();
        GoogleScholarView view = new GoogleScholarView();
        GoogleScholarController googleScholarController = new GoogleScholarController(view,result);
       CompletableFuture<Void> future= googleScholarController
               .fetchDataFromApiAsync("https://serpapi.com/search.json?engine=google_scholar&q=biology&start=10&num=5&api_key=ff6cee49548b06aba31daa65961296ba3f39210a8bff7a2a0c86c08188c7e919");
       future.thenRun(()-> googleScholarController.updateView()).join();

    }
}
