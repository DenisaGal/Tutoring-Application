package TA.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemServiceTest {
    @Test
    void getPathToFile() {
        assertEquals("C:\\Users\\Deni\\.tutoring_application_db\\.\\TAusers.json", String.valueOf(FileSystemService.getPathToFile("TAusers.json")));
    }

}