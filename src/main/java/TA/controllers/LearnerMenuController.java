package TA.controllers;

import TA.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

public class LearnerMenuController {
    @FXML
    private ChoiceBox subject;

    @FXML
    public void initialize(){
        subject.getItems().addAll("Art", "Biology", "Chemestry", "English", "History", "Math", "Physics", "Programming");
    }

    public String username;
    UserService users = new UserService();
    Woopsie woops;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsersList(UserService users) {
        this.users = users;
    }

    public void setSubjectPressed(ActionEvent actionEvent) {
        users.addSubject(username, (String) subject.getValue());
    }

    public void setTutorsNames(ActionEvent actionEvent) {
        users.addTutorsNames((String) subject.getValue());
    }


    public void chatButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chat");
        alert.setHeaderText(null);
        alert.setContentText("To be implemented soon");

        alert.showAndWait();
    }

    public void feedbackButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("See Feedback");
        alert.setHeaderText(null);
        alert.setContentText("To be implemented soon");

        alert.showAndWait();
    }
}
