package kabbadi.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MoneyTest {

    private Money ten = new Money(new BigDecimal(10));
    private Money two = new Money(new BigDecimal(2));

    @Test
    public void testEqualTo() throws Exception {
        assertThat(ten.equalTo(ten), equalTo(true));
        assertThat(ten.equalTo(two), equalTo(false));
    }

    @Test
    public void testTimes() throws Exception {
        assertTrue(ten.times(ten).equalTo(new Money(new BigDecimal(100))));
        assertTrue(ten.times(two).equalTo(new Money(new BigDecimal(20))));
    }
    
    @Test
    public void addTest() {
        assertTrue(ten.add(two).equalTo(new Money(new BigDecimal(12))));
        assertTrue(two.add(two).equalTo(new Money(new BigDecimal(4))));
    }

    @Test
    public void minusTest() {
        assertTrue(ten.minus(two).equalTo(new Money(new BigDecimal(8))));
        assertTrue(ten.minus(ten).equalTo(new Money(new BigDecimal(0))));
    }

    @Test
    public void divideByTest() {
//        assertTrue(ten.divideBy(two).equalTo(new Money(new BigDecimal(5))));
//        assertTrue(two.divideBy(ten).equalTo(new Money(new BigDecimal(0.2))));
    }
}
