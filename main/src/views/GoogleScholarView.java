package views;

import controllers.GoogleScholarController;
import models.googlescholar.Author;
import models.googlescholar.OrganicResult;
import models.googlescholar.author.AuthorModel;
import resources.Constants;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GoogleScholarView {

    GoogleScholarController googleScholarController = new GoogleScholarController(this,new AuthorModel());
    JTextArea jTextArea = new JTextArea(40,80);
    JScrollPane jScrollPane = new JScrollPane(jTextArea);
    public void showOrganicResults(List<OrganicResult> results){
        for(OrganicResult result:results){
            jTextArea.append("==================================\n");
            jTextArea.append("Title: ".concat(result.getTitle()).concat("\n"));
            jTextArea.append("Summary: ".concat(result.getPublicationInfo().getSummary()).concat("\n"));
            jTextArea.append("Link: "+result.getLink().concat("\n"));
            jTextArea.append("Authors:".concat("\n"));
            if (result.getPublicationInfo().getAuthors()!=null){
                for(Author author:result.getPublicationInfo().getAuthors()){
                   CompletableFuture<Void> futureAuthor = this.googleScholarController
                            .fetchDataFromAuthorApi(Constants.BASE_GOOGLE_SCHOLAR_URL,author.getAuthorId());
                    futureAuthor.thenRun(()-> this.showAuthorInfo(this.googleScholarController.getAuthorModel())).join();
                }
            }
            else {
                jTextArea.append("**No authors**".concat("\n"));
            }
        }
        JOptionPane.showMessageDialog(null,jScrollPane);
    }

    public void showAuthorInfo(AuthorModel authorModel){
        jTextArea.append("***********************".concat("\n"));
        jTextArea.append("- Name: "+authorModel.getAuthorInfo().getName().concat("\n"));
        jTextArea.append("- Affiliations: "+authorModel.getAuthorInfo().getAffiliations().concat("\n"));

    }

}
