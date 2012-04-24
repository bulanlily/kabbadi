package kabbadi.migration;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AdminMigratorTest {

    @Test
    public void should_create_insert_statements() {
        String record = "26,STPIB/Import/25112011/0043/31733  Dt.28-Nov-2011,Networking Equipment With Accessories,USD,6333.00,6333.00,333115.80,26/11-12,01-Jan-12,5362272,02-Dec-11,336446.96, -   ,,,,Westcon(Singapore) Pvt Ltd Sify Data Center,,49049.00,,Sify,2012,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";
        List<String> records = new ArrayList<String>();
        records.add(record);

        List<String> inserts = new AdminMigrator().createInserts(records);

        String expectedStatement =
                "INSERT INTO invoice (id, invoiceNumber, STPIApprovalNumberAndDate, " +
                        "descriptionOfGoods, currency, foreignCurrency, " +
                        "amountSTPIApproval, CIFValueInINR, bondNumber, bondDate) " +
                        "VALUES " +
                        "(100, 'unknown', 'STPIB/Import/25112011/0043/31733  Dt.28-Nov-2011', " +
                        "'Networking Equipment With Accessories', 'USD', 6333.00, 6333.00, 333115.80, " +
                        "'26/11-12', '01-Jan-12')";

        assertThat(inserts.size(), equalTo(1));
        assertThat(inserts.get(0), equalTo(expectedStatement));
    }

}
