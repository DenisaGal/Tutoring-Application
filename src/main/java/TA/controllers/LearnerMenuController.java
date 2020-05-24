package TA.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

public class LearnerMenuController {
    @FXML
    private ChoiceBox subject;

    @FXML
    public void initialize(){
        subject.getItems().addAll("Art", "Biology", "Chemestry", "English", "History", "Math", "Physics", "Programming");
    }
}
