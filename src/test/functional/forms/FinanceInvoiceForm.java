package forms;

public class FinanceInvoiceForm extends InvoiceForm {

    public void fillQuantityWith(String quantity) {
        fields.put("quantity", quantity);
    }

}
