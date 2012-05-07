package kabbadi.service;

import kabbadi.domain.Invoice;
import kabbadi.domain.Location;
import kabbadi.domain.db.GenericRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void get_invoice_by_location() {
        Location location = Location.valueOf("BANGALORE");
        List<Invoice> invoiceList = invoiceService.findByLocation(location);
        verify(repository).findAll("location", location);
    }

    @Test
    public void should_get_a_list_of_new_invoices() {

        List<Invoice> invoiceList = invoiceService.getInvoicesExcluding("invoiceNumber", "OldData");

        verify(repository).findAllNotEqualTo("invoiceNumber", "OldData");
    }

}
