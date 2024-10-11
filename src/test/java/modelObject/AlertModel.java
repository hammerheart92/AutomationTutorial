package modelObject;

public class AlertModel extends BaseModel {
    private String alertText;

    public AlertModel(String jsonFilePath) {
        super(jsonFilePath);
    }

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }
}
