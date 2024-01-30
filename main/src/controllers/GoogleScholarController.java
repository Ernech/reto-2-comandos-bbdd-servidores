package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.googlescholar.GoogleScholarModel;
import models.googlescholar.author.AuthorModel;
import resources.Constants;
import views.GoogleScholarView;

public class GoogleScholarController {

    private GoogleScholarView view;
    private GoogleScholarModel model;
    private  HttpClient client;
    private AuthorModel authorModel;

    public GoogleScholarController(GoogleScholarView view, AuthorModel authorModel){
        this.view = view;
        this.authorModel = authorModel;
        this.client= HttpClient.newHttpClient();
    }

    public GoogleScholarController(GoogleScholarView view, GoogleScholarModel model) {
        this.view = view;
        this.model = model;
        this.client = HttpClient.newHttpClient();
    }

    public CompletableFuture<Void> fetchDataFromApiAsync(String url){
        return CompletableFuture.runAsync(()->{
            try {

            URI finalUrl = URI.create(url).resolve(String.format("search.json?engine=%s&q=%s&start=%s&num=%s&api_key=%s",
                    Constants.GOOGLE_SCHOLAR_ENGINE,
                    "Universidad%20de%20méxico",
                    "0","10",
                    Constants.API_KEY.trim()));
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(finalUrl)
                    .build();

            HttpResponse<String> response = this.client.send(request,HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            GoogleScholarModel googleScholarModel = objectMapper.readValue(response.body(),GoogleScholarModel.class);
            this.setModel(googleScholarModel);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        });


    }

    public CompletableFuture<Void> fetchDataFromAuthorApi(String url, String authorId){
            return CompletableFuture.runAsync(()->{
               try{
                    URI finalUrl = URI.create(url).resolve(String.format("search.json?engine=%s&author_id=%s&api_key=%s"
                        ,Constants.GOOGLE_SCHOLAR_AUTHOR_ENGINE,
                        authorId,
                            Constants.API_KEY.trim()));
                    HttpRequest httpRequest = HttpRequest
                        .newBuilder().uri(finalUrl).build();
                    HttpResponse<String> response = this.client.send(httpRequest,HttpResponse.BodyHandlers.ofString());
                    ObjectMapper objectMapper = new ObjectMapper();
                    AuthorModel authorModel = objectMapper.readValue(response.body(),AuthorModel.class);
                    this.setAuthorModel(authorModel);

               } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            });


    }
    private void setModel(GoogleScholarModel model){
        this.model = model;
    }
    private void setAuthorModel(AuthorModel model) {this.authorModel=model;}
    public AuthorModel getAuthorModel() {return this.authorModel;}
    public void updateView(){
        view.showOrganicResults(this.model.getOrganicResults());
    }
}
