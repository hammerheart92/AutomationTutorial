package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AlertModel {
    private String alertText;

    public AlertModel(String jsonFilePath){
        populateObject(jsonFilePath);
    }

    public void populateObject(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this)
                    .readValue(Files.readAllBytes(Paths.get(jsonFilePath)));

        } catch (IOException e) {
            e.printStackTrace();  // Handle exceptions as needed
        }
    }

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }
}
