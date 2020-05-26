package TA.controllers;

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

    //UserService users = (UserService) getUsersList();
    

    public void setSubjectPressed(ActionEvent actionEvent){
        System.out.println((String) subject.getValue());
        //users.addSubject(user_name, (String) subject.getValue());
    }

    /*public ObservableList<User> getUsersList() {
        ObservableList<User> usersList = FXCollections.observableArrayList();

        usersList.addAll(UserService.getUsers());

        return usersList;
    }*/
}
