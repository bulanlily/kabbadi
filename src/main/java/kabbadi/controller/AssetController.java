package kabbadi.controller;

import kabbadi.domain.Asset;
import kabbadi.service.AssetService;
import kabbadi.service.InvoiceService;
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
@RequestMapping(value="/invoice/{invoiceId}")
public class AssetController {
    private AssetService assetService;
    private InvoiceService invoiceService;

    @Autowired
    public AssetController(AssetService assetService, InvoiceService invoiceService) {
        this.assetService = assetService;
        this.invoiceService = invoiceService;
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new NullSafeDatePropertyEditor());
    }

    @RequestMapping(value="/asset/create", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable("invoiceId")Integer invoiceId) {
        ModelAndView modelAndView = new ModelAndView("/asset/create");
        Asset asset = new Asset();
        asset.setInvoice(invoiceService.get(invoiceId));
        modelAndView.addObject("asset", asset);
        return modelAndView;
    }

    @RequestMapping(value="/asset/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Asset asset, @PathVariable("invoiceId")Integer invoiceId) {
        asset.setInvoice(invoiceService.get(invoiceId));
        assetService.saveOrUpdate(asset);
        return new ModelAndView(new RedirectView("/invoice/list#is", true));
    }
    
    @RequestMapping(value="/asset/{assetId}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("invoiceId")Integer invoiceId, @PathVariable("assetId")Integer assetId){
        ModelAndView modelAndView = new ModelAndView("/asset/create");
        Asset asset = assetService.get(assetId);
        modelAndView.addObject("asset", asset);
        return modelAndView;
    }
}
