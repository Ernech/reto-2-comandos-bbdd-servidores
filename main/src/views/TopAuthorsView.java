package views;

import controllers.TopAuthorsController;
import models.dto.AuthorDto;

import javax.swing.*;
import java.util.List;

public class TopAuthorsView {


    JTextArea jTextArea = new JTextArea(30,50);
    JScrollPane jScrollPane = new JScrollPane(jTextArea);

    public void showAuthors(List<AuthorDto> authors){
        if(authors!=null){
            jTextArea.append("===========TOP 10 AUTHORS FROM UNIVERSIDAD DE MÉXICO==========\n");
            for (AuthorDto author: authors){
                jTextArea.append("*********************************************************************\n");
                jTextArea.append("Author: ".concat(author.getAuthorName().concat("\n")));
                jTextArea.append("Email: ".concat(author.getEmail()).concat("\n"));
                jTextArea.append("Title: ".concat(author.getCarrer()).concat("\n"));
                jTextArea.append("Affiliation: ".concat(author.getAffiliations()).concat("\n"));
                jTextArea.append("CITATIONS: ".concat(author.getCitations().toString().concat("\n")));

            }
            JOptionPane.showMessageDialog(null,jScrollPane);
            return;
        }
        jTextArea.append("THERE WAS AN ERROR RETRIEVING THE AUTHORS");
        JOptionPane.showMessageDialog(null,jTextArea);
    }


}
