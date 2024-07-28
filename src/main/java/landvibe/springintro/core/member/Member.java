package landvibe.springintro.core.member;

import landvibe.springintro.core.money.Money;
import landvibe.springintro.core.money.MoneyUtil;

public class Member {
    private Long id;

    private String name;

    private Role role;
    private Money money;

    public Member(String name, Role role, Money money) {
        this.name = name;
        this.role = role;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void deposit(Money money) {
        this.money = MoneyUtil.add(this.money, money);
    }
}
