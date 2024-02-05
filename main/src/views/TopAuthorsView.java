package views;

import controllers.TopAuthorsController;
import models.dto.AuthorDto;

import javax.swing.*;
import java.util.List;

public class TopAuthorsView {

    TopAuthorsController topAuthorsController = new TopAuthorsController(this);

    JTextArea jTextArea = new JTextArea(30,150);
    JScrollPane jScrollPane = new JScrollPane(jTextArea);

    public void showAuthors(List<AuthorDto> authors){
        jTextArea.append("===============TOP 10 AUTHORS FROM UNIVERSIDAD DE MÉXICO===============");
        jTextArea.append("-----------------------------------------------------------------------");
        jTextArea.append("Name\tEmail\tProfession\tAffiliation\tNumber of citations\n");
        for (AuthorDto author: authors){
            jTextArea.append(author.getAuthorName().concat("\t").concat(author.getEmail()).concat("\t")
            .concat(author.getCarrer()).concat("\t").concat(author.getAffiliations()).concat(author.getCitations().toString()).concat("\n"));

        }
        JOptionPane.showMessageDialog(null,jScrollPane);
    }


}
