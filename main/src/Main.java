import controllers.GoogleScholarController;

public class Main {
    public static void main(String [] args){
        GoogleScholarController.fetchDataFromApi("https://pokeapi.co/api/v2/pokemon?limit=10&offset=0");
        GoogleScholarController.fetchDataFromApiAsync("https://pokeapi.co/api/v2/pokemon?limit=10&offset=0");
    }
}
