package TA.controllers;

public class TutorsList {

    private String usernameInTable;
    private String phoneNumber;


    public TutorsList(String usernameInTable,String phoneNumber) {
        this.usernameInTable = usernameInTable;
        this.phoneNumber = phoneNumber;
    }

    public String getUsernameInTable() {
        return usernameInTable;
    }

    public void setUsernameInTable(String usernameInTable) {
        this.usernameInTable = usernameInTable;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
