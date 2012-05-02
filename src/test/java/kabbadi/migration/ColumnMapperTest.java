package kabbadi.migration;

import kabbadi.migration.ColumnMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ColumnMapperTest {
    @Test
    public void should_map_items_to_column_names() {
        String[] columns = {"a", "b", "c"};
        ArrayList<String[]> entries = new ArrayList<String[]>();
        entries.add(new String[] {"1", "2", "3"});
        entries.add(new String[] {"4", "5", "6"});
        List<Map<String, String>> result = new ColumnMapper(columns, entries).mapedList();
        assertThat(result.get(0).get("a"), equalTo("1"));
        assertThat(result.get(1).get("b"), equalTo("5"));
    }
}