package kabbadi.controller;

import kabbadi.domain.ImportType;
import kabbadi.domain.Invoice;
import kabbadi.domain.Location;
import kabbadi.service.InvoiceService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvoiceControllerTest {

    InvoiceService invoiceService;
    InvoiceController invoiceController;
    @Before
    public void setUp(){
         invoiceService = mock(InvoiceService.class);
         invoiceController = new InvoiceController(invoiceService);
    }

    @Test
    public void should_get_the_invoice_from_service_and_render_it_in_edit_page() {
        Invoice expectedInvoice = new Invoice();
        when(invoiceService.get(5)).thenReturn(expectedInvoice);

        ModelAndView modelAndView = invoiceController.edit(5);

        assertThat(modelAndView.getViewName(), is(equalTo("invoice/edit")));
        assertThat((Invoice) modelAndView.getModelMap().get("invoice"), is(equalTo(expectedInvoice)));
        assertThat((ImportType[]) modelAndView.getModelMap().get("importTypes"), is(equalTo(ImportType.values())));
        assertThat((Location[]) modelAndView.getModelMap().get("locations"), is(equalTo(Location.values())));
    }

    @Test
    public void should_get_generate_report_page_given_location(){
        List<Invoice> invoiceList = mock(List.class);
        when(invoiceService.findByLocation("Bangalore")).thenReturn(invoiceList);
        ModelAndView modelAndView = invoiceController.generateReport("Bangalore");
        assertThat(modelAndView.getViewName(),equalTo("invoice/report/admin"));
        assertEquals(modelAndView.getModelMap().get("invoiceList"), (invoiceService.findByLocation("Bangalore")));
    }
}
