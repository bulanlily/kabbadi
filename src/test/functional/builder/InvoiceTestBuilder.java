package builder;

import kabbadi.domain.Invoice;
import kabbadi.domain.Money;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InvoiceTestBuilder {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    private String invoiceNumber = "TestInvoiceNo";
    private String numberAndDate = "123123";
    private String descriptionOfGoods = "bill";
    private Money foreignValue = new Money("USD", new BigDecimal(123));
    private double amountSTPIApproval = 123123;
    private Money CIFValueInINR = new Money("INR", new BigDecimal(123123));
    private String bondNumber = "123123";
    private String bondDate = "1/1/2012";
    private String dateOfArrival = "1/1/2012";
    private String billOfEntryNumber = "123123";
    private String billOfEntryDate = "1/1/2012";
    private double assessableValueInINR = 123123;
    private double dutyExempt = 123123;
    private double twentyFivePercentDF = 123123;
    private double CGApprovedInINR = 123123;
    private double dutyForegone = 123123;
    private double runningBalance = 123123;
    private double outrightPurchase = 123123;
    private String loanBasis = "123123";
    private double freeOfCharge = 123123;
    private String status = "bill";
    private String remarks = "bill";
    private String purchaseOrderNumber = "123123";
    private String location = "bill";
    private String dateOfInvoice = "01/01/2012";
    private String supplierNameAndAddress = "bill";
    private double openingPurchaseValueAsOnApril01 = 123445;
    private double additionsDuringTheYear = 12222;
    private double deletionsDuringTheYear = 123445;
    private String dateOfCommissioning = "01/01/2012";
    private Integer quantity = 25;
    private String costCentre = "skjj";
    private String identificationNumber = "1234";

    public InvoiceTestBuilder withInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    public InvoiceTestBuilder withSTPIApprovalNumberAndDate(String numberAndDate) {
        this.numberAndDate = numberAndDate;
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

    public InvoiceTestBuilder withCGApprovedInINR(double CGApprovedInINR) {
        this.CGApprovedInINR = CGApprovedInINR;
        return this;
    }

    public InvoiceTestBuilder withDutyForegone(double dutyForegone) {
        this.dutyForegone = dutyForegone;
        return this;
    }

    public InvoiceTestBuilder withRunningBalance(double runningBalance) {
        this.runningBalance = runningBalance;
        return this;
    }

    public InvoiceTestBuilder withOutrightPurchase(double outrightPurchase) {
        this.outrightPurchase = outrightPurchase;
        return this;
    }

    public InvoiceTestBuilder withLoanBasis(String loanBasis) {
        this.loanBasis = loanBasis;
        return this;
    }

    public InvoiceTestBuilder withFreeOfCharge(double freeOfCharge) {
        this.freeOfCharge = freeOfCharge;
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

    public InvoiceTestBuilder withLocation(String location) {
        this.location = location;
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

    public InvoiceTestBuilder withQuantity(Integer quantity) {
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

    public Invoice build() {
        Invoice invoice = new Invoice();
        try {
            invoice.setLocation(location);
            invoice.setInvoiceNumber(invoiceNumber);
            invoice.setPurchaseOrderNumber(purchaseOrderNumber);
            invoice.setRemarks(remarks);
            invoice.setStatus(status);
            invoice.setDutyForgone(new BigDecimal(dutyForegone));
            invoice.setRunningBalance(new BigDecimal(runningBalance));
            invoice.setOutrightPurchase(new BigDecimal(outrightPurchase));
            invoice.setLoanBasis(loanBasis);
            invoice.setFreeOfCharge(new BigDecimal(freeOfCharge));
            invoice.setCgApprovedInINR(new BigDecimal(CGApprovedInINR));
            invoice.setTwentyFivePercentDF(new BigDecimal(twentyFivePercentDF));
            invoice.setDutyExempt(new BigDecimal(dutyExempt));
            invoice.setAssessableValueInINR(new BigDecimal(assessableValueInINR));
            invoice.setBillOfEntryDate(new SimpleDateFormat(DATE_FORMAT).parse(billOfEntryDate));
            invoice.setBillOfEntryNumber(billOfEntryNumber);
            invoice.setBondDate(new SimpleDateFormat(DATE_FORMAT).parse(bondDate));
            invoice.setDateOfArrival(new SimpleDateFormat(DATE_FORMAT).parse(dateOfArrival));
            invoice.setBondNumber(bondNumber);
            invoice.setCIFValueInINR(CIFValueInINR);
            invoice.setAmountSTPIApproval(new BigDecimal(amountSTPIApproval));
            invoice.setForeignValue(foreignValue);
            invoice.setDescriptionOfGoods(descriptionOfGoods);
            invoice.setSTPIApprovalNumberAndDate(numberAndDate);
            invoice.setDateOfInvoice(new SimpleDateFormat(DATE_FORMAT).parse(dateOfInvoice));
            invoice.setSupplierNameAndAddress(supplierNameAndAddress);
            invoice.setOpeningPurchaseValueAsOnApril01(new BigDecimal(openingPurchaseValueAsOnApril01));
            invoice.setAdditionsDuringTheYear(new BigDecimal(additionsDuringTheYear));
            invoice.setDeletionsDuringTheYear(new BigDecimal(deletionsDuringTheYear));
            invoice.setDateOfCommissioning(new SimpleDateFormat(DATE_FORMAT).parse(dateOfCommissioning));
            invoice.setCostCentre(costCentre);
            invoice.setQuantity(quantity);
            invoice.setIdentificationNumber(identificationNumber);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return invoice;
    }
}
