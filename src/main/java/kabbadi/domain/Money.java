package kabbadi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Money {

    public static final String DEFAULT_CURRENCY = "INR";

    private BigDecimal amount;
    private String currency;

    public Money(String currency, BigDecimal amount) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equalTo(Money money) {
        return amount.equals(money.amount);
    }

    public Money times(Money variable) {
        return new Money(currency, amount.multiply(variable.getAmount()));
    }


    public Money add(Money variable) {
        return new Money(currency, amount.add(variable.getAmount()));
    }

    public Money minus(Money variable) {
        return new Money(currency, amount.subtract(variable.getAmount()));
    }

    public Money divideBy(Money variable) {
        return new Money(currency, amount.divide(variable.getAmount()));
    }

    public String displayAmount() {
        return (amount == null) ? "" : amount.setScale(2, RoundingMode.HALF_EVEN).toString();
    }
}
