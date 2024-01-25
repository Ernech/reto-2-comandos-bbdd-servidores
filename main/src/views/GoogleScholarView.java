package views;

import models.Result;
import models.googlescholar.OrganicResult;

import java.util.List;

public class GoogleScholarView {

    public void showOrganicResults(List<OrganicResult> results){
        for(OrganicResult result:results){
            System.out.println();
        }
    }

}
