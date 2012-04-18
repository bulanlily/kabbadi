package kabbadi.controller;

import kabbadi.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import kabbadi.service.InvoiceService;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class InvoiceControllerTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;
    private InvoiceController controller;
    private InvoiceService invoiceService;

    @Before
    public void setup() {
        this.invoiceService = buildInvoiceService();
        this.controller = buildInvoiceController(invoiceService);
    }

    @Test
    public void should_add_a_new_invoice_in_the_database() throws Exception {

        String invoiceNumber = "Invoice27";

        controller.add(invoiceNumber);

        assertThat(invoiceService.findBy(invoiceNumber).getInvoiceNumber(), equalTo(invoiceNumber));

    }

    @Test
    public void should_not_add_an_invoice_without_an_invoice_number() throws Exception {

        String invoiceNumber = "";

        controller.add(invoiceNumber);

        assertThat(invoiceService.findBy(invoiceNumber), nullValue());

    }

    @Test
    public void should_show_new_invoice_form() throws Exception {

        ModelAndView createView = controller.create();
        assertThat(createView.getViewName(), equalTo("invoice/create"));

    }

    private InvoiceController buildInvoiceController(InvoiceService invoiceService) {
        return new InvoiceController(invoiceService);
    }

    private InvoiceService buildInvoiceService() {
        return new InvoiceService(new GenericRepository<Invoice>(sessionFactory, Invoice.class));

    }
}
