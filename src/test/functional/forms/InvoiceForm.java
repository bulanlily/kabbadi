package forms;

import java.util.HashMap;
import java.util.Map;

public class InvoiceForm {

    protected Map<String, String> fields;

    public InvoiceForm() {
        this.fields = new HashMap<String, String>();
    }

    public void fillInvoiceNumberWith(String invoiceNumber) {
        fields.put("invoiceNumber", invoiceNumber);
    }

    public void fillPurchaseOrderNumberWith(String purchaseOrderNumber) {
        fields.put("purchaseOrderNumber", purchaseOrderNumber);
    }

    public void fillLocationWith(String location) {
        fields.put("location", location);
    }

    public Map<String, String> getFields() {
        return fields;
    }
}