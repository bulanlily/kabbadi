package builder;

import kabbadi.domain.ImportType;
import forms.InvoiceForm;
import kabbadi.domain.Location;
import kabbadi.domain.Money;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InvoiceTestBuilder {
    private String invoiceNumber = "TestInvoiceNo";
    private String descriptionOfGoods = "Laptop and stuff";
    private Money foreignValue = new Money("USD", new BigDecimal(1000));
    private double amountSTPIApproval = 500.00;
    private Money CIFValueInINR = new Money("INR", new BigDecimal(501));
    private String bondNumber = "12/23-45";
    private String bondDate = "01/01/2012";
    private String dateOfArrival = "02/01/2012";
    private String billOfEntryNumber = "Bill#1234";
    private String billOfEntryDate = "03/01/2012";
    private double assessableValueInINR = 502.00;
    private double dutyExempt = 503.00;
    private double twentyFivePercentDF = 504.00;
    private double cgApprovedInINR = 505.00;
    private double dutyForegone = 506.00;
    private String importType = ImportType.LOAN_BASIS.getDescription();
    private String status = "status of order";
    private String remarks = "important remarks";
    private String purchaseOrderNumber = "PO#1234";
    private String location = Location.PUNE.toString();
    private String dateOfInvoice = "04/01/2012";
    private String supplierNameAndAddress = "My supplier";
    private double openingPurchaseValueAsOnApril01 = 508.00;
    private double additionsDuringTheYear = 509.00;
    private double deletionsDuringTheYear = 510.00;
    private String dateOfCommissioning = "05/01/2012";
    private String quantity = "25";
    private String costCentre = "CostCenter";
    private String identificationNumber = "ID#1234";
    private String STPIApprovalNumberAndDate = "STPI#1234";

    public InvoiceTestBuilder withInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    public InvoiceTestBuilder withSTPIApprovalNumberAndDate(String STPI) {
        this.STPIApprovalNumberAndDate = STPI;
        return this;
    }

    public InvoiceTestBuilder withDescriptionOfGoods(String descriptionOfGoods) {
        this.descriptionOfGoods = descriptionOfGoods;
        return this;
    }

    public InvoiceTestBuilder withForeignValue(Money foreignValue) {
        this.foreignValue = foreignValue;
        return this;
    }

    public InvoiceTestBuilder withAmountSTPIApproval(double amountSTPIApproval) {
        this.amountSTPIApproval = amountSTPIApproval;
        return this;
    }

    public InvoiceTestBuilder withCIFValueInINR(Money CIFValueInINR) {
        this.CIFValueInINR = CIFValueInINR;
        return this;
    }

    public InvoiceTestBuilder withBondNumber(String bondNumber) {
        this.bondNumber = bondNumber;
        return this;
    }

    public InvoiceTestBuilder withBondDate(String bondDate) {
        this.bondDate = bondDate;
        return this;
    }

    public InvoiceTestBuilder withDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
        return this;
    }

    public InvoiceTestBuilder withBillOfEntryNumber(String billOfEntryNumber) {
        this.billOfEntryNumber = billOfEntryNumber;
        return this;
    }

    public InvoiceTestBuilder withBillOfEntryDate(String billOfEntryDate) {
        this.billOfEntryDate = billOfEntryDate;
        return this;
    }

    public InvoiceTestBuilder withAssessableValueInINR(double assessableValueInINR) {
        this.assessableValueInINR = assessableValueInINR;
        return this;
    }

    public InvoiceTestBuilder withDutyExempt(double dutyExempt) {
        this.dutyExempt = dutyExempt;
        return this;
    }

    public InvoiceTestBuilder withTwentyFivePercentDF(double twentyFivePercentDF) {
        this.twentyFivePercentDF = twentyFivePercentDF;
        return this;
    }

    public InvoiceTestBuilder withCGApprovedInINR(double cgApprovedInINR) {
        this.cgApprovedInINR = cgApprovedInINR;
        return this;
    }

    public InvoiceTestBuilder withDutyForegone(double dutyForegone) {
        this.dutyForegone = dutyForegone;
        return this;
    }

    public InvoiceTestBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public InvoiceTestBuilder withRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public InvoiceTestBuilder withPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        return this;
    }

    public InvoiceTestBuilder withLocation(Location location) {
        this.location = location.toString();
        return this;
    }

    public InvoiceTestBuilder withDateOfInvoice(String dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
        return this;
    }

    public InvoiceTestBuilder withSupplierNameAndAddress(String supplierNameAndAddress) {
        this.supplierNameAndAddress = supplierNameAndAddress;
        return this;
    }

    public InvoiceTestBuilder withOpeningPurchaseValueAsOnApril01(double openingPurchaseValueAsOnApril01) {
        this.openingPurchaseValueAsOnApril01 = openingPurchaseValueAsOnApril01;
        return  this;
    }

    public InvoiceTestBuilder withAdditionsDuringTheYear(double additionsDuringTheYear) {
        this.additionsDuringTheYear = additionsDuringTheYear;
        return  this;
    }

    public InvoiceTestBuilder withDeletionsDuringTheYear(double deletionsDuringTheYear) {
        this.deletionsDuringTheYear = deletionsDuringTheYear;
        return  this;
    }

    public InvoiceTestBuilder withDateOfCommissioning(String dateOfCommissioning) {
        this.dateOfCommissioning = dateOfCommissioning;
        return  this;
    }

    public InvoiceTestBuilder withQuantity(String quantity) {
        this.quantity = quantity;
        return  this;
    }

    public InvoiceTestBuilder withCostCentre(String costCentre) {
        this.costCentre = costCentre;
        return  this;
    }

    public InvoiceTestBuilder withIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return  this;
    }

    public InvoiceForm buildFinance() {
        Map<String, Object> fields = new HashMap<String, Object>();
        populateCommonFields(fields);
        populateFinanceFields(fields);
        return new InvoiceForm(fields);
    }

    public InvoiceForm buildAdmin() {
        Map<String, Object> fields = new HashMap<String, Object>();
        populateCommonFields(fields);
        populateAdminFields(fields);
        return new InvoiceForm(fields);
    }

    private void populateFinanceFields(Map<String, Object> fields) {
        fields.put("dateOfInvoice", dateOfInvoice);
        fields.put("dateOfCommissioning", dateOfCommissioning);
        fields.put("supplierNameAndAddress", supplierNameAndAddress);
        fields.put("openingPurchaseValueAsOnApril01", openingPurchaseValueAsOnApril01);
        fields.put("additionsDuringTheYear", additionsDuringTheYear);
        fields.put("deletionsDuringTheYear", deletionsDuringTheYear);
        fields.put("costCentre", costCentre);
        fields.put("quantity", quantity);
        fields.put("identificationNumber", identificationNumber);
    }

    private void populateAdminFields(Map<String, Object> fields) {
        fields.put("STPIApprovalNumberAndDate", STPIApprovalNumberAndDate);
        fields.put("dateOfArrival", dateOfArrival);
        fields.put("bondNumber", bondNumber);
        fields.put("bondDate", bondDate);
        fields.put("billOfEntryDate", billOfEntryDate);
        fields.put("billOfEntryNumber", billOfEntryNumber);
        fields.put("CIFValueInINR", CIFValueInINR.displayAmount());
        fields.put("amountSTPIApproval", amountSTPIApproval);
        fields.put("cgApprovedInINR", cgApprovedInINR);
        fields.put("twentyFivePercentDF", twentyFivePercentDF);
        fields.put("dutyExempt", dutyExempt);
        fields.put("dutyForgone", dutyForegone);
        fields.put("importType", importType);
        fields.put("remarks", remarks);
        fields.put("status", status);
        fields.put("foreignValue.amount", foreignValue.displayAmount());
        fields.put("assessableValueInINR", assessableValueInINR);
    }

    private void populateCommonFields(Map<String, Object> fields) {
        fields.put("invoiceNumber", invoiceNumber);
        fields.put("purchaseOrderNumber", purchaseOrderNumber);
        fields.put("location", location);
        fields.put("descriptionOfGoods", descriptionOfGoods);
    }
}
