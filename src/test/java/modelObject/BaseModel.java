package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseModel {

    public BaseModel(String jsonFilePath){
        populateObject(jsonFilePath);
    }

    @SneakyThrows(IOException.class)
    public void populateObject(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readerForUpdating(this)
                .readValue(Files.readAllBytes(Paths.get(jsonFilePath)));
    }
}
