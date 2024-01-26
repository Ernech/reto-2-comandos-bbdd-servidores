package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.googlescholar.GoogleScholarModel;
import views.GoogleScholarView;

public class GoogleScholarController {

    private GoogleScholarView view;
    private GoogleScholarModel model;

    public GoogleScholarController(GoogleScholarView view, GoogleScholarModel model) {
        this.view = view;
        this.model = model;
    }

    public CompletableFuture<Void> fetchDataFromApiAsync(String url){
        return CompletableFuture.runAsync(()->{
            try {
            HttpClient client = HttpClient.newHttpClient();
            URI finalUrl = URI.create(url).resolve(String.format("search.json?engine=%s&q=%s&start=%s&num=%s&api_key=%s"
                    ,"google_scholar","Universidad%20de%20méxico","0","10",""));
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(finalUrl)
                    .build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            GoogleScholarModel googleScholarModel = objectMapper.readValue(response.body(),GoogleScholarModel.class);
            this.setModel(googleScholarModel);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        });

    }

    private void setModel(GoogleScholarModel model){
        this.model = model;
    }
    public void updateView(){
        view.showOrganicResults(this.model.getOrganicResults());
    }
}
