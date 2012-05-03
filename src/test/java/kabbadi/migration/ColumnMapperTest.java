package kabbadi.migration;

import kabbadi.migration.ColumnMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ColumnMapperTest {
    @Test
    public void should_map_items_to_column_names() throws Exception {
        String[] columns = {"invoiceNumber", "dateOfInvoice"};
        ArrayList<String[]> entries = new ArrayList<String[]>();
        entries.add(new String[] {"1", "2"});
        entries.add(new String[] {"4", "5"});
        List<Map<String, String>> result = new ColumnMapper(columns, entries).mapedList();
        assertThat(result.get(0).get("invoiceNumber"), equalTo("1"));
        assertThat(result.get(1).get("dateOfInvoice"), equalTo("5"));
    }
    
    @Test
    public void should_exclude_headers_which_are_not_in_invoice_header() throws Exception {
        String[] header = {"invoiceNumber",
                "dateOfInvoice",
                "dummyHeader"};

        ArrayList<String[]> entries = new ArrayList<String[]>();
        entries.add(new String[] {"1", "2", "3"});
        entries.add(new String[] {"4", "5", "6"});
        List<Map<String, String>> result = new ColumnMapper(header, entries).mapedList();
        assertThat(result.get(0).get("dummyHeader"), equalTo(null));
        
    }
}