package kabbadi.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PreviousBondNumberConverterTest {

    @Test
    public void should_return_previous_bond_number() {
        assertThat(new PreviousBondNumberConverter("02/11-12").getPreviousBondNumber(), equalTo("01/11-12"));
        assertThat(new PreviousBondNumberConverter("03/12-13").getPreviousBondNumber(), equalTo("02/12-13"));
        assertThat(new PreviousBondNumberConverter("01/12-13").getPreviousBondNumber(), equalTo("%/11-12"));
        assertThat(new PreviousBondNumberConverter("01/11-12").getPreviousBondNumber(), equalTo("%/10-11"));
        assertThat(new PreviousBondNumberConverter("01/09-10").getPreviousBondNumber(), equalTo("%/08-09"));
    }

    @Test
    public void should_return_empty_string_when_its_invalid() {
        assertThat(new PreviousBondNumberConverter("7864asda").getPreviousBondNumber(), equalTo(""));
    }
}
