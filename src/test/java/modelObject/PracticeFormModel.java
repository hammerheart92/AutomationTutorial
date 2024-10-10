package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PracticeFormModel {

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

    public PracticeFormModel(String jsonFilePath){
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

    // Getters and Setters for each variable

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

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getMobileNumberValue() {
        return mobileNumberValue;
    }

    public void setMobileNumberValue(String mobileNumberValue) {
        this.mobileNumberValue = mobileNumberValue;
    }

    public String getDayValue() {
        return dayValue;
    }

    public void setDayValue(String dayValue) {
        this.dayValue = dayValue;
    }

    public String getMonthValue() {
        return monthValue;
    }

    public void setMonthValue(String monthValue) {
        this.monthValue = monthValue;
    }

    public String getYearValue() {
        return yearValue;
    }

    public void setYearValue(String yearValue) {
        this.yearValue = yearValue;
    }

    public List<String> getSubjectValues() {
        return subjectValues;
    }

    public void setSubjectValues(List<String> subjectValues) {
        this.subjectValues = subjectValues;
    }

    public List<String> getHobbiesValues() {
        return hobbiesValues;
    }

    public void setHobbiesValues(List<String> hobbiesValues) {
        this.hobbiesValues = hobbiesValues;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getCurrentAddressValue() {
        return currentAddressValue;
    }

    public void setCurrentAddressValue(String currentAddressValue) {
        this.currentAddressValue = currentAddressValue;
    }

    public String getStateInputValue() {
        return stateInputValue;
    }

    public void setStateInputValue(String stateInputValue) {
        this.stateInputValue = stateInputValue;
    }

    public String getCityInputValue() {
        return cityInputValue;
    }

    public void setCityInputValue(String cityInputValue) {
        this.cityInputValue = cityInputValue;
    }
}

