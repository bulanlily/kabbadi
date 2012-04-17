package kabbadi.domain;

import javax.persistence.*;

@Entity
public class Invoice {

    public static final String INVOICE_NUMBER_PROPERTY = "invoiceNumber";

    @Access(AccessType.FIELD)
    private String invoiceNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Deprecated
    public Invoice() {
        invoiceNumber = "";
    }

    public Invoice(int id, String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        this.id = id;
    }

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

}
