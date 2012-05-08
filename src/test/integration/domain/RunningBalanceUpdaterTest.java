package domain;

import integration.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.Location;
import kabbadi.domain.RunningBalanceUpdater;
import kabbadi.domain.builder.InvoiceTestBuilder;
import kabbadi.service.InvoiceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;

public class RunningBalanceUpdaterTest extends IntegrationTest {

    @Autowired
    InvoiceService invoiceService;

    @Test
    public void test_updates_old() {
        Invoice oldInvoice = invoiceWith("11/98-99", 123);
        invoiceService.saveOrUpdate(oldInvoice);

        invoiceService.saveOrUpdate(invoiceWith("12/98-99", 123));
        invoiceService.saveOrUpdate(invoiceWith("13/98-99", 123));

        Invoice newInvoice = invoiceWith("14/98-99", 123);
        invoiceService.saveOrUpdate(newInvoice);

        new RunningBalanceUpdater(invoiceService).updateSince(newInvoice);
        assertEquals(new BigDecimal(369), newInvoice.getRunningBalance());

        oldInvoice.setAdditionsDuringTheYear(new BigDecimal(0));
        invoiceService.saveOrUpdate(oldInvoice);

        new RunningBalanceUpdater(invoiceService).updateSince(newInvoice);
        assertEquals(new BigDecimal(369 - 123), newInvoice.getRunningBalance());

        oldInvoice.setAmountSTPIApproval(new BigDecimal(1000));
        invoiceService.saveOrUpdate(oldInvoice);

        new RunningBalanceUpdater(invoiceService).updateSince(newInvoice);
        assertEquals(new BigDecimal(369 - 123 - 1000), newInvoice.getRunningBalance());

    }

    private Invoice invoiceWith(String invoiceNumber, int amount) {
        return new InvoiceTestBuilder()
                .withInvoiceNumber(invoiceNumber)
                .withBondNumber(invoiceNumber)
                .withRunningBalance(0)
                .withAmountSTPIApproval(0)
                .withAdditionsDuringTheYear(amount)
                .withLocation(Location.BANGALORE)
                .build();
    }
}
