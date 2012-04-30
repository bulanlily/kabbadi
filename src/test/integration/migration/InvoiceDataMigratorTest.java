package migration;

import junit.framework.TestCase;
import kabbadi.migration.CSVParser;
import kabbadi.migration.InvoiceDataMigrator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class InvoiceDataMigratorTest {
    @Test
    public void should_create_insert_statements() {
        List<String[]> adminInvoiceList = new ArrayList<String[]>();
        String[] entry = new String[30];
        for (int i = 0; i < 30; i++) entry[i] = Integer.toString(i);
        adminInvoiceList.add(entry);

        List<String> inserts = new InvoiceDataMigrator().createInserts(adminInvoiceList);
        String expected = "INSERT INTO invoice (id, invoiceNumber, STPIApprovalNumberAndDate, descriptionOfGoods, currency, foreignCurrency, amountSTPIApproval, CIFValueInINR, bondNumber, bondDate, billOfEntryNumber, billOfEntryDate, assessableValueInINR, dutyExempt, twentyFivePercentDF, outrightPurchase, loanBasis, freeOfCharge, cgApprovedInINR, dutyForgone, runningBalance, dateOfInvoice, dateOfCommissioning, supplierNameAndAddress, groupOfAssets, quantity, location, identificationNumber, type, deletionsDuringTheYear, costCentre) VALUES (100, '0', '1', '2', '3', 4, 5, 6, '7', '8', 9, '10', 11, 12, 13, 14, '15', 16, 17, 18, 19, '20', '21', '22', '23', 24, '25', '26', '27', 28, '29');";
        assertThat(inserts.get(0), equalTo(expected));

    }
}
