package kabbadi.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminMigrator {

    static private final String INSERT_TEMPLATE = "insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values ($id$, '$invoiceNumber$', '$stpiApprovalNumberAndDate$')";
    static private final int ID_OFFSET = 100;

    static private final int STPI_COL_INDEX = 1;

    public List<String> createInserts(List<String> lines) {
        List<String> inserts = new ArrayList<String>();
        for (int id=0; id<lines.size(); id++) {
            inserts.add (constructInsertStatement(lines.get(id), id + ID_OFFSET));
        }
        return inserts;
    }

    private String constructInsertStatement(String line, int id) {
        String[] tokens = line.split(",");
        return INSERT_TEMPLATE
                .replace("$id$", String.valueOf(id))
                .replace("$invoiceNumber$", "unknown")
                .replace("$stpiApprovalNumberAndDate$", tokens[STPI_COL_INDEX]);
    }

}
