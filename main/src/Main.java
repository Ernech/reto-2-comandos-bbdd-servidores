import controllers.GoogleScholarController;
import controllers.TopAuthorsController;
import models.dto.AuthorDto;
import models.googlescholar.GoogleScholarModel;
import resources.Constants;
import views.GoogleScholarView;
import views.TopAuthorsView;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String [] args){

        for (;true;){
            String[] menu ={"Check authors", "Google Scholar","Exit"};
            String valor=(String) JOptionPane.showInputDialog(null,
                    "Choice an option",
                    "Options", JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
            switch (valor){
                case "Check authors":
                    getAuthors();
                    break;
                case "Google Scholar":
                    googleScholarApi();
                    break;
                case "Exit":
                    System.exit(0);
                    break;
            }
        }





    }

    public static void getAuthors(){
        TopAuthorsView topAuthorsView = new TopAuthorsView();
        TopAuthorsController topAuthorsController = new TopAuthorsController(topAuthorsView);
        new Thread(() -> {
            JOptionPane.showMessageDialog(null, "Fetching authors from Data base...");
        }).start();
        List<AuthorDto> authors = topAuthorsController.getTopAuthorsList();
        topAuthorsController.updateView(authors);
        JOptionPane.getRootFrame().dispose();
    }
    public static void googleScholarApi(){
        GoogleScholarView view = new GoogleScholarView();
        GoogleScholarController googleScholarController = new GoogleScholarController(view);
        new Thread(() -> {
            JOptionPane.showMessageDialog(null, "Fetching data from Google Scholar API...");
        }).start();
        CompletableFuture<GoogleScholarModel> future= googleScholarController
                .fetchDataFromApiAsync();
        future.thenAccept(googleScholarModel-> {
            googleScholarController.updateView(googleScholarModel);
            JOptionPane.getRootFrame().dispose();
        }).join();
    }

}
