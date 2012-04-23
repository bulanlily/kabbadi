package kabbadi.migration;

import kabbadi.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AdminMigratorIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GenericRepository<Invoice> invoiceRepository;


    @Test
    public void should_recreate_csv_from_migration_sql() {

        String adminCsvFile = "scripts/migration/admin.csv";

        List<String> inserts = new AdminMigrator().createInserts(readLinesFromFile(adminCsvFile));

        GenericRepository<Invoice> repository = new GenericRepository<Invoice>(sessionFactory, Invoice.class);

        sessionFactory.getCurrentSession().createSQLQuery("delete from invoice;").executeUpdate();
        assertThat(repository.list().size(), equalTo(0));

        for (String insert : inserts) {
            sessionFactory.getCurrentSession().createSQLQuery(insert).executeUpdate();
        }

        for (Invoice invoice : repository.list()) {
            Object[] values = {
                    invoice.getSTPIApprovalNumberAndDate(),
                    invoice.getDescriptionOfGoods(),
                    invoice.getCurrency(),
                    invoice.getForeignCurrency(),
                    invoice.getAmountSTPIApproval(),
                    invoice.getCIFValueInINR(),
                    invoice.getBondNumber()
            };
            System.out.println(StringUtils.join(values, ","));
        }

        //TODO migrator needs to do all the columns then we can assert that the above output is identical to the content of adminCsvFile
    }

    private List<String> readLinesFromFile(String filename) {
        InputStream in = null;

        try {
            in = new FileInputStream(new File(filename));
            return IOUtils.readLines(in);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            IOUtils.closeQuietly(in);
        }
    }
}
