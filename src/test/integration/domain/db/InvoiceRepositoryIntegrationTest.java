package domain.db;

import domain.builder.InvoiceTestBuilder;
import integration.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.Location;
import kabbadi.domain.db.InvoiceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class InvoiceRepositoryIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void should_have_a_invoice() {
        String invoiceNumber = "invoice27";
        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(invoiceNumber);
        invoiceRepository.save(invoice);

        Invoice actualInvoice = invoiceRepository.findBy(Invoice.INVOICE_NUMBER, invoiceNumber);

        assertThat(actualInvoice.getInvoiceNumber(), equalTo(invoiceNumber));

    }

    @Test
    public void should_get_an_invoice_list() {

        int currentSize = invoiceRepository.list().size();

        invoiceRepository.save(new Invoice());
        invoiceRepository.save(new Invoice());
        invoiceRepository.save(new Invoice());

        assertThat(invoiceRepository.list().size(), equalTo(currentSize + 3));

    }

    @Test
    public void should_not_find_old_invoice_data() {
        setupInvoicesWithInvoiceNumbers(Location.BANGALORE, "12345","old data","old data");
        List<Invoice> invoiceList = invoiceRepository.findAllNotEqualTo("invoiceNumber", "old data");
        for (Invoice invoice : invoiceList) {
            assertThat(invoice.getInvoiceNumber(), not(containsString("old data")));
       }
        assertThat(invoiceList.size(), equalTo(1));

    }

    private void setupInvoicesWithInvoiceNumbers(Location location, String... invoiceNumbers) {
        List<Invoice> invoicesToClear = invoiceRepository.list();
        for (Invoice invoice : invoicesToClear) {
            invoiceRepository.delete(invoice);
        }
        for (String invoiceNumber : invoiceNumbers) {
            invoiceRepository.saveOrUpdate(invoiceWith(invoiceNumber, location));
        }
    }

    private Invoice invoiceWith(String invoiceNumber, Location location) {
        return new InvoiceTestBuilder().withInvoiceNumber(invoiceNumber).withLocation(location).build();
    }
}
