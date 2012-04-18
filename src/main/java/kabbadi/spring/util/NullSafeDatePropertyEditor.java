package kabbadi.spring.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NullSafeDatePropertyEditor extends PropertyEditorSupport {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public void setAsText(String date) {
        if (date == null) {
            setValue(null);
            return;
        }
        try {
            setValue(new SimpleDateFormat(DATE_FORMAT).parse(date));
        } catch (ParseException ignored) {
        }
    }
}
