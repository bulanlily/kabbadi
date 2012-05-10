package kabbadi.domain;

import kabbadi.domain.builder.InvoiceTestBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortableInvoiceListTest {

    @Test
    public void should_sort_by_date_of_invoice() {

        Invoice invoiceWithDate = new InvoiceTestBuilder().withInvoiceDate("12/12/2012").build();
        List<Invoice> invoices = Arrays.asList(new Invoice(), new Invoice(), invoiceWithDate);

        SortableInvoiceList sortableList = new SortableInvoiceList(invoices);

        assertEquals(invoiceWithDate.getDateOfInvoice(), sortableList.sortByInvoiceDate().get(0).getDateOfInvoice());

    }

    @Test
    @Ignore
    public void should_sort_by_bond_number() {

        Invoice bondNumber = new InvoiceTestBuilder().withBondNumber("12/12-13").build();
        List<Invoice> invoices = Arrays.asList(new Invoice(), new Invoice(), bondNumber);

        SortableInvoiceList sortableList = new SortableInvoiceList(invoices);

        assertEquals(bondNumber.getBondNumber(), sortableList.sortByBondNumber().get(0).getBondNumber());

    }


}
