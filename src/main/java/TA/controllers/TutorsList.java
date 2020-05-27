package TA.controllers;

import javafx.scene.control.Button;

public class TutorsList {

    private String usernameInTable;
    private String emailInTable;
    private String phoneNumber;
    private Button reviewButton;


    public TutorsList(String usernameInTable, String emailInTable, String phoneNumber, Button reviewButton) {
        this.usernameInTable = usernameInTable;
        this.emailInTable = emailInTable;
        this.phoneNumber = phoneNumber;
        this.reviewButton = new Button ("Send review");
    }

    public String getUsernameInTable() {
        return usernameInTable;
    }

    public void setUsernameInTable(String usernameInTable) {
        this.usernameInTable = usernameInTable;
    }

    public String getEmailInTable() {
        return emailInTable;
    }

    public void setEmailInTable(String emailInTable) {
        this.emailInTable = usernameInTable;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Button getReviewButton() {
        return reviewButton;
    }

    public void setReviewButton(Button reviewButton) {
        this.reviewButton = reviewButton;
    }

}
