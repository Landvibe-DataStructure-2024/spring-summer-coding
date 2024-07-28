package landvibe.springintro.core.deposit.policy;

import landvibe.springintro.core.member.Role;

import static landvibe.springintro.core.member.Role.*;

public class RateBonusPolicy implements BonusPolicy {
    private static final int RATE = 10;

    @Override
    public Long calculate(Role role, Long amount) {
        if (role == ROLE_VIP) {
            return amount * RATE / 100;
        }
        return 0L;
    }
}
