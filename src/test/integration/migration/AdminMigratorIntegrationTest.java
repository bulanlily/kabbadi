package migration;

import integration.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import kabbadi.migration.AdminMigrator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AdminMigratorIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GenericRepository<Invoice> invoiceRepository;


    @Test
    public void should_recreate_csv_from_migration_sql() throws IOException, ParseException {

        insertValuesFromCsvToDatabase();

        String originalData = originalFileContent();
        String obtainedData = retrieveValuesFromDatabase();

        assertThat(obtainedData, equalTo(originalData));
    }


    private File sourceFile() {
        return new File("migration/KabbadiAdmin.csv");
    }

    private String originalFileContent() throws IOException {
        List<String> originalInvoiceList = FileUtils.readLines(sourceFile());
        Collections.sort(originalInvoiceList);
        return listToString(originalInvoiceList);
    }

    private String listToString(List<String> originalInvoiceList) {
        StringBuilder originalData = new StringBuilder();
        for(String invoice: originalInvoiceList){
            originalData.append(invoice);
        }
        return originalData.toString();
    }

    private void insertValuesFromCsvToDatabase() throws IOException{
        List<String> inserts =  new AdminMigrator().createInserts(FileUtils.readLines(sourceFile()));

        sessionFactory.getCurrentSession().createSQLQuery("delete from invoice;").executeUpdate();

        for (String insert : inserts) {
            sessionFactory.getCurrentSession().createSQLQuery(insert).executeUpdate();
        }
    }

    private String retrieveValuesFromDatabase() {
        List<String> obtainedInvoiceList = new ArrayList<String>();
        for (Invoice invoice : invoiceRepository.list()) {
            Object[] values = {
                    invoice.getInvoiceNumber(),
                    invoice.getSTPIApprovalNumberAndDate(),
                    invoice.getDescriptionOfGoods(),
                    invoice.getCurrency(),
                    invoice.getForeignCurrency(),
                    invoice.getAmountSTPIApproval(),
                    invoice.getCIFDisplayAmountInINR(),
                    invoice.getBondNumber(),
                    formatDate(invoice.getBondDate()),
                    invoice.getBillOfEntryNumber(),
                    formatDate(invoice.getBillOfEntryDate()),
                    invoice.getAssessableValueInINR(),
                    invoice.getDutyExempt(),
                    invoice.getTwentyFivePercentDF(),
                    invoice.getOutrightPurchase(),
                    invoice.getLoanBasis(),
                    invoice.getFreeOfCharge(),
                    invoice.getCgApprovedInINR(),
                    invoice.getDutyForgone(),
                    invoice.getRunningBalance(),

            };
            obtainedInvoiceList.add(StringUtils.join(values, ","));

        }
        Collections.sort(obtainedInvoiceList);
        return listToString(obtainedInvoiceList);
    }


    private String formatDate(Date bondDate) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yy");
        return bondDate == null ? null : df.format(bondDate);
    }

}
