package kabbadi.domain;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean equalTo(Money money) {
        return (amount.equals(money.amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
