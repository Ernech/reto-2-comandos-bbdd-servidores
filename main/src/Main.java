import controllers.GoogleScholarController;
import models.PokemonModel;
import views.GoogleScholarView;

public class Main {
    public static void main(String [] args){
        PokemonModel model = new PokemonModel();
        GoogleScholarView view = new GoogleScholarView();
        GoogleScholarController googleScholarController = new GoogleScholarController(view,model);
        googleScholarController.fetchDataFromApiAsync("https://pokeapi.co/api/v2/pokemon?limit=10&offset=0");
        googleScholarController.updateView();

    }
}
