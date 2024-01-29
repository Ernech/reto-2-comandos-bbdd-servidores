package views;

import controllers.GoogleScholarController;
import models.googlescholar.Author;
import models.googlescholar.OrganicResult;
import models.googlescholar.author.AuthorModel;
import resources.Constants;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GoogleScholarView {

    GoogleScholarController googleScholarController = new GoogleScholarController(this,new AuthorModel());

    public void showOrganicResults(List<OrganicResult> results){
        for(OrganicResult result:results){
            System.out.println("==================================");
            System.out.println("Title: ".concat(result.getTitle()));
            System.out.println("Summary: ".concat(result.getPublicationInfo().getSummary()));
            System.out.println("Link: "+result.getLink());
            System.out.println("Authors:");
            if (result.getPublicationInfo().getAuthors()!=null){
                for(Author author:result.getPublicationInfo().getAuthors()){
                    CompletableFuture<Void> futureAuthor = this.googleScholarController
                            .fetchDataFromAuthorApi(Constants.BASE_GOOGLE_SCHOLAR_URL,author.getAuthorId());
                    futureAuthor.thenRun(()-> this.showAuthorInfo(this.googleScholarController.getAuthorModel())).join();
                }
            }
            else {
                System.out.println("**No authors**");
            }
        }
    }

    public void showAuthorInfo(AuthorModel authorModel){
        System.out.println("- Name: "+authorModel.getAuthorInfo().getName());
        System.out.println("- Affiliations: "+authorModel.getAuthorInfo().getAffiliations());
        System.out.println("***********************");
    }

}
