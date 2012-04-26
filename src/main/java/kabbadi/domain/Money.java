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
        Money answer = new Money(amount.divide(variable.getAmount()));
//        System.out.println(answer.getAmount());
        System.out.println(new Money(new BigDecimal(0.2)).getAmount().setScale(2, RoundingMode.DOWN));
//        System.out.println(new Money(variable.getAmount()).getAmount());

        return answer;
    }
}
