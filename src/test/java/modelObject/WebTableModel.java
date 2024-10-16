package modelObject;

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

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getAgeValue() {
        return ageValue;
    }

    public void setAgeValue(String ageValue) {
        this.ageValue = ageValue;
    }

    public String getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(String salaryValue) {
        this.salaryValue = salaryValue;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public String getEditFirstNameValue() {
        return editFirstNameValue;
    }

    public void setEditFirstNameValue(String editFirstNameValue) {
        this.editFirstNameValue = editFirstNameValue;
    }

    public String getEditLastNameValue() {
        return editLastNameValue;
    }

    public void setEditLastNameValue(String editLastNameValue) {
        this.editLastNameValue = editLastNameValue;
    }

    public String getEditEmailValue() {
        return editEmailValue;
    }

    public void setEditEmailValue(String editEmailValue) {
        this.editEmailValue = editEmailValue;
    }

    public String getEditSalaryValue() {
        return editSalaryValue;
    }

    public void setEditSalaryValue(String editSalaryValue) {
        this.editSalaryValue = editSalaryValue;
    }

    public String getEditDepartmentValue() {
        return editDepartmentValue;
    }

    public void setEditDepartmentValue(String editDepartmentValue) {
        this.editDepartmentValue = editDepartmentValue;
    }
}