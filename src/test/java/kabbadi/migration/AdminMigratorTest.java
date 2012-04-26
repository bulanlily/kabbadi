package kabbadi.migration;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AdminMigratorTest {

    @Test
    public void should_create_insert_statements() {
        String record = "653010065,STIPB/Import/EXCISEDUTY/23112011/0043/31733  Dt.28-Nov-2011,Networking Accessories,USD,6333.00,6333.00,,26/11-12,,,,,,,,,,,,";
        List<String> records = new ArrayList<String>();
        records.add(record);

        List<String> inserts = new AdminMigrator().createInserts(records);

        String expectedStatement =
                "INSERT INTO invoice (id, invoiceNumber, STPIApprovalNumberAndDate, " +
                        "descriptionOfGoods, currency, foreignCurrency, " +
                        "amountSTPIApproval, CIFValueInINR, bondNumber, bondDate," +
                        " billOfEntryNumber, billOfEntryDate, assessableValueInINR, dutyExempt, twentyFivePercentDF," +
                        " outrightPurchase, loanBasis, freeOfCharge, cgApprovedInINR, dutyForgone, runningBalance) " +
                "VALUES " +
                        "(100, '653010065', 'STIPB/Import/EXCISEDUTY/23112011/0043/31733  Dt.28-Nov-2011', " +
                        "'Networking Accessories', 'USD', 6333.00, 6333.00, null, " +
                        "'26/11-12', null, null, null, null, null, null, null, null, null, null, null, null);";

        assertThat(inserts.size(), equalTo(1));
        assertThat(inserts.get(0), equalTo(expectedStatement));
    }

}
