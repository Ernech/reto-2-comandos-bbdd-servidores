package views;

import models.googlescholar.Author;
import models.googlescholar.OrganicResult;

import java.util.List;

public class GoogleScholarView {

    public void showOrganicResults(List<OrganicResult> results){
        for(OrganicResult result:results){
            System.out.println("==================================");
            System.out.println("Title: ".concat(result.getTitle()));
            System.out.println("Summary: ".concat(result.getPublicationInfo().getSummary()));
            System.out.println("Link: "+result.getLink());
            System.out.println("Authors:");
            if (result.getPublicationInfo().getAuthors()!=null){
                for(Author author:result.getPublicationInfo().getAuthors()){
                    System.out.println(" -".concat(author.getName()));
                }
            }
            else {
                System.out.println("**No authors**");
            }
        }
    }

}
