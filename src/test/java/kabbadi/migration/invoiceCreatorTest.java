package kabbadi.migration;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class invoiceCreatorTest {
    @Test
    public void should_combine_the_entries_from_two_entries() throws Exception {
        List<Map<String, String>> financeEntries = new ArrayList<Map<String, String>>();
        List<Map<String, String>> adminEntries = new ArrayList<Map<String, String>>();
        List<Map<String, String>> entries;


        adminEntries.add(new HashMap<String, String>() {{
            put("invoiceNumber", "1");
            put("location", "2");
            put("dateOfInvoice", "3");
        }});

        adminEntries.add(new HashMap<String, String>() {{
            put("invoiceNumber", "4");
            put("location", "5");
            put("dateOfInvoice", "6");
            put("currency", "5");
            put("bondDate", "6");
        }});

        financeEntries.add(new HashMap<String, String>() {{
            put("invoiceNumber", "1");
            put("currency", "2");
            put("bondDate", "3");
        }});
        financeEntries.add(new HashMap<String, String>() {{
            put("invoiceNumber", "2");
            put("currency", "2");
            put("bondDate", "3");
        }});

        InvoiceCreator invoiceCreator = new InvoiceCreator(adminEntries, financeEntries);
        List<Map<String, String>> combinedEntries = invoiceCreator.createJoinEntry();
        assertTrue(combinedEntries.contains(new HashMap<String, String>() {{
            put("invoiceNumber", "1");
            put("location", "2");
            put("dateOfInvoice", "3");
            put("currency", "2");
            put("bondDate", "3");
        }}
        ));
    }
}
