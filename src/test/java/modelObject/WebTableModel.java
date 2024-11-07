package modelObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebTableModel extends BaseModel {

    // Global variables corresponding to JSON fields
    private String firstNameValue;
    private String lastNameValue;
    private String emailValue;
    private String ageValue;
    private String salaryValue;
    private String departmentValue;
    private String editFirstNameValue;
    private String editLastNameValue;
    private String editEmailValue;
    private String editSalaryValue;
    private String editDepartmentValue;

    public WebTableModel(String jsonFilePath) {
        super(jsonFilePath);
    }
}