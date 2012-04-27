package kabbadi.controller;

import kabbadi.domain.Asset;
import kabbadi.domain.Invoice;
import kabbadi.service.AssetService;
import kabbadi.service.InvoiceService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class AssetControllerTest {

    @Test
    public void should_render_edit_page_while_creating_asset(){
        AssetService assetService = mock(AssetService.class);
        Invoice invoice = new Invoice();
        InvoiceService invoiceService = mock(InvoiceService.class);
        AssetController assetController = new AssetController(assetService, invoiceService);
        int idOfSomeInvoice = 2;
        when(invoiceService.get(idOfSomeInvoice)).thenReturn(invoice);
        ModelAndView modelAndView = assetController.create(idOfSomeInvoice);
        assertThat(modelAndView.getViewName(), equalTo("/asset/create"));
    }
    
    @Test
    public void should_save_asset(){
        AssetService assetService = mock(AssetService.class);
        InvoiceService invoiceService = mock(InvoiceService.class);
        Asset asset = new Asset();
        asset.setInvoice(new Invoice());
        AssetController assetController = new AssetController(assetService, invoiceService);
        assetController.save(asset);
        verify(assetService, times(1)).saveOrUpdate(asset);
    }
}
