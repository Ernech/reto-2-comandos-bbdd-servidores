package controllers;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.PokemonModel;
import models.Result;
import views.GoogleScholarView;

public class GoogleScholarController {

    private GoogleScholarView view;
    private PokemonModel model;

    public GoogleScholarController(GoogleScholarView view, PokemonModel model) {
        this.view = view;
        this.model = model;
    }

    public static void fetchDataFromApi(String url){

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void fetchDataFromApiAsync(String url){
        CompletableFuture.runAsync(()->{
            try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
                ObjectMapper objectMapper = new ObjectMapper();
                PokemonModel pokemonModel = objectMapper.readValue(response.body(),PokemonModel.class);
                this.setModel(pokemonModel);
                //System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        }).join();

    }

    private void setModel(PokemonModel model){
        this.model = model;
    }
    public void updateView(){
        view.showResults(this.model.getResults());
    }
}
