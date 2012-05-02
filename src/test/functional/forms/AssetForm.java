package forms;

import java.util.Map;

public class AssetForm {

    protected Map<String, Object> fields;

    public AssetForm(Map<String, Object> fields) {
        this.fields = fields;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

}
