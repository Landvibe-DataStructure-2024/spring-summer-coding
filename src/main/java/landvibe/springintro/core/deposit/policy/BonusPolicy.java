package landvibe.springintro.core.deposit.policy;

import landvibe.springintro.core.member.Role;

public interface BonusPolicy {
    Long calculate(Role role, Long amount);
}
