package kabbadi.spring.util;

import kabbadi.domain.Money;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

public class MoneyPropertyEditor extends PropertyEditorSupport {

    public void setAsText(String value) {
        if (value == null) {
            setValue(null);
            return;
        }
        try {
            setValue(new Money(new BigDecimal(value)));
        } catch (Exception ignored) {
        }
    }
}
