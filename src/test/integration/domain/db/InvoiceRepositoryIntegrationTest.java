package domain.db;

import domain.builder.InvoiceTestBuilder;
import integration.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
    private GenericRepository<Invoice> invoiceRepository;



    @Test
    public void should_have_a_invoice() {
        String invoiceNumber = "invoice27";
        addToDatabase(invoiceNumber);

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

    private void addToDatabase(String invoiceNumber) {

        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "insert into Invoice (invoice_id, invoiceNumber, freeOfCharge, loanBasis) values (27, '" + invoiceNumber + "', 0, 0);";
        currentSession.createSQLQuery(sql).executeUpdate();

    }

    @Test
    public void should_not_find_old_invoice_data() {
        GenericRepository<Invoice> repository = new GenericRepository<Invoice>(sessionFactory, Invoice.class);

        List<Invoice> invoicesToClear = repository.list();

        for (Invoice invoice : invoicesToClear) {
            repository.delete(invoice);
        }

        repository.saveOrUpdate(new InvoiceTestBuilder().withInvoiceNumber("12345").build());
        repository.saveOrUpdate(new InvoiceTestBuilder().withInvoiceNumber("OldData").build());
        repository.saveOrUpdate(new InvoiceTestBuilder().withInvoiceNumber("OldData").build());

        List<Invoice> invoiceList = repository.findAllNotEqualTo("invoiceNumber", "OldData");

        for (Invoice invoice : invoiceList) {
            assertThat(invoice.getInvoiceNumber(), not(containsString("OldData")));
        }

        assertThat(invoiceList.size(), equalTo(1));

    }
}
