package forms;

public class AdminInvoiceForm extends InvoiceForm {

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

    public void fillCIFValueInINR(String CIFValue) {
        fields.put("CIFValueInINR", CIFValue);
    }
}
