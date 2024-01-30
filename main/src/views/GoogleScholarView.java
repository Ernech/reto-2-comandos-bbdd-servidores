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

    GoogleScholarController googleScholarController = new GoogleScholarController(this);
    JTextArea jTextArea = new JTextArea(30,100);
    JScrollPane jScrollPane = new JScrollPane(jTextArea);
    public void showOrganicResults(List<OrganicResult> results){
        if (results == null){
            jTextArea.append("THERE WAS AN ERROR FETCHING THE DATA");
            JOptionPane.showMessageDialog(null,jTextArea);
            return;
        }
        for(OrganicResult result:results){
            jTextArea.append("=========================================================================\n");
            jTextArea.append("Title: ".concat(result.getTitle()).concat("\n"));
            jTextArea.append("Summary: ".concat(result.getPublicationInfo().getSummary()).concat("\n"));
            jTextArea.append("Link: "+result.getLink().concat("\n"));
            jTextArea.append("Authors:".concat("\n"));
            if (result.getPublicationInfo().getAuthors()!=null){
                for(Author author:result.getPublicationInfo().getAuthors()){
                   CompletableFuture<AuthorModel> futureAuthor = this.googleScholarController
                            .fetchDataFromAuthorApi(author.getAuthorId());
                    futureAuthor.thenAccept(authorModel-> this.showAuthorInfo(authorModel)).join();
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
