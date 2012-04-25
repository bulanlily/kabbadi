package forms;

public class FinanceInvoiceForm extends InvoiceForm {

    public void fillTypeWith(String type) {
        fields.put("type", type);
    }

}
