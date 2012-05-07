package kabbadi.service;

import kabbadi.domain.Asset;
import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import kabbadi.domain.db.InvoiceRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class GenericServiceTest {
    private InvoiceService invoiceService;
    private AssetService assetService;
    @MockitoAnnotations.Mock
    private InvoiceRepository invoiceRepository;
    @MockitoAnnotations.Mock
    private GenericRepository<Asset> assetRepository;

    @Before
    public void init() {
        initMocks(this);
        invoiceService = new InvoiceService(invoiceRepository);
        assetService = new AssetService(assetRepository);
    }

    @Test
    public void get_finds_the_invoice_and_asset_by_id() {
        Integer id = 5;
        Invoice invoice = invoiceService.get(id);
        Asset asset = assetService.get(id);

        verify(invoiceRepository).get(id);
        verify(assetRepository).get(id);

        assertThat(invoice, equalTo(invoiceRepository.get(id)));
        assertThat(asset, equalTo(assetRepository.get(id)));
    }

    @Test
    public void list_pulls_a_list_of_invoices_and_assets() {
        List<Invoice> invoiceList = invoiceService.list();
        List<Asset> assetList = assetService.list();

        verify(invoiceRepository).list();
        verify(assetRepository).list();

        assertThat(invoiceList, equalTo(invoiceRepository.list()));
        assertThat(assetList, equalTo(assetRepository.list()));
    }

}
