package landvibe.springintro.core.deposit.policy;

import landvibe.springintro.core.member.Role;

import static landvibe.springintro.core.member.Role.*;

public class FixBonusPolicy implements BonusPolicy {
    private static final long FIX_AMOUNT = 1000L;

    @Override
    public Long calculate(Role role, Long amount) {
        if (role == ROLE_VIP) {
            return FIX_AMOUNT;
        }
        return 0L;
    }
}
