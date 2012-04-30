package migration;

import au.com.bytecode.opencsv.CSVReader;
import kabbadi.migration.CSVParser;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CSVParserTest {
    @Test
    public void should_map_items_to_column_names() {
        String[] columns = {"a", "b", "c"};
        ArrayList<String[]> entries = new ArrayList<String[]>();
        entries.add(new String[] {"1", "2", "3"});
        entries.add(new String[] {"4", "5", "6"});
        List<Map<String, String>> result = new CSVParser(columns, entries).mapedList();
        
        assertThat(result.get(0).get("a"), equalTo("1"));
        assertThat(result.get(1).get("b"), equalTo("5"));
    }
}