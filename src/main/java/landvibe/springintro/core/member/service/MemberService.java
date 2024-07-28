package landvibe.springintro.core.member.service;

import landvibe.springintro.core.member.Member;

import java.util.List;

public interface MemberService {
    Long join(Member member);

    Member findMember(Long id);

    List<Member> findAllMembers();
}
