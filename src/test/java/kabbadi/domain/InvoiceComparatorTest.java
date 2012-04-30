package kabbadi.domain;

import com.google.common.collect.Lists;
import kabbadi.domain.builder.InvoiceTestBuilder;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InvoiceComparatorTest {
    Invoice oldDateInvoice = new InvoiceTestBuilder().withInvoiceDate("01/01/2001").build();
    Invoice newDateInvoice = new InvoiceTestBuilder().withInvoiceDate("02/02/2002").build();
    Invoice oldBondInvoice = new InvoiceTestBuilder().withBondNumber("123").build();
    Invoice newBondInvoice = new InvoiceTestBuilder().withBondNumber("312").build();

    @Test
    public void should_order_invoices_by_date_descending() {
        List<Invoice> invoices = createListOfInvoices(oldDateInvoice, newDateInvoice);
        Collections.sort(invoices, InvoiceComparator.ByInvoiceDate.descending());
        assertThat(invoices.get(0), equalTo(newDateInvoice));
    }

    @Test
    public void should_order_invoices_by_date_ascending() {
        List<Invoice> invoices = createListOfInvoices(oldDateInvoice, newDateInvoice);
        Collections.sort(invoices, InvoiceComparator.ByInvoiceDate.ascending());
        assertThat(invoices.get(0), equalTo(oldDateInvoice));
    }

    @Test
    public void should_order_invoices_by_date_when_no_date_is_provided() {
        Invoice newInvoice = new Invoice();
        List<Invoice> invoices = createListOfInvoices(oldDateInvoice, newInvoice);
        Collections.sort(invoices, InvoiceComparator.ByInvoiceDate.ascending());
        assertThat(invoices.get(0), equalTo(oldDateInvoice));
    }


    @Test
    public void should_order_invoices_by_invoice_number_descending() {
        List<Invoice> invoices = createListOfInvoices(oldBondInvoice, newBondInvoice);
        Collections.sort(invoices, InvoiceComparator.ByBondNumber.descending());
        assertThat(invoices.get(0), equalTo(newBondInvoice));
    }

    @Test
    public void should_order_invoices_by_date_when_no_bond_number_is_provided() {
        Invoice newEmptyInvoice = new Invoice();
        List<Invoice> invoices = createListOfInvoices(oldBondInvoice, newEmptyInvoice);
        Collections.sort(invoices, InvoiceComparator.ByBondNumber.ascending());
        assertThat(invoices.get(0), equalTo(oldBondInvoice));
    }

    private List<Invoice> createListOfInvoices(Invoice oldInvoice, Invoice newInvoice) {
        return Lists.newArrayList(
                oldInvoice,
                newInvoice
        );
    }                                                                                                                                                                                                                                                                        newInvoice