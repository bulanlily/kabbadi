package kabbadi.migration;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SQLGeneratorTest {
    @Test
    public void should_create_insert_statements(){
        List<Map<String, String>> entries = new ArrayList<Map<String, String>>();

        entries.add(new HashMap<String, String>() {{
            put("invoice_id", "0");
            put("invoiceNumber", "1");
            put("location", "2");
            put("dateOfInvoice", "3");
        }});

        entries.add(new HashMap<String, String>() {{
            put("invoiceNumber", "4");
            put("location", "5");
            put("dateOfInvoice", "6");
            put("currency", "5");
            put("bondDate", "6");
        }});

        entries.add(new HashMap<String, String>() {{
            put("invoiceNumber", "r");
            put("currency", "2");
            put("bondDate", "3");
        }});

        List<String> inserts = new SQLGenerator(entries).createInsertStatements();
        Pattern brackets = Pattern.compile("\\((.+?)\\)");
        Matcher matcher = brackets.matcher(inserts.get(0));
        Set<String> actualColumns, actualValues;

        matcher.find();
        actualColumns = Sets.newHashSet(matcher.group(1).split(", "));

        matcher.find();
        actualValues = Sets.newHashSet(matcher.group(1).split(", "));

        Set<String> expectedColumns = entries.get(0).keySet();
        Set<String> expectedValues = Sets.newHashSet(entries.get(0).values());
        assertThat(inserts.size(), equalTo(3));
        assertThat(actualColumns, equalTo(expectedColumns));
        assertThat(actualValues, equalTo(expectedValues));
    }

}
