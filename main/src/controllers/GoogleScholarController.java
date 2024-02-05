package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.dao.AuthorDao;
import models.googlescholar.GoogleScholarModel;
import models.googlescholar.author.AuthorModel;
import resources.Constants;
import views.GoogleScholarView;

public class GoogleScholarController {

    private GoogleScholarView view;
    private  HttpClient client;
    private AuthorDao authorDao;
    public GoogleScholarController(GoogleScholarView view){
        this.view = view;
        this.client= HttpClient.newHttpClient();
        this.authorDao=new AuthorDao();
    }


    public CompletableFuture<GoogleScholarModel> fetchDataFromApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URI finalUrl = this.buildApiUrl("search.json", Constants.GOOGLE_SCHOLAR_ENGINE, Constants.API_KEY.trim(),
                        "q", "Universidad%20de%20méxico",
                        "start", "10",
                        "num", "10");
                return makeApiRequestAsync(finalUrl)
                        .thenApply(response -> {
                            ObjectMapper objectMapper = new ObjectMapper();
                            try {
                                return objectMapper.readValue(response.body(), GoogleScholarModel.class);
                            } catch (IOException e) {
                                e.printStackTrace();
                                return null;
                            }
                        })
                        .join();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }


    public CompletableFuture<AuthorModel> fetchDataFromAuthorApi(String authorId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URI finalUrl = buildApiUrl("search.json", Constants.GOOGLE_SCHOLAR_AUTHOR_ENGINE, Constants.API_KEY.trim(),
                        "author_id", authorId);
                return makeApiRequestAsync(finalUrl).thenApply(response -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        AuthorModel authorModel = objectMapper.readValue(response.body(), AuthorModel.class);
                        authorDao.insertAuthor(authorModel);
                        return authorModel;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }).join();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    private URI buildApiUrl(String endpoint, String engine, String apiKey, String... params) {
        String apiUrl = String.format("%s%s?engine=%s&api_key=%s", Constants.BASE_GOOGLE_SCHOLAR_URL, endpoint, engine, apiKey);
        for (int i = 0; i < params.length; i += 2) {
            apiUrl += String.format("&%s=%s", params[i], params[i + 1]).trim();
        }
        return URI.create(apiUrl);
    }

    private CompletableFuture<HttpResponse<String>> makeApiRequestAsync(URI finalUrl) {
        HttpRequest request = HttpRequest.newBuilder().uri(finalUrl).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    public void updateView(GoogleScholarModel model){
        if (model!=null){
            view.showOrganicResults(model.getOrganicResults());
            return;
        }
        view.showOrganicResults(null);

    }
}
