package TA.controllers;

import TA.exceptions.UsernameAlreadyExistsException;
import TA.model.User;
import TA.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class StartController {
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
    private AnchorPane Menu;

    @FXML
    public void initialize() {
        role.getItems().addAll("Learner", "Tutor");
    }

    UserService users = new UserService();
    Woopsie woops;
    public Button LogInButton;
    public Button RegisterButton;

    public void Register() {
        try {
            users.addUser(usernameField.getText(), email_addressField.getText(), phone_numberField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("The account was created successfully! ^_^");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    public void Logger() throws IOException {
        User user = new User(usernameField.getText(), UserService.encodePassword(usernameField.getText(), passwordField.getText()), (String) role.getValue());
        if(!users.containsUser(user)) {
            woops.display("Log in failed", "Wrong credentials :(");
            usernameField.clear();
            passwordField.clear();
        }
        else {
            if((role.getValue()).equals("Learner")){
                Menu = FXMLLoader.load(getClass().getClassLoader().getResource("LearnerMenu.fxml"));
            }
            if((role.getValue()).equals("Tutor")){
                Menu = FXMLLoader.load(getClass().getClassLoader().getResource("LearnerMenu.fxml"));
            }
            Stage startStage = (Stage) LogInButton.getScene().getWindow();
            startStage.close();

            Stage menuStage = new Stage();
            menuStage.setScene(new Scene(Menu, 200, 250));
            menuStage.setTitle("Learner Menu");
            menuStage.show();
        }
    }

    public void startRegister(ActionEvent actionEvent) {
        Register();
        Stage registerStage = (Stage) RegisterButton.getScene().getWindow();
        registerStage.close();
        woops.display("Register was succesfull", "Account was created successfully!\n Now you can log in \n and start learning ^_^");
    }

    public void startLogger(ActionEvent actionEvent) {
        try {
            Logger();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerButtonOnLogger(ActionEvent actionEvent) throws Exception{
        UserService.loadUsersFromFile();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage resisterStage = new Stage();
        resisterStage.setTitle("Welcome!");
        resisterStage.setScene(new Scene(root, 350, 275));
        resisterStage.show();
    }
}
