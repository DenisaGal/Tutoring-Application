package TA.controllers;

import TA.exceptions.UsernameAlreadyExistsException;
import TA.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import TA.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Controller {
    @FXML
    private Text registrationMessage;
    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField email_addressField;
    @FXML
    private TextField phone_numberField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Learner", "Tutor");
    }

    public void Register() {
        try {
            UserService.addUser(usernameField.getText(), email_addressField.getText(), phone_numberField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("The account was created successfully! ^_^");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    public void Logger() {
        UserService.logUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
        loginMessage.setText("Welcome! ^_^");
    }

    public void startRegister(ActionEvent actionEvent) {
        Register();
    }

    public void startLogger(ActionEvent actionEvent) {
        Logger();
    }

    public void registerButtonOnLogger(ActionEvent actionEvent) throws Exception{
        UserService.loadUsersFromFile();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage resisterStage = new Stage();
        resisterStage.setTitle("Welcome!");
        resisterStage.setScene(new Scene(root, 350, 275, Color.CYAN));
        resisterStage.show();
    }
}
