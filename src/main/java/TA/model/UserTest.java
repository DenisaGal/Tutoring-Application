package TA.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void checkUsername() {
        User user = new User("Denisa", "PlsWork", "Learner");
        assertTrue(user.checkUsername(user.getUsername()));
        assertFalse(user.checkUsername("Alin"));
    }

    @Test
    void checkPassword() {
        User user = new User("Denisa", "PlsWork", "Learner");
        assertTrue(user.checkPassword(user.getPassword()));
        assertFalse(user.checkPassword("Pls"));
    }


    @Test
    void checkEmailAddress() {
        User user = new User("Denisa","deni@yahoo.com", "0123456789", "PlsWork", "Learner");
        assertTrue(user.checkEmailAddress(user.getEmail_address()));
        assertFalse(user.checkEmailAddress("whatever"));
    }

    @Test
    void checkPhoneNumber() {
        User user = new User("Denisa","deni@yahoo.com", "0123456789", "PlsWork", "Learner");
        assertTrue(user.checkPhoneNumber(user.getPhone_number()));
        assertFalse(user.checkPhoneNumber("123"));
    }
}