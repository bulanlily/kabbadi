package forms;

import org.openqa.selenium.WebDriver;

import java.util.Date;
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


    public void fillDateOfInvoice(String dateOfInvoice){
        fields.put("dateOfInvoice", dateOfInvoice);
    }

    public void fillSupplierNameAndAddress(String supplierNameAndAddress){
        fields.put("supplierNameAndAddress", supplierNameAndAddress);
    }


    public void fillOpeningPurchaseValueAsOnApril01(String openingPurchaseValueAsOnApril01){
        fields.put("openingPurchaseValueAsOnApril01", openingPurchaseValueAsOnApril01);
    }

    public void fillAdditionsDuringTheYear(String additionsDuringTheYear){
        fields.put("additionsDuringTheYear", additionsDuringTheYear);
    }

    public void fillDeletionsDuringTheYear(String deletionsDuringTheYear){
        fields.put("deletionsDuringTheYear", deletionsDuringTheYear);
    }

    public void fillDateOfCommissioning(String dateOfCommissioning){
        fields.put("dateOfCommissioning", dateOfCommissioning);
    }

    public void fillGroupOfAssets(String groupOfAssets){
        fields.put("groupOfAssets", groupOfAssets);
    }
    public void fillCostCentre(String costCentre){
        fields.put("costCentre", costCentre);
    }

}