package forms;

import java.util.HashMap;
import java.util.Map;

public class
        InvoiceForm {

    private Map<String, String> fields;

    public InvoiceForm() {
        this.fields = new HashMap<String, String>();
    }

    public void fillInvoiceNumberWith(String invoiceNumber) {
        fields.put("invoiceNumber", invoiceNumber);
    }

    public void fillPurchaseOrderNumberWith(String purchaseOrderNumber) {
        fields.put("purchaseOrderNumber", purchaseOrderNumber);
    }

    public void fillStpiApprovalNumberAndDateWith(String stpiNumberAndDate) {
        fields.put("STPIApprovalNumberAndDate", stpiNumberAndDate);
    }

    public void fillBondNumberWith(String bondNumber) {
        fields.put("bondNumber", bondNumber);
    }

    public void fillBondDateWith(String bondDate) {
        fields.put("bondDate", bondDate);
    }


    public void fillAmountAsPerStpiApprovalWith(String stpiApproval) {
        fields.put("amountSTPIApproval", stpiApproval);
    }

    public void fillLocationWith(String location) {
        fields.put("location", location);
    }

    public Map<String, String> getFields() {
        return fields;
    }
}