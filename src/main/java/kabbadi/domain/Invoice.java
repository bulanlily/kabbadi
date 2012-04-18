package kabbadi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Invoice {

    public static final String INVOICE_NUMBER_PROPERTY = "invoiceNumber";

    private String invoiceNumber;

    private String STPIApprovalNumberAndDate;
    private String descriptionOfGoods;
    private String currency;
    private BigDecimal foreignCurrency;
    private BigDecimal amountSTPIApproval;
    private BigDecimal CIFValueInINR;
    private String bondNumber;

    private Date bondDate;
    private String billOfEntryNumber;
    private Date billOfEntryDate;
    private BigDecimal assessableValueInINR;
    private BigDecimal dutyExempt;
    private BigDecimal twentyFivePercentDF;
    private BigDecimal CGApprovedInINR;
    private BigDecimal dutyForgone;
    private String office;

    //TODO clarify what are those letters
    private String letters;

    private String flags;
    private String status;
    private String remarks;
    private String purchaseOrderNumber;
    private String location;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public static class Builder {
        public static final String DATE_FORMAT = "dd/MM/yyyy";
        private Invoice invoice;

        public Builder() {
            this.invoice = new Invoice();
        }

        public Builder withInvoiceNumber(String invoiceNumber) {
            invoice.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder withSTPIApprovalNumberAndDate(String numberAndDate) {
            invoice.STPIApprovalNumberAndDate = numberAndDate;
            return this;
        }

        public Builder withDescriptionOfGoods(String description) {
            invoice.descriptionOfGoods = description;
            return this;
        }

        public Builder withCurrency(String currencyCode) {
            invoice.currency = currencyCode;
            return this;
        }

        public Builder withForeignCurrency(double amount) {
            invoice.foreignCurrency = new BigDecimal(amount);
            return this;
        }

        public Builder withAmountSTPIApproval(double amount) {
            invoice.amountSTPIApproval = new BigDecimal(amount);
            return this;
        }

        public Builder withCIFValueInINR(double amount) {
            invoice.CIFValueInINR = new BigDecimal(amount);
            return this;
        }

        public Builder withBondNumber(String bondNumber) {
            invoice.bondNumber = bondNumber;
            return this;
        }

        public Builder withBondDate(String date) {
            try {
                invoice.bondDate = new SimpleDateFormat(DATE_FORMAT).parse(date);
            } catch (ParseException ignored) {
            }
            return this;
        }

        public Builder withBillOfEntryNumber(String billNumber) {
            invoice.billOfEntryNumber = billNumber;
            return this;
        }

        public Builder withBillOfEntryDate(String date) {
            try {
                invoice.billOfEntryDate = new SimpleDateFormat(DATE_FORMAT).parse(date);
            } catch (ParseException ignored) {
            }
            return this;
        }

        public Builder withAssessableValueInINR(double amount) {
            invoice.assessableValueInINR = new BigDecimal(amount);
            return this;
        }

        public Builder withDutyExempt(double amount) {
            invoice.dutyExempt = new BigDecimal(amount);
            return this;
        }

        public Builder withTwentyFivePercentDF(double value) {
            invoice.twentyFivePercentDF = new BigDecimal(value);
            return this;
        }

        public Builder withCGApprovedInINR(double amount) {
            invoice.CGApprovedInINR = new BigDecimal(amount);
            return this;
        }

        public Builder withDutyForgone(double amount) {
            invoice.dutyForgone = new BigDecimal(amount);
            return this;
        }

        public Builder withOffice(String office) {
            invoice.office = office;
            return this;
        }

        public Builder withLetters(String letters) {
            invoice.letters = letters;
            return this;
        }

        public Builder withFlags(String flags) {
            invoice.flags = flags;
            return this;
        }

        public Builder withStatus(String status) {
            invoice.status = status;
            return this;
        }

        public Builder withRemarks(String remarks) {
            invoice.remarks = remarks;
            return this;
        }

        public Builder withPurchaseOrderNumber(String orderNumber) {
            invoice.purchaseOrderNumber = orderNumber;
            return this;
        }

        public Builder withLocation(String location) {
            invoice.location = location;
            return this;
        }

        public Invoice build() {
            return invoice;
        }
    }
}
