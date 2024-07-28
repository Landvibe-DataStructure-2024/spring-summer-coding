package landvibe.springintro.core.member.repository;

import landvibe.springintro.core.member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Long save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
