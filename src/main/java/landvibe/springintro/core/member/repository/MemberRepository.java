package landvibe.springintro.core.member.repository;

import landvibe.springintro.core.member.Member;

import java.util.List;

public interface MemberRepository {
    Long save(Member member);

    Member findById(Long id);

    List<Member> findAll();
}
