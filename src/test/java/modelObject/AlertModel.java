package modelObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertModel extends BaseModel {
    private String alertText;

    public AlertModel(String jsonFilePath) {
        super(jsonFilePath);
    }

}
