package kabbadi.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminMigrator {

    static private final String INSERT_TEMPLATE = "insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate, descriptionOfGoods, currency, foreignCurrency, amountSTPIApproval, CIFValueInINR, bondNumber) values ($id$, '$invoiceNumber$', '$stpiApprovalNumberAndDate$', '$descriptionOfGoods$', '$currency$', '$foreignCurrency$', '$amountSTPIApproval$', '$CIFValueInINR$', '$bondNumber$')";
    static private final int ID_OFFSET = 100;

    static private final int STPI_COL_INDEX = 1;
    static private final int DESCRIPTION_COL_INDEX = 2;
    static private final int CURRENCY_COL_INDEX = 3;
    static private final int FOREIGN_CURRENCY_COL_INDEX = 4;
    static private final int AMOUNT_STPI_APPROVAL_INDEX = 5;
    static private final int CIF_VALUE_INR_INDEX = 6;
    static private final int BOND_NUMBER_INDEX = 7;


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
                .replace("$stpiApprovalNumberAndDate$", tokens[STPI_COL_INDEX])
                .replace("$descriptionOfGoods$", tokens[DESCRIPTION_COL_INDEX])
                .replace("$currency$", tokens[CURRENCY_COL_INDEX])
                .replace("$foreignCurrency$", tokens[FOREIGN_CURRENCY_COL_INDEX])
                .replace("$amountSTPIApproval$", tokens[AMOUNT_STPI_APPROVAL_INDEX])
                .replace("$CIFValueInINR$", tokens[CIF_VALUE_INR_INDEX])
                .replace("$bondNumber$", tokens[BOND_NUMBER_INDEX]);
    }

}
