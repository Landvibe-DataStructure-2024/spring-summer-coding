package landvibe.springintro.core.deposit.service;

import landvibe.springintro.core.deposit.policy.FixBonusPolicy;
import landvibe.springintro.core.deposit.policy.BonusPolicy;
import landvibe.springintro.core.deposit.policy.RateBonusPolicy;
import landvibe.springintro.core.member.Member;
import landvibe.springintro.core.member.Role;
import landvibe.springintro.core.member.repository.MemberRepository;
import landvibe.springintro.core.member.repository.MemoryMemberRepository;
import landvibe.springintro.core.money.Money;

import java.util.HashMap;
import java.util.Map;

public class DepositServiceImpl implements DepositService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final Map<String, BonusPolicy> policyMap;

    /**
     * 전략 패턴
     */
    public DepositServiceImpl() {
        policyMap = new HashMap<>();
        policyMap.put("fixBonusPolicy", new FixBonusPolicy());
        policyMap.put("rateBonusPolicy", new RateBonusPolicy());
    }

    @Override
    public void deposit(Long memberId, Long amount, String policy) {
        Member member = memberRepository.findById(memberId);
        Money finalDepositMoney = calculateFinalDepositMoney(member.getRole(), policyMap.get(policy), amount);
        member.deposit(finalDepositMoney);
    }

    private Money calculateFinalDepositMoney(Role role, BonusPolicy policy, Long amount) {
        Long bonusAmount = policy.calculate(role, amount);
        return new Money(amount + bonusAmount);
    }

}
