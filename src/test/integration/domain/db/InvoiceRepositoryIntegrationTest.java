package domain.db;

import integration.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
}
