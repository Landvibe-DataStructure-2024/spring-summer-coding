package landvibe.springintro.core.member.web;

import landvibe.springintro.core.member.Member;
import landvibe.springintro.core.member.Role;
import landvibe.springintro.core.member.service.MemberService;
import landvibe.springintro.core.member.service.MemberServiceImpl;
import landvibe.springintro.core.money.Money;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/core/members")
public class MemberController {

    private final MemberService memberService = new MemberServiceImpl();

    @GetMapping("/new")
    public String joinForm() {
        return "core/members/createMemberForm";
    }

    @PostMapping("/new")
    public String join(@ModelAttribute MemberJoinForm memberJoinForm) {
        Member member = convertToMember(memberJoinForm);
        memberService.join(member);
        return "redirect:/core";
    }

    @GetMapping
    public String list(Model model) {
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("members", members);
        return "core/members/memberList";
    }

    /**
     * form 객체를 domain 객체로 변환해주는 Converter 클래스를 따로 생성해도 괜찮습니다.
     * 편의성을 위해 우선 private 메소드로 만들었습니다.
     * 사실 Controller(Web) 계층에 Member 라는 객체를 노출시키는 것은 그렇게 좋은 코드는 아닙니다.
     * 코드의 양을 줄이고 Spring Core 에 더 집중하기 위해서 이렇게 작성합니다.
     */
    private Member convertToMember(MemberJoinForm form) {
        String name = form.getName();
        Role role = form.getRole();
        Long balance = form.getBalance();
        return new Member(name, role, new Money(balance));
    }
}
