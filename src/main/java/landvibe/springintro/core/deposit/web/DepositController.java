package landvibe.springintro.core.deposit.web;

import landvibe.springintro.core.deposit.service.DepositService;
import landvibe.springintro.core.member.Member;
import landvibe.springintro.core.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/core/deposit")
public class DepositController {
    private final MemberService memberService;
    private final DepositService depositService;

    public DepositController(MemberService memberService, DepositService depositService) {
        this.memberService = memberService;
        this.depositService = depositService;
    }

    @GetMapping
    public String depositForm(Model model) {
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("members", members);
        return "core/deposit/depositForm";
    }

    @PostMapping
    public String deposit(@ModelAttribute DepositForm depositForm) {
        depositService.deposit(depositForm.getMemberId(), depositForm.getAmount(), depositForm.getPolicy());
        return "redirect:/core";
    }
}
