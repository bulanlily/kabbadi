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


    public void fillDateOfInvoice(String dateOfInvoice) {
        fields.put("dateOfInvoice", dateOfInvoice);
    }


    public void fillSupplierNameAndAddress(String supplierNameAndAddress) {
        fields.put("supplierNameAndAddress", supplierNameAndAddress);
    }

    public void fillOpeningPurchaseValueAsOnApril01(String openingPurchaseValueAsOnApril01) {
        fields.put("openingPurchaseValueAsOnApril01", openingPurchaseValueAsOnApril01);
    }


    public void fillAdditionsDuringTheYear(String additionsDuringTheYear) {
        fields.put("additionsDuringTheYear", additionsDuringTheYear);
    }

    public void fillDeletionsDuringTheYear(String deletionsDuringTheYear) {
        fields.put("deletionsDuringTheYear", deletionsDuringTheYear);
    }

    public void fillDateOfCommissioning(String dateOfCommissioning) {
        fields.put("dateOfCommissioning", dateOfCommissioning);
    }

    public void fillCostCentre(String costCentre) {
        fields.put("costCentre", costCentre);
    }

    public void fillQuantity(String quantity) {
        fields.put("quantity", quantity);
    }


    public void fillIdentificationNumber(String identificationNumber) {
        fields.put("identificationNumber", identificationNumber);
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void fillBondNumber(String bondNumber) {
        fields.put("bondNumber", bondNumber);
    }
}