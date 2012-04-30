package kabbadi.controller;

import kabbadi.domain.ImportType;
import kabbadi.domain.Invoice;
import kabbadi.domain.InvoiceUtils;
import kabbadi.domain.Money;
import kabbadi.domain.json.PreviousInvoiceRunningBalanceData;
import kabbadi.service.InvoiceService;
import kabbadi.spring.util.INRMoneyPropertyEditor;
import kabbadi.spring.util.NullSafeDatePropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new NullSafeDatePropertyEditor());
        binder.registerCustomEditor(Money.class, new INRMoneyPropertyEditor());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute Invoice invoice,
                            @RequestParam(value = "role", defaultValue = "admin") String role) {
        if (invoice.valid()) {
            invoiceService.saveOrUpdate(invoice);
            return new ModelAndView(new RedirectView("/invoice/list#" + role, true));
        }
        return new ModelAndView(new RedirectView("/invoice/create#" + role, true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        return editPage(new Invoice());
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        return editPage(invoiceService.get(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("invoice/list");
        modelAndView.addObject("invoices", invoiceService.listDescendingBondNumber());
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("invoice/view");
        modelAndView.addObject("invoice", invoiceService.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "/previousRunningBalance", method = RequestMethod.GET)
    public
    @ResponseBody
    PreviousInvoiceRunningBalanceData previousRunningBalance(@RequestParam("bondNumber") String currentBondNumber) {
        String previousBondNumber = InvoiceUtils.getPreviousBondNumber(currentBondNumber);
        return new PreviousInvoiceRunningBalanceData(invoiceService.findByPreviousBondNumber(previousBondNumber));
    }
    private ModelAndView editPage(Invoice invoice) {
        return new ModelAndView("invoice/edit", "invoice", invoice)
                .addObject("importTypes", ImportType.values());
    }
}
