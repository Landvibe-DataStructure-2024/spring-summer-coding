package landvibe.springintro.core;


import jakarta.annotation.PostConstruct;
import landvibe.springintro.core.member.Member;
import landvibe.springintro.core.member.Role;
import landvibe.springintro.core.member.repository.MemberRepository;
import landvibe.springintro.core.money.Money;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final MemberRepository repository;

    public DataInitializer(MemberRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        Money money = new Money(10000L);
        Member member = new Member("땅울림", Role.ROLE_VIP, money);
        repository.save(member);
    }

}
