package test;

import builder.AssetTestBuilder;
import builder.InvoiceTestBuilder;
import forms.AssetForm;
import forms.InvoiceForm;
import org.junit.Test;
import pages.ListISInvoicesPage;

public class ISAssetsTest extends BaseTest {

    @Test
    public void should_be_able_to_add_an_asset_and_view_its_details() {
        String invoiceNumber = "invoice123";
        AssetForm asset = new AssetTestBuilder().buildAsset();
        addInvoice(invoiceNumber)
                .addANewAsset(invoiceNumber)
                .submit(asset)
                .viewAssetDetailsPage(invoiceNumber)
                .verifyIfAssetDataIsOnTable(asset);

    }

    private ListISInvoicesPage addInvoice(String invoiceNumber) {
        InvoiceForm invoiceForm = new InvoiceTestBuilder().withInvoiceNumber(invoiceNumber).buildFinance();
        return launchKabbadi()
                .loginWithValidCredentials()
                .goToAddFinancePage()
                .submit(invoiceForm)
                .viewInvoiceInListPage(invoiceForm)
                .goToListISInvoicesPage()
                .viewInList(invoiceForm);
    }

}
