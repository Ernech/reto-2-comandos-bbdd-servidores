package views;

import controllers.TopAuthorsController;
import models.dto.AuthorDto;

import javax.swing.*;
import java.util.List;

public class TopAuthorsView {

    TopAuthorsController topAuthorsController = new TopAuthorsController(this);

    JTextArea jTextArea = new JTextArea(30,100);
    JScrollPane jScrollPane = new JScrollPane(jTextArea);

    public void showAuthors(List<AuthorDto> authors){
        if(authors!=null){
            jTextArea.append("===============TOP 10 AUTHORS FROM UNIVERSIDAD DE MÉXICO===============\n");
            jTextArea.append("-----------------------------------------------------------------------\n");
            jTextArea.append("Name\t\tEmail\t\tProfession\t\tAffiliation\t\tNumber of citations\n");
            for (AuthorDto author: authors){
                jTextArea.append(author.getAuthorName().concat("\t\t").concat(author.getEmail()).concat("\t\t")
                        .concat(author.getCarrer()).concat("\t\t").concat(author.getAffiliations()).concat("\t\t")
                        .concat(author.getCitations().toString()).concat("\n"));

            }
            JOptionPane.showMessageDialog(null,jScrollPane);
            return;
        }
        jTextArea.append("THERE WAS AN ERROR RETRIEVING THE AUTHORS");
        JOptionPane.showMessageDialog(null,jTextArea);
    }


}
