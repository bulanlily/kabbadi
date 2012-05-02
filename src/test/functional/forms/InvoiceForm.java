package forms;

import java.util.Map;

public class InvoiceForm {

    protected Map<String, Object> fields;

    public InvoiceForm(Map<String, Object> fields) {
        this.fields = fields;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

}