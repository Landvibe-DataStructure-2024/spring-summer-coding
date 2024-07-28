package landvibe.springintro.core.money;

public class MoneyUtil {
    public static Money add(Money a, Money b) {
        return new Money(a.getAmount() + b.getAmount());
    }
}
