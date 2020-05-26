package TA.controllers;

import TA.model.User;
import TA.services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class LearnerMenuController {
    @FXML
    private ChoiceBox subject;

    @FXML
    public void initialize(){
        subject.getItems().addAll("Art", "Biology", "Chemestry", "English", "History", "Math", "Physics", "Programming");
    }

    UserService users = (UserService) getUsersList();
    public String username;

    public void setUsername(String username){
        this.username = username;
    }

    public void setSubjectPressed(ActionEvent actionEvent){
        System.out.println((String) subject.getValue());
        users.addSubject(username, (String) subject.getValue());
    }

    public ObservableList<User> getUsersList() {
        ObservableList<User> usersList = FXCollections.observableArrayList();

        usersList.addAll(UserService.getUsers());

        return usersList;
    }
}
