package kabbadi.controller;

import kabbadi.domain.Invoice;
import kabbadi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "invoice/new", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam(value = "invoiceNumber", defaultValue = "") String invoiceNumber) {

        if (!invoiceNumber.isEmpty()) {
            invoiceService.save(new Invoice.Builder().withInvoiceNumber(invoiceNumber).buildInvoice());
            return new ModelAndView(new RedirectView("/invoice/list", true));
        }

        return new ModelAndView(new RedirectView("/invoice/create", true));
    }

    @RequestMapping(value = "invoice/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("invoice/create", "invoice", new HashMap());
    }
}
