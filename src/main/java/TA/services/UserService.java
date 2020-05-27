package TA.services;

import TA.controllers.TutorsList;
import TA.exceptions.CouldNotWriteUsersException;
import TA.exceptions.UsernameAlreadyExistsException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import TA.model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService {

    private static List<User> users;
    //private static final Path USERS_PATH = FileSystemService.getPathToFile("TAusers.json");
    private static final Path USERS_PATH = FileSystemService.getPathToFile("users.json");

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            //FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("TAusers.json"), USERS_PATH.toFile());
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    public static void addUser(String username, String email_address, String phone_number, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        users.add(new User(username, email_address, phone_number, encodePassword(username, password), role));
        persistUsers();
    }
    public static void addSubject(String username, String subject){ //for learner (that can only pick one subject at a time)
        for(User user : users){
            if(Objects.equals(username, user.getUsername())){
                user.setSubject(subject);
                persistUsers();
            }
        }
    }

    public static void addSubjects(String username, ArrayList<String> subjects){ //for tutor (that can pick one or more subjects at a time)
        for(User user : users){
            if(Objects.equals(username, user.getUsername())){
                user.setSubjects(subjects);
                persistUsers();
            }
        }
    }

    public static void addTutorsNames(String subject)
    {

        TableColumn<TutorsList, String> nameColumn = new TableColumn<>("Username");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("usernameInTable"));

        TableColumn<TutorsList, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setMinWidth(100);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        ObservableList<TutorsList> listTutors = FXCollections.observableArrayList();

        for(User user : users)
            if(Objects.equals(user.getRole(), "Tutor"))
                for(String teaching: user.getSubjects())
                    if(Objects.equals(subject, teaching))
                    {
                        listTutors.add(new TutorsList(user.getUsername(), user.getPhone_number()));
                    }

        TableView<TutorsList> table = new TableView<>();
        table.setItems(listTutors);

        table.getColumns().addAll(nameColumn, phoneNumberColumn);
        Stage tableStage = new Stage();
        tableStage.setScene(new Scene(table, 250, 300));
        tableStage.show();

    }

    public boolean containsUser(User user)
    {
        return users.contains(user);
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

    public static List<User> getUsers() {return users;}

    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}
