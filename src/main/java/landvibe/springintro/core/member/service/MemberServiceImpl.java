package landvibe.springintro.core.member.service;

import landvibe.springintro.core.member.Member;
import landvibe.springintro.core.member.repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long join(Member member) {
        return repository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Member> findAllMembers() {
        return repository.findAll();
    }
}
