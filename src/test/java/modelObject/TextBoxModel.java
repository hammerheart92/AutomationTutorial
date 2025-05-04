package modelObject;

import lombok.Getter;
import lombok.Setter;
import pages.BasePage;

@Getter
@Setter
public class TextBoxModel extends BaseModel {

    // Global variables corresponding to JSON fields
    private String fullNameValue;
    private String emailValue;
    private String currentAddressValue;
    private String permanentAddressValue;

    public TextBoxModel(String jsonFilePath) {
        super(jsonFilePath);
    }
}
