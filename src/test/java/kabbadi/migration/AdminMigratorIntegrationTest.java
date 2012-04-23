package kabbadi.migration;

import kabbadi.IntegrationTest;
import kabbadi.domain.Invoice;
import kabbadi.domain.db.GenericRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AdminMigratorIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GenericRepository<Invoice> invoiceRepository;


    @Test
    public void should_recreate_csv_from_migration_sql() throws IOException {

        File adminCsvFile = new File("migration/admin.csv");

        List<String> inserts = new AdminMigrator().createInserts(FileUtils.readLines(adminCsvFile));

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
                    invoice.getBondNumber(),
                    invoice.getBondDate()
            };
            System.out.println(StringUtils.join(values, ","));
        }

        //TODO migrator needs to do all the columns then we can assert that the above output is identical to the content of adminCsvFile
    }

}
