package landvibe.springintro.core.money;

/**
 * 불변 객체
 */
public class Money {
    private Long amount;

    public Money(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

}
