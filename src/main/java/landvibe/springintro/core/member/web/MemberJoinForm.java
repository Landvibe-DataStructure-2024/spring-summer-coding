package landvibe.springintro.core.member.web;

import landvibe.springintro.core.member.Role;

public class MemberJoinForm {
    private String name;

    private Role role;

    /**
     * 잔액
     */
    private Long balance;

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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
