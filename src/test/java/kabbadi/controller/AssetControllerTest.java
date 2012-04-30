package kabbadi.controller;

import kabbadi.domain.Asset;
import kabbadi.domain.Invoice;
import kabbadi.service.AssetService;
import kabbadi.service.InvoiceService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class AssetControllerTest {

    private AssetService assetService;
    private Invoice invoice;
    private InvoiceService invoiceService;
    private AssetController assetController;

    @Before
    public void initialize_assetService_invoiceService(){
        assetService = mock(AssetService.class);
        invoice = new Invoice();
        invoiceService = mock(InvoiceService.class);
        assetController = new AssetController(assetService, invoiceService);
    }

    @Test
    public void should_render_edit_page_while_creating_asset(){
        int idOfSomeInvoice = 2;
        when(invoiceService.get(idOfSomeInvoice)).thenReturn(invoice);
        ModelAndView modelAndView = assetController.create(idOfSomeInvoice);
        assertThat(modelAndView.getViewName(), equalTo("/asset/create"));
    }

    @Test
    public void should_render_edit_page_while_editing_asset(){
        int idOfSomeInvoice = 2;
        int idOfSomeAsset = 3;
        when(assetService.get(idOfSomeAsset)).thenReturn(new Asset());
        ModelAndView modelAndView = assetController.edit(idOfSomeInvoice, idOfSomeAsset);
        assertThat(modelAndView.getViewName(), equalTo("/asset/create"));
    }

    @Test
    public void should_save_asset(){
        Asset asset = new Asset();
        int invoiceId = 2;
        assetController.save(asset, invoiceId);
        verify(invoiceService, times(1)).get(invoiceId);
        verify(assetService, times(1)).saveOrUpdate(asset);
    }
    
    
   
    
}
