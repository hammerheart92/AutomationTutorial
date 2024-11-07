package modelObject;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PracticeFormModel extends BaseModel {

    // Global variables corresponding to the JSON fields
    private String firstNameValue;
    private String lastNameValue;
    private String emailValue;
    private String genderValue;
    private String mobileNumberValue;
    private String dayValue;
    private String monthValue;
    private String yearValue;
    private List<String> subjectValues;
    private List<String> hobbiesValues;
    private String pathFile;
    private String currentAddressValue;
    private String stateInputValue;
    private String cityInputValue;

    public PracticeFormModel(String jsonFilePath) {
        super(jsonFilePath);
    }
}

