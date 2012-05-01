package kabbadi.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InvoiceUtilsTest {

    @Test
    public void should_return_previous_bond_number() {
        assertThat(InvoiceUtils.getPreviousBondNumber("02/11-12"), equalTo("01/11-12"));
        assertThat(InvoiceUtils.getPreviousBondNumber("03/12-13"), equalTo("02/12-13"));
        assertThat(InvoiceUtils.getPreviousBondNumber("01/12-13"), equalTo("%/11-12"));
        assertThat(InvoiceUtils.getPreviousBondNumber("01/11-12"), equalTo("%/10-11"));
        assertThat(InvoiceUtils.getPreviousBondNumber("01/09-10"), equalTo("%/08-09"));
    }

    @Test
    public void should_return_empty_string_when_its_invalid() {
        assertThat(InvoiceUtils.getPreviousBondNumber("7864asda"), equalTo(""));
    }
}
