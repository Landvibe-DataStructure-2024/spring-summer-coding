package landvibe.springintro.core.deposit.service;

import landvibe.springintro.core.deposit.policy.BonusPolicy;
import landvibe.springintro.core.member.Member;
import landvibe.springintro.core.member.Role;
import landvibe.springintro.core.member.repository.MemberRepository;
import landvibe.springintro.core.money.Money;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DepositServiceImpl implements DepositService {

    private final MemberRepository memberRepository;
    private final Map<String, BonusPolicy> policyMap;

    public DepositServiceImpl(MemberRepository memberRepository, Map<String, BonusPolicy> policyMap) {
        this.memberRepository = memberRepository;
        this.policyMap = policyMap;
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
