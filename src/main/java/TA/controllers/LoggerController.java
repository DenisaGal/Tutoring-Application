package TA.controllers;

import TA.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoggerController {
    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Learner", "Tutor");
    }

    @FXML
    public void handleLoginAction() {
            UserService.logUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            loginMessage.setText("Welcome! ^_^");
    }
}
