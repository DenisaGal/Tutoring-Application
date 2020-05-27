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
}