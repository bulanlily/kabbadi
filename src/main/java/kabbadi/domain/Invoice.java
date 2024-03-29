package kabbadi.domain;

import lombok.Getter;
import lombok.Setter;
import org.h2.util.StringUtils;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
public class Invoice {

    public static final String INVOICE_NUMBER = "invoiceNumber";

    private String invoiceNumber;

    private String STPIApprovalNumberAndDate;
    @Column(columnDefinition = "TEXT")
    private String descriptionOfGoods;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "foreignValue"))
    })
    private Money foreignValue;

    private BigDecimal amountSTPIApproval;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "CIFCurrency")),
            @AttributeOverride(name = "amount", column = @Column(name = "CIFValueInINR"))
    })
    private Money CIFValueInINR;
    private BigDecimal outrightPurchase;
    private String loanBasis;
    private BigDecimal freeOfCharge;

    @Enumerated(EnumType.STRING)
    private ImportType importType;

    private String bondNumber;
    private Date dateOfArrival;
    private Date bondDate;
    private String billOfEntryNumber;
    private Date billOfEntryDate;
    private BigDecimal assessableValueInINR;
    private BigDecimal dutyExempt;
    private BigDecimal twentyFivePercentDF;
    private BigDecimal cgApprovedInINR;
    private BigDecimal dutyForgone;
    private BigDecimal runningBalance;

    private String status;
    private String remarks;
    private String purchaseOrderNumber;

    @Enumerated(EnumType.STRING)
    private Location location;

    private Date dateOfCommissioning;
    private String groupOfAssets;
    private String costCentre;
    private Date dateOfInvoice;
    private String supplierNameAndAddress;

    private BigDecimal openingPurchaseValueAsOnApril01;

    @Column(name = "additionsDuringTheYear", nullable = true, columnDefinition = "decimal default 0")
    private BigDecimal additionsDuringTheYear;

    @Column(name = "deletionsDuringTheYear", nullable = true, columnDefinition = "decimal default 0")
    private BigDecimal deletionsDuringTheYear;
    private Integer quantity;
    private String identificationNumber;

    @Id
    @GenericGenerator(name = "auto-increment", strategy = "increment")
    @GeneratedValue(generator = "auto-increment")
    private Integer invoice_id;

    @OneToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            mappedBy = "invoice"
    )
    @Fetch(FetchMode.JOIN)
    private List<Asset> assets;

    @Transient
    private RunningBalanceCalculator runningBalanceCalculator;

    public Invoice() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (invoice_id != invoice.invoice_id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return invoice_id != null ? invoice_id.hashCode() : 0;
    }

    public boolean valid() {
        return invoiceNumber != null && !invoiceNumber.isEmpty();
    }

    public BigDecimal gbOnDecember31() {
        if (openingPurchaseValueAsOnApril01 == null || additionsDuringTheYear == null || deletionsDuringTheYear == null)
            return null;

        return openingPurchaseValueAsOnApril01.add(additionsDuringTheYear).subtract(deletionsDuringTheYear);
    }

    public String getCIFDisplayAmountInINR() {
        return (CIFValueInINR == null) ? "" : CIFValueInINR.displayAmount();
    }

    public String getForeignValueDisplayAmount() {
        return (foreignValue == null) ? "" : foreignValue.displayAmount();
    }

    public String getForeignCurrency() {
        return (foreignValue == null) ? "" : foreignValue.getCurrency();
    }

    public boolean isBonded() {
        return !StringUtils.isNullOrEmpty(bondNumber);
    }

    public String getBondNumber() {
        return (StringUtils.isNullOrEmpty(bondNumber)) ? "" : bondNumber;
    }

    public BigDecimal getAmountSTPIApproval() {
        return amountSTPIApproval == null ? new BigDecimal(0) : amountSTPIApproval;
    }

    public BigDecimal getCgApprovedInINR() {
        return cgApprovedInINR == null ? new BigDecimal(0) : cgApprovedInINR;
    }

    public BigDecimal runningBalance() {
        if (runningBalanceCalculator == null)
            throw new IllegalStateException("Set the running balance calculator before calling running balance");

        return runningBalanceCalculator.calculateStartingFrom(this);
    }

    public BigDecimal getLoanBasis(){
        if(this.importType == ImportType.LOAN_BASIS){
            return CIFValueInINR == null?new BigDecimal(0):this.CIFValueInINR.getAmount();
        }
        return  new BigDecimal(0);
    }

    public BigDecimal getOutrightPurchase(){
        if(this.importType == ImportType.OUTRIGHT_PURCHASE){
            return CIFValueInINR == null?new BigDecimal(0):this.CIFValueInINR.getAmount();
        }
        return  new BigDecimal(0);
    }

    public BigDecimal getFreeOfCharge(){
        if(this.importType == ImportType.FREE_OF_CHARGE){
            return CIFValueInINR == null?new BigDecimal(0):this.CIFValueInINR.getAmount();
        }
        return  new BigDecimal(0);
    }

}