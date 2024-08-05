package landvibe.springintro.core.config;

import landvibe.springintro.core.deposit.policy.BonusPolicy;
import landvibe.springintro.core.deposit.policy.FixBonusPolicy;
import landvibe.springintro.core.deposit.policy.RateBonusPolicy;
import landvibe.springintro.core.deposit.service.DepositService;
import landvibe.springintro.core.deposit.service.DepositServiceImpl;
import landvibe.springintro.core.member.repository.MemberRepository;
import landvibe.springintro.core.member.repository.MemoryMemberRepository;
import landvibe.springintro.core.member.service.MemberService;
import landvibe.springintro.core.member.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DepositService depositService(Map<String, BonusPolicy> policyMap) {
        return new DepositServiceImpl(memberRepository(), policyMap);
    }

    /**
     * BonusPolicy
     */
    @Bean
    public Map<String, BonusPolicy> policyMap(List<BonusPolicy> bonusPolicies) {
        Map<String, BonusPolicy> policyMap = new HashMap<>();
        for (BonusPolicy policy : bonusPolicies) {
            if (policy instanceof FixBonusPolicy) {
                policyMap.put("fixBonusPolicy", policy);
            }
            if (policy instanceof RateBonusPolicy) {
                policyMap.put("rateBonusPolicy", policy);
            }
        }
        return policyMap;
    }

    @Bean
    public BonusPolicy fixBonusPolicy() {
        return new FixBonusPolicy();
    }

    @Bean
    public BonusPolicy rateBonusPolicy() {
        return new RateBonusPolicy();
    }

}
