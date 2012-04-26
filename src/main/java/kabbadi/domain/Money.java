package kabbadi.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean equalTo(Money money) {
        return amount.equals(money.amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Money times(Money variable) {
        return new Money(amount.multiply(variable.getAmount()));
    }


    public Money add(Money variable) {
        return new Money(amount.add(variable.getAmount()));
    }

    public Money minus(Money variable) {
        return new Money(amount.subtract(variable.getAmount()));
    }

    // TODO : Needs a closer look at BigDecimal
    public Money divideBy(Money variable) {
        return new Money(amount.divide(variable.getAmount()));
    }

    public String displayAmount() {
        return amount.setScale(2, RoundingMode.HALF_EVEN).toString();
    }
}
