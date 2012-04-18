package kabbadi.controller;

import kabbadi.domain.Invoice;
import kabbadi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @RequestMapping(value = "invoice/create", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute Invoice invoice) {

        if (!invoice.getInvoiceNumber().isEmpty()) {
            invoiceService.save(invoice);
            return new ModelAndView(new RedirectView("/invoice/list", true));
        }

        return new ModelAndView(new RedirectView("/invoice/create", true));
    }

    @RequestMapping(value = "invoice/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("invoice/create", "invoice", new HashMap());
    }
}
