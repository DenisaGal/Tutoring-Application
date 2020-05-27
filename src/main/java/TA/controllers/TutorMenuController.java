package TA.controllers;

import TA.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;


public class TutorMenuController {
    @FXML
    private CheckBox art;
    @FXML
    private CheckBox biology;
    @FXML
    private CheckBox chemestry;
    @FXML
    private CheckBox english;
    @FXML
    private CheckBox history;
    @FXML
    private CheckBox math;
    @FXML
    private CheckBox physics;
    @FXML
    private CheckBox programming;

    public String username;
    UserService users = new UserService();
    ArrayList<String> subjects = new ArrayList<String>();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsersList(UserService users){
        this.users = users;
    }

    public void setSubjectsPressed(ActionEvent actionEvent){
        subjects.clear();
        if(art.isSelected()) {
            subjects.add("Art");
        }
        if(biology.isSelected()) {
            subjects.add("Biology");
        }
        if(chemestry.isSelected()) {
            subjects.add("Chemestry");
        }
        if(english.isSelected()) {
            subjects.add("English");
        }
        if(history.isSelected()) {
            subjects.add("History");
        }
        if(math.isSelected()) {
            subjects.add("Math");
        }
        if(physics.isSelected()) {
            subjects.add("Physics");
        }
        if(programming.isSelected()) {
            subjects.add("Programming");
        }
        users.addSubjects(username, subjects);
    }

    public void qualificationButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Proof Of Qualification");
        alert.setHeaderText(null);
        alert.setContentText("To be implemented soon");

        alert.showAndWait();
    }

    public void seeReviewsButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("See Reviews");
        alert.setHeaderText(null);
        alert.setContentText("To be implemented soon");

        alert.showAndWait();
    }

    public void chatButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chat");
        alert.setHeaderText(null);
        alert.setContentText("To be implemented soon");

        alert.showAndWait();
    }
}
