package kabbadi.service;

import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.Mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class InvoiceServiceTest {

    private InvoiceService invoiceService;
    @Mock
    private GenericRepository<Invoice> repository;

    @Before
    public void init() {
        initMocks(this);
        invoiceService = new InvoiceService(repository);
    }

    @Test
    public void findBy_finds_the_invoice_from_repository_by_invoice_number() {
        String invoiceNumber = "PO-123456";
        invoiceService.findBy(invoiceNumber);
        verify(repository).findBy("invoiceNumber", invoiceNumber);
    }

    @Test
    public void get_finds_the_invoice_by_id() {
        Integer id = 5;
        Invoice invoice = invoiceService.get(id);
        verify(repository).get(id);
        assertThat(invoice, equalTo(repository.get(id)));
    }

    @Test
    public void list_pulls_a_list_of_invoices() {
        List<Invoice> invoiceList = invoiceService.list();
        verify(repository).list();
        assertThat(invoiceList, equalTo(repository.list()));
    }

}
