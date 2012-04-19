package kabbadi.controller;

import kabbadi.domain.Invoice;
import kabbadi.service.InvoiceService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvoiceControllerTest {

    @Test
    public void should_get_the_invoice_from_service_and_render_it_in_edit_page() {
        InvoiceService invoiceService = mock(InvoiceService.class);
        InvoiceController controller = new InvoiceController(invoiceService);
        Invoice expectedInvoice = new Invoice();
        when(invoiceService.get(5)).thenReturn(expectedInvoice);

        ModelAndView modelAndView = controller.edit(5);

        assertThat(modelAndView.getViewName(), is(equalTo("invoice/edit")));
        assertThat((Invoice) modelAndView.getModelMap().get("invoice"), is(equalTo(expectedInvoice)));
    }
}
