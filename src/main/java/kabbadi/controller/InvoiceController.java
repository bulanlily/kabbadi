package kabbadi.controller;

import kabbadi.domain.*;
import kabbadi.domain.json.PreviousInvoiceRunningBalanceData;
import kabbadi.service.InvoiceService;
import kabbadi.spring.util.INRMoneyPropertyEditor;
import kabbadi.spring.util.NullSafeDatePropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(@Qualifier("invoiceService") InvoiceService invoiceService) {
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

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        return editPage(invoiceService.get(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        return new ModelAndView("invoice/list")
                .addObject("invoices", invoiceService.list())
                .addObject("locations",Location.values());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetails(@PathVariable("id") Integer id) {
        return new ModelAndView("invoice/view").addObject("invoice", invoiceService.get(id));
    }

    @RequestMapping(value = "/previousRunningBalance", method = RequestMethod.GET)
    public
    @ResponseBody
    PreviousInvoiceRunningBalanceData previousRunningBalance(
            @RequestParam("bondNumber") String currentBondNumber,
            @RequestParam("location") Location location) {
        String previousBondNumber = new PreviousBondNumberConverter(currentBondNumber).getPreviousBondNumber();
        return new PreviousInvoiceRunningBalanceData(invoiceService.findByPreviousBondNumber(previousBondNumber, location));
    }

    @RequestMapping(value = "/report/admin", method = RequestMethod.GET)
    public ModelAndView generateReport(@RequestParam("location") String location) {
        Location loc = Location.valueOf(location);
           List<Invoice> invoiceList = invoiceService.findByLocation(loc);
        return new ModelAndView("invoice/report/admin")
                .addObject("invoiceList", invoiceList)
                .addObject("location",loc);
    }

    private ModelAndView editPage(Invoice invoice) {
        return new ModelAndView("invoice/edit", "invoice", invoice)
                .addObject("importTypes", ImportType.values())
                .addObject("locations", Location.values());

    }
}
