package kabbadi.service;

import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.*;

public class InvoiceServiceTest {

    private InvoiceService invoiceService;
    @Mock
    private GenericRepository<Invoice> repository;

    @Before
    public void init() {
        initMocks(this);
        invoiceService= new InvoiceService(repository);
    }

    @Test
    public void findBy_finds_the_invoice_from_repository_by_purchase_order() {
        String poNumber = "PO-123456";
        invoiceService.findBy(poNumber);
        verify(repository).findBy("purchaseOrderNumber",poNumber);
    }

}
