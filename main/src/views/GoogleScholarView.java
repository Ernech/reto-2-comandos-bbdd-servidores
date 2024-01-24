package views;

import models.Result;

import java.util.List;

public class GoogleScholarView {

    public void showResults(List<Result> results){
        for(Result result:results){
            System.out.println(result.getName());
            System.out.println(result.getUrl());
        }
    }

}
