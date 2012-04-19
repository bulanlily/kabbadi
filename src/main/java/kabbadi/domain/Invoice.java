package kabbadi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Invoice {

    public static final String INVOICE_NUMBER = "invoiceNumber";

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
    private BigDecimal runningBalance;
    private BigDecimal outrightPurchase;
    private boolean loanBasis;
    private boolean freeOfCharge;
    private String status;
    private String remarks;
    private String purchaseOrderNumber;
    private String location;
    
    //Finance Fields
    private Date dateOfInvoice;
    private String supplierNameAndAddress;


    private BigDecimal openingPurchaseValueAsOnApril01;
    private BigDecimal additionsDuringTheYear;
    private BigDecimal deletionsDuringTheYear;

    //TODO Finance Calculated fields
    // totalPurchaseValueOnDecember31
    // totalDepreciation


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public boolean valid() {
        return invoiceNumber!=null && !invoiceNumber.isEmpty();
    }

    public BigDecimal totalPurchaseValue() {
        if(openingPurchaseValueAsOnApril01 == null || additionsDuringTheYear == null || deletionsDuringTheYear == null)
            return null;

        return openingPurchaseValueAsOnApril01.add(additionsDuringTheYear).subtract(deletionsDuringTheYear);
    }
}
